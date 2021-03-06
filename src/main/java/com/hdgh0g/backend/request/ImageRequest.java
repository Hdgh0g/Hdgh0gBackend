package com.hdgh0g.backend.request;

import com.hdgh0g.backend.domain.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;


public class ImageRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Id {

        @NotNull
        private Long id;

        public Image toImage() {
            Image image = new Image();
            image.setId(id);
            return image;
        }

    }

}
