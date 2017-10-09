package com.hdgh0g.backend.views;

import com.hdgh0g.backend.domain.ImageWithCaption;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageWithCaptionView {

    private Long id;
    private String caption;
    private ImageView image;

    public ImageWithCaptionView(ImageWithCaption imageWithCaption) {
        this.id = imageWithCaption.getId();
        this.caption = imageWithCaption.getCaption();
        this.image = new ImageView(imageWithCaption.getImage());
    }

}
