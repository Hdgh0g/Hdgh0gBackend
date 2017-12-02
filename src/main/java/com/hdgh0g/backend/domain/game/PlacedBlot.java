package com.hdgh0g.backend.domain.game;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "placed_blots")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = {"id", "position"})
public class PlacedBlot {

    private static final String SEQUENCE_NAME = "placed_blots_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    @Embedded
    private Position position;

    @ManyToOne
    private BlotImage blotImage;

    @ManyToOne
    private MainImage mainImage;

}
