package com.hdgh0g.backend.domain;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_with_caption_id_seq")
    @SequenceGenerator(name = "images_with_caption_id_seq", sequenceName = "images_with_caption_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Image image;

    private String caption;
}