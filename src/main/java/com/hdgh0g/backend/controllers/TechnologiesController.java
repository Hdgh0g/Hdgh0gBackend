package com.hdgh0g.backend.controllers;

import com.google.common.collect.Lists;
import com.hdgh0g.backend.services.TechnologiesManager;
import com.hdgh0g.backend.views.TechnologyView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/technologies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TechnologiesController {

    private final TechnologiesManager technologiesManager;

    @Autowired
    public TechnologiesController(TechnologiesManager technologiesManager) {
        this.technologiesManager = technologiesManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<TechnologyView> getTechnologies() {
        return Lists.transform(technologiesManager.getTechnologies(), TechnologyView::new);
    }
}
