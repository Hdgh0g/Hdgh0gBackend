package com.hdgh0g.backend.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.hdgh0g.backend.domain.Project;
import com.hdgh0g.backend.services.ProjectsManager;
import com.hdgh0g.backend.views.ProjectView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/projects", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProjectsController {

    private final ProjectsManager projectsManager;

    @Autowired
    public ProjectsController(ProjectsManager projectsManager) {
        this.projectsManager = projectsManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(ProjectView.DefaultView.class)
    public List<Project> getProjects() {
        return projectsManager.getProjects();
    }
}
