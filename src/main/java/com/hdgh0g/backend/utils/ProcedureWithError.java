package com.hdgh0g.backend.utils;

@FunctionalInterface
public interface ProcedureWithError<E extends Exception> {
    void process() throws E;
}
