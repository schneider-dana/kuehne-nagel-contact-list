package com.kuehne.nagel.test.contactlist.resource;

import com.kuehne.nagel.test.contactlist.domain.Contact;
import com.kuehne.nagel.test.contactlist.model.Person;
import com.kuehne.nagel.test.contactlist.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public String findAll(final Model model) {
        model.addAttribute(
            "contacts",
            personRepository.findAll().stream().map(ContactController::toContact).collect(toList()));

        return "contacts";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String findByName(@RequestParam(value = "name", required = false) final String name,
                             final Model model) {
        model.addAttribute("name", name);
        model.addAttribute(
            "contacts",
            personRepository.findByName(name).stream().map(ContactController::toContact).collect(toList()));

        return "contactSearch";
    }

    private static Contact toContact(final Person person) {
        return new Contact(person.getName(), person.getUrl());
    }

}
