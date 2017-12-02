package com.hdgh0g.backend.test_utils;

import com.hdgh0g.backend.domain.Image;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public final class ImageTestUtils {

    private ImageTestUtils(){
    }

    public static Image randomImage(TestEntityManager em) {
        return em.persist(Image.builder()
                .url(randomAlphabetic(100))
                .thumbnailUrl(randomAlphabetic(100)).build());
    }
}
