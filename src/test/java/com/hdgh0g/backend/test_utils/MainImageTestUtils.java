package com.hdgh0g.backend.test_utils;

import com.hdgh0g.backend.domain.game.MainImage;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public final class MainImageTestUtils {

    private MainImageTestUtils() {
    }

    public static MainImage randomMainImage(TestEntityManager em) {
        MainImage entity = new MainImage();
        entity.setImage(ImageTestUtils.randomImage(em));
        return em.persist(entity);
    }


}
