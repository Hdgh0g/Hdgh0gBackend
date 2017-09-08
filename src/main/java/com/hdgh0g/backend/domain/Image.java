package com.hdgh0g.backend.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static com.hdgh0g.backend.views.ImageView.*;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id", "url"})
@Builder
public class Image {

    @Transient
    public static String storagePrefix;

    @Id
    @JsonView(IdView.class)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "images_id_seq")
    @SequenceGenerator(name = "images_id_seq", sequenceName = "images_id_seq", allocationSize = 1)
    private Long id;

    @JsonProperty(access = WRITE_ONLY)
    @NonNull
    private String url;

    @JsonProperty(access = WRITE_ONLY)
    @NonNull
    private String thumbnailUrl;

    @JsonProperty("url")
    @JsonView(UrlView.class)
    public String getCompletedUrl() {
        return storagePrefix + url;
    }

    @JsonProperty("thumbnailUrl")
    @JsonView(ThumbnailUrlView.class)
    public String getCompletedThumbnailUrl() {
        return storagePrefix + thumbnailUrl;
    }
}
