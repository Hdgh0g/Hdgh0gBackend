package com.hdgh0g.backend.services;


import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.repositories.game.BlotImageRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlotImageServiceImpl implements BlotImageService {

    private final BlotImageRepo blotImageRepo;
    private final Logger logger = LoggerFactory.getLogger(getClass());


    @Override
    public void checkBlotExists(Long id) throws ServiceException {
        if (!blotImageRepo.existsById(id)) {
            logger.error("Checked not existing blot image with id " + id);
            throw new ServiceException(ServiceException.Reason.BLOT_IMAGE_NOT_EXISTS);
        }
    }
}
