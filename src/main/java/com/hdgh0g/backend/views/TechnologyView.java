package com.hdgh0g.backend.views;

import com.hdgh0g.backend.domain.Technology;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnologyView {

    private Long id;
    private String caption;
    private ImageView image;

    public TechnologyView(Technology technology) {
        this.id = technology.getId();
        this.caption = technology.getCaption();
        this.image = new ImageView(technology.getImage());
    }
}
