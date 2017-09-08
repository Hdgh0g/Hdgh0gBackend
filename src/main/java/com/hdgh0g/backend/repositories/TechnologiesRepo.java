package com.hdgh0g.backend.repositories;

import com.hdgh0g.backend.domain.Technology;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologiesRepo extends CrudRepository<Technology, Long> {

    List<Technology> findAll();

}