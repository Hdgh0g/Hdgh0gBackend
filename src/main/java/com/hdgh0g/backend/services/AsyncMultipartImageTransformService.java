package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Image;
import com.hdgh0g.backend.views.ImageView;
import lombok.RequiredArgsConstructor;
import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.concurrent.Future;

@Component
@RequiredArgsConstructor
public class AsyncMultipartImageTransformService implements MultipartImageTransformService {

    private final StorageService storageService;
    private final AsyncTaskExecutor taskExecutor;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${image.size.full}")
    private Integer fullSize;

    @Value("${image.size.thumb}")
    private Integer thumbSize;

    @Value("${storage.prefix}")
    private String storagePrefix;

    @PostConstruct
    public void loadData() {
        ImageView.STORAGE_PREFIX = storagePrefix;
    }

    @Override
    public Image transformToImage(MultipartFile file) throws IOException {
        BufferedImage image;

        image = ImageIO.read(file.getInputStream());
        Future<String> fullFuture = taskExecutor.submit(() -> resizeAndSave(image, fullSize));
        Future<String> thumbFuture = taskExecutor.submit(() -> resizeAndSave(image, thumbSize));

        try {
            return Image.builder()
                    .url(fullFuture.get())
                    .thumbnailUrl(thumbFuture.get())
                    .build();
        } catch (Exception e) {
            throw new IOException(e);
        }
    }

    private String resizeAndSave(BufferedImage image, Integer size) throws IOException {
        BufferedImage resized = Scalr.resize(image, size);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resized, "jpg", baos);
        logger.info("Saving image");
        return storageService.saveFile(baos.toByteArray(), ".jpg", "images");
    }
}