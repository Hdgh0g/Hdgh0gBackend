package com.hdgh0g.backend.request;

import com.hdgh0g.backend.domain.game.PlacedBlot;
import com.hdgh0g.backend.domain.game.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PlacedBlotRequest {

    @NotNull
    private Position position;
    @NotNull
    private BlotImageRequest.Id blotImage;

    public PlacedBlot toPlacedBlot() {
        return PlacedBlot.builder()
                .position(position)
                .blotImage(blotImage.toBlotImage())
                .build();
    }
}
