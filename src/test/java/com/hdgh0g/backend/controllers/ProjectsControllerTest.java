package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.domain.Project;
import com.hdgh0g.backend.services.ProjectsService;
import com.hdgh0g.backend.test_utils.ProjectTestUtils;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ProjectsController.class)
@ContextConfiguration(classes = TestMvcConfiguration.class)
public class ProjectsControllerTest {

    @Autowired
    private MockMvcRequestSpecification given;

    @MockBean
    private ProjectsService projectsService;

    @Test
    public void testProjectsList() {
        List<Project> randomProjects = IntStream.range(0, ThreadLocalRandom.current().nextInt(5, 10))
                .mapToObj(i -> ProjectTestUtils.randomProject())
                .collect(Collectors.toList());
        Mockito.doReturn(randomProjects).when(projectsService).getProjects();

        given.when()
                .get(ProjectsController.PATH)
                .then()
                .log().body()
                .assertThat(status().isOk());
    }
}
