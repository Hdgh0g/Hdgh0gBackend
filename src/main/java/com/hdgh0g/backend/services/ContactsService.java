package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Contact;

import java.util.List;

public interface ContactsService {
    List<Contact> getContacts();

    List<Contact> createContactAndReturnList(Contact contact);

    List<Contact> delete(Long id);
}
