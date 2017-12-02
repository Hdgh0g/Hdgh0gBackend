package com.hdgh0g.backend.test_utils;

import com.hdgh0g.backend.domain.game.BlotImage;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public final class BlotImageTestUtils {

    private BlotImageTestUtils(){
    }

    public static BlotImage randomImage(TestEntityManager em) {
        BlotImage entity = new BlotImage();
        entity.setImage(ImageTestUtils.randomImage(em));
        return em.persist(entity);
    }
}
