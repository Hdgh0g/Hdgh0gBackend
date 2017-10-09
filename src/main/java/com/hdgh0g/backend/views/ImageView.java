package com.hdgh0g.backend.views;

import com.hdgh0g.backend.domain.Image;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageView {

    public static String STORAGE_PREFIX;

    private Long id;
    private String url;
    private String thumbnailUrl;

    public ImageView(Image image) {
        this.id = image.getId();
        this.url = STORAGE_PREFIX + image.getUrl();
        this.thumbnailUrl = STORAGE_PREFIX + image.getThumbnailUrl();
    }
}
