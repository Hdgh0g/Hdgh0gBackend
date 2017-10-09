package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.exceptions.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiException> handleException(AccessDeniedException e) {
        ApiException apiException = new ApiException(new ServiceException(ServiceException.Reason.NOT_AUTHORIZED));
        return handleApiException(apiException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> handleException(Exception e) {
        ApiException apiException = new ApiException(e);
        return handleApiException(apiException);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiException> handleApiException(ApiException e) {
        return new ResponseEntity<>(e, e.getStatus());
    }
}
