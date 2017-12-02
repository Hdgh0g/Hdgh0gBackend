package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MultipartImageTransformService {
    Image transformToImage(MultipartFile file) throws IOException;
}
