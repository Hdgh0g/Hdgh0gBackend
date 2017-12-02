package com.hdgh0g.backend.test_utils;

import com.hdgh0g.backend.domain.game.MainImage;
import com.hdgh0g.backend.domain.game.PlacedBlot;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class MainImageTestUtils {

    private MainImageTestUtils() {
    }

    public static MainImage randomMainImage(TestEntityManager em) {
        MainImage entity = MainImage.builder()
                .image(ImageTestUtils.randomImage(em))
                .build();
        return em.persist(entity);
    }

    public static MainImage randomMainImage() {
        List<PlacedBlot> blots = IntStream.range(0, ThreadLocalRandom.current().nextInt(15, 20))
                .mapToObj(i -> PlacedBlotTestUtils.randomBlot())
                .collect(Collectors.toList());
        return MainImage.builder()
                .id(Math.abs(ThreadLocalRandom.current().nextLong()))
                .image(ImageTestUtils.randomImage())
                .blots(blots)
                .build();
    }
}
