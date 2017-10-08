package com.hdgh0g.backend.services;

import com.hdgh0g.backend.exceptions.ServiceException;

public interface AdminManager {
    void checkPassword(String password) throws ServiceException;
}
