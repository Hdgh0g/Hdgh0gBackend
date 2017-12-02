package com.hdgh0g.backend.utils;

@FunctionalInterface
public interface SupplierWithError<T, E extends Exception> {
    T get() throws E;
}
