package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.game.MainImage;
import com.hdgh0g.backend.exceptions.ServiceException;

public interface MainImageService {
    MainImage getMainImage() throws ServiceException;
}
