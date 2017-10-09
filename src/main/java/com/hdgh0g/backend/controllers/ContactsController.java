package com.hdgh0g.backend.controllers;

import com.google.common.collect.Lists;
import com.hdgh0g.backend.domain.Contact;
import com.hdgh0g.backend.request.ContactRequest;
import com.hdgh0g.backend.services.ContactsManager;
import com.hdgh0g.backend.views.ContactView;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/contacts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ContactsController {

    private final ContactsManager contactsManager;

    @GetMapping
    public List<ContactView> getContacts() {
        return Lists.transform(contactsManager.getContacts(), ContactView::new);
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public List<ContactView> createContact(@RequestBody ContactRequest contactRequest) {
        Contact contact = contactRequest.toContact();
        List<Contact> contacts = contactsManager.createContactAndReturnList(contact);
        return Lists.transform(contacts, ContactView::new);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    public List<ContactView> createContact(@PathVariable Long id) {

            List<Contact> contacts = contactsManager.delete(id);
        return Lists.transform(contacts, ContactView::new);
    }
}
