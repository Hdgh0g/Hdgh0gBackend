package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.game.PlacedBlot;
import com.hdgh0g.backend.exceptions.ServiceException;

public interface PlacedBlotService {

    void sendBlot(PlacedBlot placedBlot) throws ServiceException;

}
