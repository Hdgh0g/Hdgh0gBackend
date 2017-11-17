package com.hdgh0g.backend.request;

import com.hdgh0g.backend.domain.Technology;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnologyRequest {

    private String caption;
    private ImageRequest.Id image;

    public Technology toTechnology() {
        Technology technology = new Technology();
        technology.setCaption(caption);
        technology.setImage(image.toImage());
        return technology;
    }

}