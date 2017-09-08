package com.hdgh0g.backend.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static com.hdgh0g.backend.views.ContactView.*;

@Entity
@Table(name = "contacts")
@Getter
@Setter
@NoArgsConstructor
@ToString(of = {"id", "title", "description"})
public class Contact {

    @Id
    @JsonView(IdView.class)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contacts_id_seq")
    @SequenceGenerator(name = "contacts_id_seq", sequenceName = "contacts_id_seq", allocationSize = 1)
    private Long id;

    @JsonView(TitleView.class)
    private String title;

    @JsonView(DescriptionView.class)
    private String description;

    @JsonView(UrlView.class)
    private String url;

    @ManyToOne
    @JsonView(ImageView.class)
    private Image image;
}
