package com.hdgh0g.backend.repositories;

import com.hdgh0g.backend.domain.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static com.hdgh0g.backend.test_utils.ProjectTestUtils.randomProject;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@ActiveProfiles("test")
public class ProjectsRepoTest {

    @Autowired
    private ProjectsRepo projectsRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindAll() {
        int projectsCount = ThreadLocalRandom.current().nextInt(5,10);
        IntStream
                .range(0, projectsCount)
                .forEach((i) -> randomProject(entityManager));

        List<Project> all = projectsRepo.findAll();
        assertThat(all, hasSize(projectsCount + 1)); //one from migration
    }

    @Test
    public void testFindOneFromMigration() {
        List<Project> all = projectsRepo.findAll();
        Project first = all.get(0);

        assertThat(all, not(empty()));
        assertThat(first.getTitle(), equalTo("Tripsformer"));
    }

}