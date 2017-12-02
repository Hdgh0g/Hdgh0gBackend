package com.hdgh0g.backend.exceptions;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ServiceException extends Exception {

    private final Reason reason;

    public ServiceException(Reason reason, Exception exception) {
        super(exception);
        this.reason = reason;
    }

    String getTitle() {
        return reason.getTitle();
    }

    String getDescription() {
        return reason.getDescription();
    }

    @Override
    public String getMessage() {
        return getTitle();
    }

    @RequiredArgsConstructor
    @Getter
    public enum Reason {
        NOT_AUTHORIZED("You are not authorized", "Check credentials"),
        CANT_SAVE_IMAGE("Cant save image", "Bad format or write error"),
        MAIN_IMAGE_NOT_SET("Main image not set", "You should set up main image");

        private final String title;
        private final String description;
    }
}

