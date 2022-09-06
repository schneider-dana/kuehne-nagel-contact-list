package com.kuehne.nagel.test.contactlist.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/")
    public String homePage(final Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }
}
