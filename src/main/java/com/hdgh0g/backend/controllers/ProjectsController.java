package com.hdgh0g.backend.controllers;

import com.google.common.collect.Lists;
import com.hdgh0g.backend.services.ProjectsService;
import com.hdgh0g.backend.views.ProjectView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/projects", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class ProjectsController {

    private final ProjectsService projectsService;

    @RequestMapping(method = RequestMethod.GET)
    public List<ProjectView> getProjects() {
        return Lists.transform(projectsService.getProjects(), ProjectView::new);
    }
}
