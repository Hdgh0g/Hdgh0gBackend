package com.hdgh0g.backend.test_utils;

import com.hdgh0g.backend.domain.game.MainImage;
import com.hdgh0g.backend.domain.game.PlacedBlot;
import com.hdgh0g.backend.domain.game.Position;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.concurrent.ThreadLocalRandom;

public final class PlacedBlotTestUtils {

    private PlacedBlotTestUtils() {
    }

    public static PlacedBlot randomBlot(TestEntityManager em, Long testId) {
        MainImage mainImage = em.find(MainImage.class, testId);
        return em.persist(PlacedBlot.builder()
                .blotImage(BlotImageTestUtils.randomImage(em))
                .mainImage(mainImage)
                .position(randomPosition())
                .build());
    }

    public static Position randomPosition() {
        return new Position(
                ThreadLocalRandom.current().nextDouble(0, 100),
                ThreadLocalRandom.current().nextDouble(0, 100)
        );
    }
}
