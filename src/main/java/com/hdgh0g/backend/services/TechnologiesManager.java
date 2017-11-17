package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Technology;
import com.hdgh0g.backend.repositories.TechnologiesRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologiesManager {

    private final TechnologiesRepo technologiesRepo;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    public List<Technology> getTechnologies() {
        return technologiesRepo.findAll();
    }

    public List<Technology> createTechnologyAndReturnList(Technology technology) {
        technologiesRepo.save(technology);
        return getTechnologies();
    }

    public List<Technology> delete(Long id) {
        try {
            technologiesRepo.deleteById(id);
        } catch (EmptyResultDataAccessException ignored) {
            logger.info("Removing not existing technology with id = {}", id);
        }
        return getTechnologies();
    }
}