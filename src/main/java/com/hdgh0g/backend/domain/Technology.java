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

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "technologies_id_seq")
    @SequenceGenerator(name = "technologies_id_seq", sequenceName = "technologies_id_seq", allocationSize = 1)
    private Long id;

    private String caption;

    @ManyToOne
    private Image image;

}
