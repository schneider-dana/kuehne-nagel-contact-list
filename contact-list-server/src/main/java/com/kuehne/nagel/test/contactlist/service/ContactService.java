package com.kuehne.nagel.test.contactlist.service;

import com.kuehne.nagel.test.contactlist.domain.Contact;
import com.kuehne.nagel.test.contactlist.model.Person;
import com.kuehne.nagel.test.contactlist.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

@Service
public class ContactService {

    @Autowired
    private PersonRepository personRepository;

    public Page<Contact> findAll(final Pageable pageable) {
        final int pageSize = pageable.getPageSize();
        final int currentPage = pageable.getPageNumber();
        final int startItem = currentPage * pageSize;

        final List<Contact> allContacts =
            personRepository.findAll().stream().map(ContactService::toContact).collect(toList());
        final List<Contact> page;

        if (allContacts.size() < startItem) {
            page = emptyList();
        } else {
            final int toIndex = Math.min(startItem + pageSize, allContacts.size());
            page = allContacts.subList(startItem, toIndex);
        }

        return new PageImpl<>(page, PageRequest.of(currentPage, pageSize), allContacts.size());
    }

    public List<Contact> findByName(final String name) {
        return personRepository.findByName(name).stream().map(ContactService::toContact).collect(toList());
    }

    private static Contact toContact(final Person person) {
        return new Contact(person.getName(), person.getUrl());
    }

}
