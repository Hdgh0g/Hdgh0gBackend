package com.hdgh0g.backend.repositories.game;

import com.hdgh0g.backend.domain.game.BlotImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlotImageRepo extends CrudRepository<BlotImage, Long> {
}
