package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Project;
import com.hdgh0g.backend.repositories.ProjectsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsManager {

    private final ProjectsRepo projectsRepo;

    @Autowired
    public ProjectsManager(ProjectsRepo projectsRepo) {
        this.projectsRepo = projectsRepo;
    }

    public List<Project> getProjects() {
        return projectsRepo.findAll();
    }
}
