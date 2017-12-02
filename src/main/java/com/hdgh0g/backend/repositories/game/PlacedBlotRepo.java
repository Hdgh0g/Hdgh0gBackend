package com.hdgh0g.backend.repositories.game;

import com.hdgh0g.backend.domain.game.PlacedBlot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacedBlotRepo extends CrudRepository<PlacedBlot, Long> {
}
