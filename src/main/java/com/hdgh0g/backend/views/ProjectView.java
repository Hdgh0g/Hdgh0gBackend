package com.hdgh0g.backend.views;

import com.hdgh0g.backend.domain.Project;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectView {

    private Long id;
    private String title;
    private String description;
    private ImageView image;

    public ProjectView(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.description = project.getDescription();
        this.image = new ImageView(project.getImage());
    }

}
