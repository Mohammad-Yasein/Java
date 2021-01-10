package com.assignments.license.controllers;

import com.assignments.license.models.Person;
import com.assignments.license.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/new")
    public String insertPersonPage(@ModelAttribute("person") Person person) {
        return "insertPerson.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String insertPerson(@Valid @ModelAttribute("person") Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "insertPerson.jsp";
        }
        personService.insertPerson(person);
        return "redirect:/persons/new";
    }

    @RequestMapping("/{id}")
    public String showPersonInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personService.findPersonById(id));
        return "showPerson.jsp";
    }
}
