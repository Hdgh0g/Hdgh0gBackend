package com.hdgh0g.backend.controllers;

import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

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
        logger.error("Api Exception", e);
        return new ResponseEntity<>(e, e.getStatus());
    }
}
