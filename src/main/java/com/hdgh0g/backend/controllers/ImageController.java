package com.hdgh0g.backend.controllers;

import com.google.common.collect.Lists;
import com.hdgh0g.backend.domain.ImageWithCaption;
import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.services.ImageService;
import com.hdgh0g.backend.utils.ControllerUtils;
import com.hdgh0g.backend.views.ImageView;
import com.hdgh0g.backend.views.ImageWithCaptionView;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping(path = "/images", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ImageView uploadImage(@RequestParam("image") MultipartFile file) throws ApiException {
        return ControllerUtils.getOrThrowApiException(() -> new ImageView(imageService.CreateImage(file)));
    }

    @PostMapping("/withCaption")
    @Secured("ROLE_ADMIN")
    public ImageWithCaptionView uploadImageWithCaption(@RequestParam("image") MultipartFile file,
                                                       @RequestParam("caption") String caption) throws ApiException {
        return ControllerUtils.getOrThrowApiException(() ->
                new ImageWithCaptionView(imageService.CreateImageWithCaption(file, caption)));
    }

    @DeleteMapping("/withCaption/{id}")
    @Secured("ROLE_ADMIN")
    @ResponseStatus(NO_CONTENT)
    public void deleteImageWithCaption(@PathVariable Long id) {
        imageService.deleteImageWithCaption(id);
    }

    @GetMapping("/withCaption")
    public Page<ImageWithCaptionView> getAllImagesWithCaption(Pageable pageable) {
        Page<ImageWithCaption> all = imageService.findAll(pageable);
        return new PageImpl<>(Lists.transform(
                all.getContent(), ImageWithCaptionView::new),
                all.getPageable(),
                all.getTotalElements());
    }
}
