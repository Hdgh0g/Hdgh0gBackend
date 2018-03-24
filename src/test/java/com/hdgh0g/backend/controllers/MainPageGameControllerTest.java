package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.domain.game.MainImage;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.request.ImageRequest;
import com.hdgh0g.backend.services.MainImageService;
import com.hdgh0g.backend.services.PlacedBlotService;
import com.hdgh0g.backend.test_utils.MainImageTestUtils;
import com.hdgh0g.backend.test_utils.RandomTestUtils;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainPageGameController.class)
@ContextConfiguration(classes = TestMvcConfiguration.class)
@MockBean(PlacedBlotService.class)
public class MainPageGameControllerTest {

    @Autowired
    private MockMvcRequestSpecification given;

    @MockBean
    private MainImageService mainImageService;

    @Test
    public void testImageNotSet() throws ServiceException {
        Mockito.doThrow(new ServiceException(ServiceException.Reason.MAIN_IMAGE_NOT_SET))
                .when(mainImageService).getMainImage();

        given.when()
                .get(MainPageGameController.PATH)
                .then()
                .log().body()
                .assertThat(status().isBadRequest());

    }

    @Test
    public void testLimitedBlots() throws ServiceException {
        Mockito.doReturn(MainImageTestUtils.randomMainImage()).when(mainImageService).getMainImage();

        given.when()
                .get(MainPageGameController.PATH)
                .then()
                .log().body()
                .assertThat(status().isOk())
                .body("blots", hasSize(MainImage.SIZE_TO_SHOW));
    }

    @Test
    @Ignore
    public void testChangeMainImage() {
        ImageRequest.Id request = new ImageRequest.Id();
        request.setId(RandomTestUtils.randomId());
        given.body(request)
                .contentType(ContentType.JSON)
                .when()
                .post(MainPageGameController.PATH)
                .then()
                .log().body()
                .assertThat(status().isCreated());
    }
}