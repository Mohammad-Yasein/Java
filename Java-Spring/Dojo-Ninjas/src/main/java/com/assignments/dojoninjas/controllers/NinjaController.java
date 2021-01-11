package com.assignments.dojoninjas.controllers;

import com.assignments.dojoninjas.models.Ninja;
import com.assignments.dojoninjas.services.DojoService;
import com.assignments.dojoninjas.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @RequestMapping("/new")
    public String insertNinjaPage(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojoService.getAllDojos());
        return "insertNinja.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String insertNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
        if (result.hasErrors()) {
            return "insertNinja.jsp";
        }
        ninjaService.insertNinja(ninja);
        return "redirect:/ninjas/new";
    }
}
