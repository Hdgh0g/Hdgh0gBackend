package com.hdgh0g.backend.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"id", "title", "description"})
public class Contact {

    private static final String SEQUENCE_NAME = "contacts_id_seq";
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    private String title;

    private String description;

    private String url;

    @ManyToOne
    private Image image;
}
