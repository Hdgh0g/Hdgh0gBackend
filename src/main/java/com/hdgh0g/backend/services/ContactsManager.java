package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Contact;
import com.hdgh0g.backend.repositories.ContactsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsManager {

    private final ContactsRepo contactsRepo;

    @Autowired
    public ContactsManager(ContactsRepo contactsRepo) {
        this.contactsRepo = contactsRepo;
    }

    public List<Contact> getContacts() {
        return contactsRepo.findAll();
    }
}