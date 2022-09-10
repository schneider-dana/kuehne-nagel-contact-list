package com.kuehne.nagel.test.contactlist.resource;

import com.kuehne.nagel.test.contactlist.model.Person;
import com.kuehne.nagel.test.contactlist.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public Iterable<Person> findAll() {
        personRepository.findAll().forEach(person -> System.out.println(person));
        return personRepository.findAll();
    }

    @GetMapping("/name/{name}")
    public List<Person> findByName(@PathVariable String name) {
        return personRepository.findByName(name);
    }

}
