package com.hdgh0g.backend.views;

import com.hdgh0g.backend.domain.Contact;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactView {

    private Long id;
    private String title;
    private String description;
    private String url;
    private ImageView image;

    public ContactView(Contact contact) {
        this.id = contact.getId();
        this.title = contact.getTitle();
        this.description = contact.getDescription();
        this.url = contact.getUrl();
        this.image = new ImageView(contact.getImage());
    }

}
