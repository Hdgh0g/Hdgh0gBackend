package com.hdgh0g.backend.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "projects")
@Getter
@Setter
@ToString(of = {"id", "title", "description"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    public static final String SEQUENCE_NAME = "projects_id_seq";
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @SequenceGenerator(name = SEQUENCE_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
    private Long id;

    private String title;

    private String description;

    @ManyToOne
    private Image image;

}
