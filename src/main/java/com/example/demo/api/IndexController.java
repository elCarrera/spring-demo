package com.example.demo.api;

import com.example.demo.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private final PersonService personService;

    public IndexController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("people", personService.getAllPeople());

        return "index";
    }
}
