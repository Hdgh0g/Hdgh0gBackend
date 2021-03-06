package com.hdgh0g.backend.services;

import com.hdgh0g.backend.repositories.ProjectsRepo;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ProjectsServiceImplTestConfiguration {

    @Bean
    public ProjectsServiceImpl projectsService(ProjectsRepo pr) {
        return new ProjectsServiceImpl(pr);
    }
}
