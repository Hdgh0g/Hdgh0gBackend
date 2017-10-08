package com.hdgh0g.backend.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.views.ErrorView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @JsonView(ErrorView.DefaultView.class)
    public ResponseEntity<ApiException> handleException(Exception e) {
        ApiException apiException = new ApiException(e);
        return handleApiException(apiException);
    }

    @ExceptionHandler(ApiException.class)
    @JsonView(ErrorView.DefaultView.class)
    public ResponseEntity<ApiException> handleApiException(ApiException e) {
        return new ResponseEntity<>(e, e.getStatus());
    }
}
