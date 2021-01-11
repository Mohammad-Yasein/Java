package com.assignments.dojoninjas.controllers;

import com.assignments.dojoninjas.models.Dojo;
import com.assignments.dojoninjas.services.DojoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/dojos")
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @RequestMapping("/new")
    public String insertDojoPage(@ModelAttribute("dojo") Dojo dojo) {
        return "insertDojo.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String insertDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "insertDojo.jsp";
        }
        dojoService.insertDojo(dojo);
        return "redirect:/dojos/new";
    }

    @RequestMapping("/{id}")
    public String showDojoNinjas(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dojo", dojoService.getDojoById(id));
        return "dojoNinjas.jsp";
    }
}
