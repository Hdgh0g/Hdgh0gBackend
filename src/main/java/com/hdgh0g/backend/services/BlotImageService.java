package com.hdgh0g.backend.services;

import com.hdgh0g.backend.exceptions.ServiceException;

public interface BlotImageService {
    void checkBlotExists(Long id) throws ServiceException;
}
