package com.assignments.languages.services;

import com.assignments.languages.models.Language;
import com.assignments.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    public List<Language> findAllLanguages() {
        return languageRepository.findAll();
    }

    public Language findLanguageById(Integer id) {
        Optional<Language> language = languageRepository.findById(id);
        return language.orElse(null);
    }

    public void createUpdateLanguage(Language language) {
        languageRepository.save(language);
    }

    public void deleteLanguageById(Integer id) {
        languageRepository.deleteById(id);
    }
}
