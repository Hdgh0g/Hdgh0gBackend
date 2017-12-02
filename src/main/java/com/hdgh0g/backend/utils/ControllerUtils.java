package com.hdgh0g.backend.utils;

import com.hdgh0g.backend.exceptions.ApiException;
import com.hdgh0g.backend.exceptions.ServiceException;

public final class ControllerUtils {

    private ControllerUtils() {
    }

    public static <T, E extends ServiceException> T getOrThrowApiException(SupplierWithError<T, E> supplier) throws ApiException {
        try {
            return supplier.get();
        } catch (ServiceException e) {
            throw new ApiException(e);
        }
    }

    public static <E extends ServiceException> void getOrThrowApiException(ProcedureWithError<E> procedure) throws ApiException {
        try {
            procedure.process();
        } catch (ServiceException e) {
            throw new ApiException(e);
        }
    }
}