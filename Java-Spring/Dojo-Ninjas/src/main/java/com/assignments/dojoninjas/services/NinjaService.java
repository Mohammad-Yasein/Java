package com.assignments.dojoninjas.services;

import com.assignments.dojoninjas.models.Ninja;
import com.assignments.dojoninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public void insertNinja(Ninja ninja) {
        ninjaRepository.save(ninja);
    }
}
