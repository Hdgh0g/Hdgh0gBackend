package com.hdgh0g.backend.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static com.hdgh0g.backend.views.TechnologyView.*;

@Entity
@Table(name = "technologies")
@Getter
@Setter
@ToString(of = {"id", "caption"})
@NoArgsConstructor
public class Technology {

    @Id
    @JsonView(IdView.class)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technologies_id_seq")
    @SequenceGenerator(name = "technologies_id_seq", sequenceName = "technologies_id_seq", allocationSize = 1)
    private Long id;

    @JsonView(CaptionView.class)
    private String caption;

    @ManyToOne
    @JsonView(ImageView.class)
    private Image image;

}
