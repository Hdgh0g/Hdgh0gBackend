package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.request.ImageRequest;
import com.hdgh0g.backend.request.PlacedBlotRequest;
import com.hdgh0g.backend.security.Roles;
import com.hdgh0g.backend.services.MainImageService;
import com.hdgh0g.backend.services.PlacedBlotService;
import com.hdgh0g.backend.utils.ControllerUtils;
import com.hdgh0g.backend.views.MainImageView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = MainPageGameController.PATH, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class MainPageGameController {

    public static final String PATH = "/game";
    public static final String SEND_PATH = "/send";
    private final MainImageService mainImageService;
    private final PlacedBlotService placedBlotService;

    @GetMapping
    public MainImageView getMainImage() throws ApiException {
        return ControllerUtils.getOrThrowApiException(() -> new MainImageView(mainImageService.getMainImage()));
    }

    @Secured(Roles.ADMIN)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void changeImage(@RequestBody ImageRequest.Id imageRequest) throws ApiException {
        ControllerUtils.getOrThrowApiException(() -> mainImageService.changeImage(imageRequest.toImage()));
    }

    @PostMapping(SEND_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    public void sendBlot(@RequestBody @Validated PlacedBlotRequest placedBlotRequest) throws ApiException {
        ControllerUtils.getOrThrowApiException(() -> placedBlotService.sendBlot(placedBlotRequest.toPlacedBlot()));
    }
}
