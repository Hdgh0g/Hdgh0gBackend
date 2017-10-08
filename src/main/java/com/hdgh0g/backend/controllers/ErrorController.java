package com.hdgh0g.backend.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.views.ErrorView;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.hdgh0g.backend.exceptions.ServiceException.Reason.NOT_AUTHORIZED;

@RestController
@RequestMapping(path = "/error", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ErrorController {

    @RequestMapping(value = "/badAdminPassword")
    public void throwBadAdminPasswordException() throws ApiException {
        throw new ApiException(new ServiceException(NOT_AUTHORIZED), HttpStatus.FORBIDDEN);
    }

}