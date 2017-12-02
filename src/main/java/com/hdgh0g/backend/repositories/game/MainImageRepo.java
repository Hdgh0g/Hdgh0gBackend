package com.hdgh0g.backend.repositories.game;

import com.hdgh0g.backend.domain.game.MainImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainImageRepo extends CrudRepository<MainImage, Long> {

    default Optional<MainImage> findLast() {
        return findFirstByOrderByIdDesc();
    }

    Optional<MainImage> findFirstByOrderByIdDesc();
}
