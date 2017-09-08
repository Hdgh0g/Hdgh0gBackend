package com.hdgh0g.backend.domain;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import static com.hdgh0g.backend.views.PostView.*;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "title", "creationTime"})
public class Post {

    @Id
    @JsonView(IdView.class)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posts_id_seq")
    @SequenceGenerator(name = "posts_id_seq", sequenceName = "posts_id_seq", allocationSize = 1)
    private Long id;

    @JsonView(TitleView.class)
    private String title;

    @JsonView(CreationTimeView.class)
    private Instant creationTime;

    @JsonView(FullTextView.class)
    private String fullText;

    @JsonView(TagsView.class)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "posts_tags",
            joinColumns = @JoinColumn(name = "post_id")
    )
    @Column(name = "tag")
    private Set<String> tags = new HashSet<>();

    @JsonView(CutTextView.class)
    public String getCutText() {
        if (StringUtils.isBlank(fullText)) {
            return "";
        }
        return fullText.split("<a name=\"hdgh0gcut\"></a>")[0];
    }

    @PrePersist
    public void prePersist() {
        creationTime = Instant.now();
    }
}
