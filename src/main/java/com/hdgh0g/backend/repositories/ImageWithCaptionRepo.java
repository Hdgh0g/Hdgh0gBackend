package com.hdgh0g.backend.repositories;

import com.hdgh0g.backend.domain.ImageWithCaption;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageWithCaptionRepo extends CrudRepository<ImageWithCaption, Long> {
    Page<ImageWithCaption> findAll(Pageable pageable);
}
