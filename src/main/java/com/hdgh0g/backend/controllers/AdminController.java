package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.services.AdminService;
import com.hdgh0g.backend.utils.ControllerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/admin", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void login(String password) throws ApiException {
        ControllerUtils.getOrThrowApiException(() -> adminService.checkPassword(password));
    }
}
