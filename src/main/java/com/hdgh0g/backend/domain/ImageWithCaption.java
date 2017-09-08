package com.hdgh0g.backend.domain;

import com.fasterxml.jackson.annotation.JsonView;
import com.hdgh0g.backend.views.ImageWithCaptionView.*;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "images_with_caption")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = {"id", "image"})
public class ImageWithCaption {

    @Id
    @JsonView(IdView.class)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_with_caption_id_seq")
    @SequenceGenerator(name = "images_with_caption_id_seq", sequenceName = "images_with_caption_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonView(ImageView.class)
    private Image image;

    @JsonView(CaptionView.class)
    private String caption;
}