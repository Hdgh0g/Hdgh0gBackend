package com.hdgh0g.backend.domain.game;

import com.hdgh0g.backend.domain.Image;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "main_images")
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"id", "image"})
public class MainImage {

    private static final String SEQUENCE_NAME = "main_images_id_seq";
    private static final int SIZE_TO_SHOW = 10;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    @ManyToOne
    private Image image;

    @OneToMany(mappedBy = "mainImage")
    @OrderBy("id desc")
    @BatchSize(size = SIZE_TO_SHOW)
    private List<PlacedBlot> blots;

}
