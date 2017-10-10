package com.hdgh0g.backend.exceptions;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString(of = "title")
public class ApiException extends Exception {

    private final String title;
    private final String description;
    private final HttpStatus status;


    public ApiException(Exception e) {
        super(e);
        description = "Default api exception without correct description";
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        title = status.getReasonPhrase();
    }

    public ApiException(ServiceException e) {
        this(e, HttpStatus.BAD_REQUEST);
    }

    public ApiException(ServiceException e, HttpStatus status) {
        super(e);
        title = e.getTitle();
        description = e.getDescription();
        this.status = status;
    }

}
