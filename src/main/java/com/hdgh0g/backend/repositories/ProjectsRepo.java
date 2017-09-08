package com.hdgh0g.backend.repositories;

import com.hdgh0g.backend.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectsRepo extends CrudRepository<Project, Long> {

    List<Project> findAll();

}