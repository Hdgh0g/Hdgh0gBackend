package com.hdgh0g.backend.test_utils.catcher;

@FunctionalInterface
public interface ExceptionThrower {
    void throwException() throws Throwable;
}