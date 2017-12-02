package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Image;
import com.hdgh0g.backend.domain.ImageWithCaption;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.repositories.ImageRepo;
import com.hdgh0g.backend.repositories.ImageWithCaptionRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.hdgh0g.backend.exceptions.ServiceException.Reason.CANT_SAVE_IMAGE;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageWithCaptionRepo imageWithCaptionRepo;
    private final ImageRepo imageRepo;
    private final MultipartImageTransformService multipartImageTransformService;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Image CreateImage(MultipartFile file) throws ServiceException {
        Image image;
        try {
            image = multipartImageTransformService.transformToImage(file);
        } catch (IOException e) {
            throw new ServiceException(CANT_SAVE_IMAGE, e);
        }
        return imageRepo.save(image);
    }

    @Override
    public ImageWithCaption CreateImageWithCaption(MultipartFile file, String caption) throws ServiceException {
        Image image;
        try {
            image = multipartImageTransformService.transformToImage(file);
        } catch (IOException e) {
            throw new ServiceException(CANT_SAVE_IMAGE);
        }
        ImageWithCaption withCaption = ImageWithCaption.builder()
                .caption(caption)
                .image(image)
                .build();
        return imageWithCaptionRepo.save(withCaption);
    }

    @Override
    public Page<ImageWithCaption> findAll(Pageable pageable) {
        return imageWithCaptionRepo.findAll(pageable);
    }

    @Override
    public void deleteImageWithCaption(Long id) {
        try {
            imageWithCaptionRepo.deleteById(id);
        } catch (EmptyResultDataAccessException ignored) {
            logger.info("Removing not existing image with caption id = {}", id);
        } //No problem. Just delete not existing image
    }
}
