package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.services.ProjectsManager;
import com.jayway.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProjectsController.class)
@MockBean(ProjectsManager.class)
@ContextConfiguration(classes = TestMvcConfiguration.class)
public class ProjectsControllerTest {

    @Autowired
    private MockMvcRequestSpecification given;

    @Test
    public void testProjectsList() {
        given.when()
                .get("/projects")
                .then()
                .log().body()
                .assertThat(status().isOk());
    }
}
