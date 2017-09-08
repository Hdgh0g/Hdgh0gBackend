package com.hdgh0g.backend.services;

import com.hdgh0g.backend.repositories.TechnologiesRepo;
import com.hdgh0g.backend.domain.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologiesManager {

    private final TechnologiesRepo technologiesRepo;

    @Autowired
    public TechnologiesManager(TechnologiesRepo technologiesRepo) {
        this.technologiesRepo = technologiesRepo;
    }

    public List<Technology> getTechnologies() {
        return technologiesRepo.findAll();
    }
}
