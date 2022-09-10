package com.kuehne.nagel.test.contactlist.resource;

import com.kuehne.nagel.test.contactlist.domain.PersonDTO;
import com.kuehne.nagel.test.contactlist.model.Person;
import com.kuehne.nagel.test.contactlist.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public Iterable<PersonDTO> findAll() {
//        personRepository.findAll().forEach(person -> System.out.println(person));

        return personRepository.findAll().stream().map(ContactController::toDTO).collect(toList());
    }

    @GetMapping("/name/{name}")
    public List<PersonDTO> findByName(@PathVariable final String name) {
        return personRepository.findByName(name).stream().map(ContactController::toDTO).collect(toList());
    }

    private static PersonDTO toDTO(final Person person) {
        return new PersonDTO(person.getName(), person.getUrl());
    }

}
