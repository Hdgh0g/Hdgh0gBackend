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

    public static final String SEQUENCE_NAME = "images_with_caption_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Image image;

    private String caption;
}