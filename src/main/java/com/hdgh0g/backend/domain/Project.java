package com.hdgh0g.backend.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;

import static com.hdgh0g.backend.views.ProjectView.*;

@Entity
@Table(name = "projects")
@Getter
@Setter
@ToString(of = {"id", "title", "description"})
@NoArgsConstructor
@RequiredArgsConstructor
public class Project {

    @Id
    @JsonView(IdView.class)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "projects_id_seq")
    @SequenceGenerator(name = "projects_id_seq", sequenceName = "projects_id_seq", allocationSize = 1)
    private Long id;

    @JsonView(TitleView.class)
    @NonNull
    private String title;

    @JsonView(DescriptionView.class)
    @NonNull
    private String description;

    @ManyToOne
    @JsonView(ImageView.class)
    @NonNull
    private Image image;

}
