package com.hdgh0g.backend.test_utils;

import com.hdgh0g.backend.domain.Project;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public final class ProjectTestUtils {

    private ProjectTestUtils() {
    }

    public static Project randomProject(TestEntityManager em) {
        return em.persist(new Project(
                randomAlphabetic(10),
                randomAlphabetic(1000),
                ImageTestUtils.randomImage(em)));
    }

}
