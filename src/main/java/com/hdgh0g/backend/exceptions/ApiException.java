package com.hdgh0g.backend.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.hdgh0g.backend.views.ErrorView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@AllArgsConstructor
@Getter
@ToString(of = "title")
public class ApiException extends Exception {

    @JsonView(ErrorView.TitleView.class)
    private final String title;

    @JsonView(ErrorView.DescriptionView.class)
    private final String description;

    @JsonIgnore
    private final HttpStatus status;

    @JsonIgnore
    private Object data;

    @JsonView(ErrorView.DataView.class)
    @JsonProperty("data")
    public String getData() {
        if (data == null) {
            return null;
        }
        if (data instanceof Error) {
            return ((Error) data).getMessage() + " " + data.getClass();
        }
        return data.toString();
    }

    private ApiException() {
        description = "Default api exception without correct description";
        status = HttpStatus.INTERNAL_SERVER_ERROR;
        title = status.getReasonPhrase();
    }

    public ApiException(Exception e) {
        this();
        data = e;
    }

    public ApiException(ServiceException e) {
        this(e, HttpStatus.BAD_REQUEST);
    }

    public ApiException(ServiceException e, HttpStatus status) {
        title = e.getTitle();
        description = e.getDescription();
        this.status = status;
    }

}
