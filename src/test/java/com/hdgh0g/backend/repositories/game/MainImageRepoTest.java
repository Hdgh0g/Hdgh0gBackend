package com.hdgh0g.backend.repositories.game;

import com.google.common.collect.Lists;
import com.hdgh0g.backend.domain.game.MainImage;
import com.hdgh0g.backend.domain.game.PlacedBlot;
import com.hdgh0g.backend.test_utils.MainImageTestUtils;
import com.hdgh0g.backend.test_utils.PlacedBlotTestUtils;
import com.hdgh0g.backend.test_utils.matchers.OrderMatcher;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureEmbeddedDatabase
public class MainImageRepoTest {

    @Autowired
    private MainImageRepo mainImageRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testFindLastOnEmptyDB() {
        Optional<MainImage> mainImage = mainImageRepo.findLast();
        MatcherAssert.assertThat(mainImage.isPresent(), equalTo(false));
    }

    @Test
    public void testFindLastOrder() {
        Long max = IntStream.range(0, ThreadLocalRandom.current().nextInt(5,10))
                .mapToLong(i -> MainImageTestUtils.randomMainImage(entityManager).getId())
                .max().getAsLong();
        Optional<MainImage> mainImage = mainImageRepo.findLast();
        MatcherAssert.assertThat(mainImage.isPresent(), equalTo(true));
        MatcherAssert.assertThat(mainImage.get().getId(), equalTo(max));
    }

    @Test
    public void testBlotsOrder() {
        Long testId = MainImageTestUtils.randomMainImage(entityManager).getId();
        int count = ThreadLocalRandom.current().nextInt(15, 20);
        IntStream.range(0, count).forEach(i -> PlacedBlotTestUtils.randomBlot(entityManager, testId));
        entityManager.flush();
        MainImage mainImage = mainImageRepo.findLast().get();
        entityManager.refresh(mainImage);
        List<Long> ids = Lists.transform(mainImage.getBlots(), PlacedBlot::getId);
        MatcherAssert.assertThat(ids, OrderMatcher.reversed());
    }

}