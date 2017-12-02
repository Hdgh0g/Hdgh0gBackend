package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.domain.game.MainImage;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.services.MainImageService;
import com.hdgh0g.backend.test_utils.MainImageTestUtils;
import com.jayway.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
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
}