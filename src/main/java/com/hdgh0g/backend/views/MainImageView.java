package com.hdgh0g.backend.views;

import com.google.common.collect.Lists;
import com.hdgh0g.backend.domain.game.MainImage;
import com.hdgh0g.backend.domain.game.PlacedBlot;
import com.hdgh0g.backend.domain.game.Position;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MainImageView {

    private Long id;
    private ImageView image;
    private List<PlacedBlotView> blots;

    public MainImageView(MainImage mainImage) {
        this.id = mainImage.getId();
        this.image = new ImageView(mainImage.getImage());
        this.blots = Lists.transform(mainImage.getBlots().subList(0, MainImage.SIZE_TO_SHOW), PlacedBlotView::new);
    }
}

@Getter
@Setter
class PlacedBlotView {

    private Long id;
    private Position position;
    private ImageView image;

    PlacedBlotView(PlacedBlot placedBlot) {
        this.id = placedBlot.getId();
        this.position = placedBlot.getPosition();
        this.image = new ImageView(placedBlot.getBlotImage().getImage());
    }
}
