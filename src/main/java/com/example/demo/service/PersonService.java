package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public void updatePerson(Person person) {
        personRepository.findById(person.getId())
                .orElseThrow();
        personRepository.save(person);
    }

    

}
