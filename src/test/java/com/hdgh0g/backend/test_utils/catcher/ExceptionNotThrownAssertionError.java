package com.hdgh0g.backend.test_utils.catcher;


class ExceptionNotThrownAssertionError extends AssertionError {
    ExceptionNotThrownAssertionError() {
        super("Expected exception was not thrown.");
    }
}