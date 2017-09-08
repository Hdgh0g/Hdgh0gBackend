package com.hdgh0g.backend.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static java.io.File.separator;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

@Component
public class StorageUtilsImpl implements StorageUtils {

    @Value("${storage.filename.length}")
    private int count;
    @Value("${storage.directory}")
    private String location;

    @Override
    public String saveFile(byte[] bytes, String extension, String prefix) throws IOException {
        String realName = randomAlphabetic(count) + extension;
        String filename = location + separator + prefix + separator + realName;
        FileUtils.writeByteArrayToFile(new File(filename), bytes);
        return prefix + "/" + realName;
    }
}
