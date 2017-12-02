package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.game.MainImage;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.repositories.game.MainImageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainImageServiceImpl implements MainImageService {

    private final MainImageRepo mainImageRepo;

    @Override
    public MainImage getMainImage() throws ServiceException {
        return mainImageRepo.findLast().orElseThrow(() ->new ServiceException(ServiceException.Reason.MAIN_IMAGE_NOT_SET));
    }
}
