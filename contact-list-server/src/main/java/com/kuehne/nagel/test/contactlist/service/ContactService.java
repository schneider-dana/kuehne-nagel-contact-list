package com.kuehne.nagel.test.contactlist.service;

import com.kuehne.nagel.test.contactlist.domain.Contact;
import com.kuehne.nagel.test.contactlist.model.Person;
import com.kuehne.nagel.test.contactlist.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ContactService {

    @Autowired
    private PersonRepository personRepository;

    public List<Contact> findAll() {
        return personRepository.findAll().stream().map(ContactService::toContact).collect(toList());
    }

    public List<Contact> findByName(final String name) {
        return personRepository.findByName(name).stream().map(ContactService::toContact).collect(toList());
    }

    private static Contact toContact(final Person person) {
        return new Contact(person.getName(), person.getUrl());
    }

}
