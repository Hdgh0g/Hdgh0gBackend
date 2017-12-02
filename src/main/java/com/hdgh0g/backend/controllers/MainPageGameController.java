package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.services.MainImageService;
import com.hdgh0g.backend.utils.ControllerUtils;
import com.hdgh0g.backend.views.MainImageView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = MainPageGameController.PATH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class MainPageGameController {

    public static final String PATH = "/game";
    private final MainImageService mainImageService;

    @GetMapping
    public MainImageView getMainImage() throws ApiException {
        return ControllerUtils.getOrThrowApiException(() -> new MainImageView(mainImageService.getMainImage()));
    }
}
