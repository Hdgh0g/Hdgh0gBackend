package com.hdgh0g.backend.utils;

import com.hdgh0g.backend.domain.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageUtils {
    Image transformToImage(MultipartFile file) throws IOException;
}
