package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.services.PostsManager;
import com.hdgh0g.backend.services.ProjectsManager;
import com.jayway.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadLocalRandom;

import static com.hdgh0g.backend.test_utils.PostTestUtils.configurePost;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PostsController.class)
@MockBean(ProjectsManager.class)
@ContextConfiguration(classes = TestMvcConfiguration.class)
public class PostsControllerTest {

    @MockBean
    private PostsManager postsManager;

    @Autowired
    private MockMvcRequestSpecification given;

    @Test
    public void testGetPostByIdCallsPostsManager() throws ServiceException {

        given
                .when()
                .get("/posts/1")
                .then()
                .log().body()
                .assertThat(status().isOk());

        verify(postsManager).getPost(1L);
    }

    @Test
    public void testFullPostSchema() throws ServiceException {
        Long id = ThreadLocalRandom.current().nextLong();
        doReturn(configurePost()).when(postsManager).getPost(id);

        given
                .when()
                .get("/posts/{id}", id)
                .then()
                .log().body()
                .assertThat(status().isOk());
    }
}
