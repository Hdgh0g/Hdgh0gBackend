package com.hdgh0g.backend.request;

import com.hdgh0g.backend.domain.Contact;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContactRequest {

    private String title;
    private String description;
    private String url;
    private ImageRequest.Id image;

    public Contact toContact() {
        Contact contact = new Contact();
        contact.setTitle(title);
        contact.setDescription(description);
        contact.setUrl(url);
        contact.setImage(image.toImage());
        return contact;
    }

}
