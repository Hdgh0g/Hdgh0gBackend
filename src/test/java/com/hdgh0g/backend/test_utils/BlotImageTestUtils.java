package com.hdgh0g.backend.test_utils;

import com.hdgh0g.backend.domain.game.BlotImage;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.concurrent.ThreadLocalRandom;

public final class BlotImageTestUtils {

    private BlotImageTestUtils(){
    }

    public static BlotImage randomImage(TestEntityManager em) {
        BlotImage entity = BlotImage.builder()
                .image(ImageTestUtils.randomImage(em))
                .build();
        return em.persist(entity);
    }

    public static BlotImage randomImage() {
        return BlotImage.builder()
                .id(Math.abs(ThreadLocalRandom.current().nextLong()))
                .image(ImageTestUtils.randomImage())
                .build();
    }
}
