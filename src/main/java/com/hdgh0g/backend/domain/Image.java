package com.hdgh0g.backend.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "url"})
@Builder
public class Image {

    public static final String SEQUENCE_NAME = "images_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    private String url;

    private String thumbnailUrl;

}
