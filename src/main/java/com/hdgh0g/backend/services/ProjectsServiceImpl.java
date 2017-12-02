package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Project;
import com.hdgh0g.backend.repositories.ProjectsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectsServiceImpl implements ProjectsService {

    private final ProjectsRepo projectsRepo;

    public List<Project> getProjects() {
        return projectsRepo.findAll();
    }
}
