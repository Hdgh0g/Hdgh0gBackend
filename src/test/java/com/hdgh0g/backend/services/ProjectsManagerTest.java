package com.hdgh0g.backend.services;

import com.hdgh0g.backend.config.TestServiceConfiguration;
import com.hdgh0g.backend.domain.Project;
import com.hdgh0g.backend.repositories.ProjectsRepo;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.doReturn;

@RunWith(SpringRunner.class)
@ContextHierarchy({
        @ContextConfiguration(classes = TestServiceConfiguration.class),
        @ContextConfiguration(classes = ProjectsManagerTestConfiguration.class)
})
public class ProjectsManagerTest {

    @MockBean
    private ProjectsRepo projectsRepo;

    @Autowired
    private ProjectsManager projectsManager;

    @Test
    public void TestProjectsCount() {
        doReturn(2L).when(projectsRepo).count();
        doReturn(Arrays.asList(new Project(), new Project())).when(projectsRepo).findAll();

        List<Project> projects = projectsManager.getProjects();

        MatcherAssert.assertThat(projects, hasSize(((int) projectsRepo.count())));
    }

}