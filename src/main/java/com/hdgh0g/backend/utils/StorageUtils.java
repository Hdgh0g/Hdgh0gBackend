package com.hdgh0g.backend.utils;

import java.io.IOException;

public interface StorageUtils {
    String saveFile(byte[] bytes, String extension, String prefix) throws IOException;
}
