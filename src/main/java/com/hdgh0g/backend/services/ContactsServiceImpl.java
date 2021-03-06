package com.hdgh0g.backend.services;

import com.hdgh0g.backend.domain.Contact;
import com.hdgh0g.backend.repositories.ContactsRepo;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactsServiceImpl implements ContactsService {

    private final ContactsRepo contactsRepo;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public List<Contact> getContacts() {
        return contactsRepo.findAll();
    }

    @Override
    public List<Contact> createContactAndReturnList(Contact contact) {
        contactsRepo.save(contact);
        return getContacts();
    }

    @Override
    public List<Contact> delete(Long id) {
        try {
            contactsRepo.deleteById(id);
        } catch (EmptyResultDataAccessException ignored) {
            logger.info("Removing not existing contact with id = {}", id);
        }
        return getContacts();
    }
}