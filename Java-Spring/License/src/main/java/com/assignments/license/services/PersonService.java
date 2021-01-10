package com.assignments.license.services;

import com.assignments.license.models.Person;
import com.assignments.license.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findUnlicensedPersons() {
        return personRepository.findAllByLicenseIsNull();
    }

    public Person findPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElse(null);
    }

    public void insertPerson(Person person) {
        personRepository.save(person);
    }
}
