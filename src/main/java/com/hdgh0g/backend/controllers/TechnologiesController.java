package com.hdgh0g.backend.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.hdgh0g.backend.domain.Technology;
import com.hdgh0g.backend.services.TechnologiesManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.hdgh0g.backend.views.TechnologyView.DefaultView;

@RestController
@RequestMapping(value = "/technologies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TechnologiesController {

    private final TechnologiesManager technologiesManager;

    @Autowired
    public TechnologiesController(TechnologiesManager technologiesManager) {
        this.technologiesManager = technologiesManager;
    }

    @JsonView(DefaultView.class)
    @RequestMapping(method = RequestMethod.GET)
    public List<Technology> getTechnologies() {
        return technologiesManager.getTechnologies();
    }
}
