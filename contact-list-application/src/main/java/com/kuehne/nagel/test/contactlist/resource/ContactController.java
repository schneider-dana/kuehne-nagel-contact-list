package com.kuehne.nagel.test.contactlist.resource;

import com.kuehne.nagel.test.contactlist.domain.Contact;
import com.kuehne.nagel.test.contactlist.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String findAll(@RequestParam("page") final Optional<Integer> page,
                          @RequestParam("size") final Optional<Integer> size,
                          final Model model) {
        final int currentPage = page.orElse(1);
        final int pageSize = size.orElse(5);

        final Page<Contact> contactPage = contactService.findAll(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("contactPage", contactPage);

        final int totalPages = contactPage.getTotalPages();
        if (totalPages > 0) {
            final List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

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
