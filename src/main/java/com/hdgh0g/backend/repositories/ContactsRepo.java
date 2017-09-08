package com.hdgh0g.backend.repositories;

import com.hdgh0g.backend.domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsRepo extends CrudRepository<Contact, Long> {

    List<Contact> findAll();
}
