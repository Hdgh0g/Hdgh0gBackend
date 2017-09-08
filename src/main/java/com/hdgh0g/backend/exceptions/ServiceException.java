package com.hdgh0g.backend.exceptions;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServiceException extends Exception {

    @Getter
    final private Reason reason;

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
        CANT_SAVE_IMAGE("Cant save image", "Bad format or write error");


        private final String title;
        private final String description;
    }
}

