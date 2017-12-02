package com.hdgh0g.backend.domain.game;

import com.hdgh0g.backend.domain.Image;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "blot_images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = {"id", "image"})
public class BlotImage {

    private static final String SEQUENCE_NAME = "blot_images_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Image image;
}
