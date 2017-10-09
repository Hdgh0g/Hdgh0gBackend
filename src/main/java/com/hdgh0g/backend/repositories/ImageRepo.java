package com.hdgh0g.backend.repositories;

import com.hdgh0g.backend.domain.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo  extends CrudRepository<Image, Long> {
}
