package com.assignments.license.controllers;

import com.assignments.license.models.License;
import com.assignments.license.services.LicenseService;
import com.assignments.license.services.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/licenses")
public class LicenseController {
    private final LicenseService licenseService;
    private final PersonService personService;

    public LicenseController(LicenseService licenseService, PersonService personService) {
        this.licenseService = licenseService;
        this.personService = personService;
    }

    @RequestMapping("/new")
    public String insertLicensePage(@ModelAttribute("license") License license, Model model) {
        model.addAttribute("persons", personService.findUnlicensedPersons());
        return "insertLicense.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String insertLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
        if (result.hasErrors()) {
            return "insertLicense.jsp";
        }
        licenseService.insertLicense(license);
        return "redirect:/licenses/new";
    }
}
