package com.hdgh0g.backend.request;

import com.hdgh0g.backend.domain.game.BlotImage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

public class BlotImageRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Id {

        @NotNull
        private Long id;

        public BlotImage toBlotImage() {
            return BlotImage.builder()
                    .id(id)
                    .build();
        }

    }
}
