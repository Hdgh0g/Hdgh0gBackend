package com.hdgh0g.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "technologies")
@Getter
@Setter
@ToString(of = {"id", "caption"})
@NoArgsConstructor
public class Technology {

    public static final String SEQUENCE_NAME = "technologies_id_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    private String caption;

    @ManyToOne
    private Image image;

}
