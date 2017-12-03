package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.game.MainImage;
import com.hdgh0g.backend.domain.game.PlacedBlot;
import com.hdgh0g.backend.exceptions.ServiceException;
import com.hdgh0g.backend.repositories.game.PlacedBlotRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlacedBlotServiceImpl implements PlacedBlotService {

    private final PlacedBlotRepo placedBlotRepo;
    private final BlotImageService blotImageService;
    private final MainImageService mainImageService;

    @Override
    public void sendBlot(PlacedBlot placedBlot) throws ServiceException {
        blotImageService.checkBlotExists(placedBlot.getBlotImage().getId());
        MainImage mainImage = mainImageService.getMainImage();
        placedBlot.setMainImage(mainImage);
        placedBlotRepo.save(placedBlot);
    }
}
