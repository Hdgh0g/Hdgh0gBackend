package com.hdgh0g.backend.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.hdgh0g.backend.domain.Contact;
import com.hdgh0g.backend.services.ContactsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.hdgh0g.backend.views.ContactView.DefaultView;

@RestController
@RequestMapping(path = "/contacts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ContactsController {

    private final ContactsManager contactsManager;

    @Autowired
    public ContactsController(ContactsManager contactsManager) {
        this.contactsManager = contactsManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(DefaultView.class)
    public List<Contact> getContacts() {
        return contactsManager.getContacts();
    }
}
