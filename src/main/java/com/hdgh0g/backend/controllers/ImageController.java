package com.hdgh0g.backend.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.hdgh0g.backend.domain.ImageWithCaption;
import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.services.ImageManager;
import com.hdgh0g.backend.views.ImageWithCaptionView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(path = "/images", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class ImageController {

    private final ImageManager imageManager;

    @PostMapping("/withCaption")
    @Secured("ROLE_ADMIN")
    @JsonView(ImageWithCaptionView.DefaultView.class)
    public ImageWithCaption uploadImageWithCaption(@RequestParam("image") MultipartFile file,
                                                   @RequestParam("caption") String caption) throws ApiException {
        try {
            return imageManager.CreateImageWithCaption(file, caption);
        } catch (ServiceException e) {
            throw new ApiException(e, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/withCaption/{id}")
    @Secured("ROLE_ADMIN")
    @ResponseStatus(NO_CONTENT)
    public void deleteImageWithCaption(@PathVariable Long id) {
        imageManager.deleteImageWithCaption(id);
    }

    @GetMapping("/withCaption")
    @JsonView(ImageWithCaptionView.DefaultView.class)
    public Page<ImageWithCaption> getAllImagesWithCaption(Pageable pageable) {
        return imageManager.findAll(pageable);
    }
}
