package com.hdgh0g.backend.repositories.game;

import com.hdgh0g.backend.domain.game.PlacedBlot;
import com.hdgh0g.backend.domain.game.Position;
import com.hdgh0g.backend.test_utils.MainImageTestUtils;
import com.hdgh0g.backend.test_utils.PlacedBlotTestUtils;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureEmbeddedDatabase
public class PlacedBlotRepoTest {

    @Autowired
    private PlacedBlotRepo placedBlotRepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testPositionNotEmpty() {
        PlacedBlot placedBlot = PlacedBlotTestUtils.randomBlot(entityManager, MainImageTestUtils.randomMainImage(entityManager).getId());
        PlacedBlot blotFromRepo = placedBlotRepo.findById(placedBlot.getId()).get();
        Position position = blotFromRepo.getPosition();
        MatcherAssert.assertThat(position.getX() + position.getY(), not(equalTo(0)));
    }

}