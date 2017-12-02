package com.hdgh0g.backend.test_utils;

import com.hdgh0g.backend.domain.Project;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.concurrent.ThreadLocalRandom;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public final class ProjectTestUtils {

    private ProjectTestUtils() {
    }

    public static Project randomProject(TestEntityManager em) {
        return em.persist(Project.builder()
                .title(randomAlphabetic(10))
                .description(randomAlphabetic(1000))
                .image(ImageTestUtils.randomImage(em))
                .build()
        );
    }

    public static Project randomProject() {
        return Project.builder()
                .id(Math.abs(ThreadLocalRandom.current().nextLong()))
                .title(randomAlphabetic(10))
                .description(randomAlphabetic(1000))
                .image(ImageTestUtils.randomImage())
                .build();
    }


}
