package com.assignments.dojoninjas.services;

import com.assignments.dojoninjas.models.Dojo;
import com.assignments.dojoninjas.repositories.DojoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }

    public List<Dojo> getAllDojos() {
        return dojoRepository.findAll();
    }

    public Dojo getDojoById(Long id) {
        return dojoRepository.findById(id).orElse(null);
    }

    public void insertDojo(Dojo dojo) {
        dojoRepository.save(dojo);
    }
}
