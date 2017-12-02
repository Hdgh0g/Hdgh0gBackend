package com.hdgh0g.backend.services;

import java.io.IOException;

public interface StorageService {
    String saveFile(byte[] bytes, String extension, String prefix) throws IOException;
}
