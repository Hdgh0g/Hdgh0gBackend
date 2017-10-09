package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Image;
import com.hdgh0g.backend.domain.ImageWithCaption;
import com.hdgh0g.backend.exceptions.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface ImageManager {
    Image CreateImage(MultipartFile file) throws ServiceException;

    ImageWithCaption CreateImageWithCaption(MultipartFile file, String caption) throws ServiceException;

    Page<ImageWithCaption> findAll(Pageable pageable);

    void deleteImageWithCaption(Long id);
}
