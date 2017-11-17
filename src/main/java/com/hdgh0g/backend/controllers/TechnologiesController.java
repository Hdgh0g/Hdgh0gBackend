package com.hdgh0g.backend.controllers;

import com.google.common.collect.Lists;
import com.hdgh0g.backend.domain.Technology;
import com.hdgh0g.backend.request.TechnologyRequest;
import com.hdgh0g.backend.services.TechnologiesManager;
import com.hdgh0g.backend.views.TechnologyView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/technologies", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class TechnologiesController {

    private final TechnologiesManager technologiesManager;

    @GetMapping
    public List<TechnologyView> getTechnologies() {
        return Lists.transform(technologiesManager.getTechnologies(), TechnologyView::new);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public List<TechnologyView> createTechnology(@RequestBody TechnologyRequest request) {
        Technology technology = request.toTechnology();
        List<Technology> technologies = technologiesManager.createTechnologyAndReturnList(technology);
        return Lists.transform(technologies, TechnologyView::new);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public List<TechnologyView> deleteTechnology(@PathVariable Long id){
        List<Technology> technologies = technologiesManager.delete(id);
        return Lists.transform(technologies, TechnologyView::new);
    }
}