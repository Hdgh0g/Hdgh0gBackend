package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Technology;

import java.util.List;

public interface TechnologiesService {

    List<Technology> getTechnologies();

    List<Technology> createTechnologyAndReturnList(Technology technology);

    List<Technology> delete(Long id);
}
