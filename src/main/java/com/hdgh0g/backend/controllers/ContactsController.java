package com.hdgh0g.backend.controllers;

import com.google.common.collect.Lists;
import com.hdgh0g.backend.domain.Contact;
import com.hdgh0g.backend.request.ContactRequest;
import com.hdgh0g.backend.security.Roles;
import com.hdgh0g.backend.services.ContactsService;
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

    private final ContactsService contactsService;

    @GetMapping
    public List<ContactView> getContacts() {
        return Lists.transform(contactsService.getContacts(), ContactView::new);
    }

    @Secured(Roles.ADMIN)
    @PostMapping
    public List<ContactView> createContact(@RequestBody ContactRequest request) {
        Contact contact = request.toContact();
        List<Contact> contacts = contactsService.createContactAndReturnList(contact);
        return Lists.transform(contacts, ContactView::new);
    }

    @Secured(Roles.ADMIN)
    @DeleteMapping("/{id}")
    public List<ContactView> deleteContact(@PathVariable Long id) {
        List<Contact> contacts = contactsService.delete(id);
        return Lists.transform(contacts, ContactView::new);
    }
}
