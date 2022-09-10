package com.kuehne.nagel.test.contactlist.resource;

import com.kuehne.nagel.test.contactlist.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public String findAll(final Model model) {
        model.addAttribute("contacts", contactService.findAll());

        return "contacts";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    public String findByName(@RequestParam(value = "name", required = false) final String name,
                             final Model model) {
        model.addAttribute("name", name);
        model.addAttribute("contacts", contactService.findByName(name));

        return "contactSearch";
    }

}
