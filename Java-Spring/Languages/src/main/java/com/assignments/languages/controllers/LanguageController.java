package com.assignments.languages.controllers;

import com.assignments.languages.models.Language;
import com.assignments.languages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/languages")
public class LanguageController {
    private final LanguageService languageService;

    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @RequestMapping("")
    public String showAllLanguages(Model model, @ModelAttribute("language") Language language) {
        model.addAttribute("languages", languageService.findAllLanguages());
        return "LanguagesList.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (!result.hasErrors()) {
            languageService.createUpdateLanguage(language);
        }
        return "redirect:/languages";
    }

    @RequestMapping("/{id}")
    public String showLanguageInfo(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("language", languageService.findLanguageById(id));
        return "languageInfo.jsp";
    }

    @RequestMapping("/{id}/edit")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("language", languageService.findLanguageById(id));
        return "languageEditForm.jsp";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String editLanguage(@PathVariable("id") Integer id, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/languages/" + id + "/edit";
        }
        language.setId(id);
        languageService.createUpdateLanguage(language);
        return "redirect:/languages";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String removeLanguage(@PathVariable("id") Integer id) {
        languageService.deleteLanguageById(id);
        return "redirect:/languages";
    }
}
