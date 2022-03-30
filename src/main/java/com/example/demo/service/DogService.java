package com.example.demo.service;

import com.example.demo.model.Dog;
import com.example.demo.model.Person;
import com.example.demo.repository.DogRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogService {

    private final DogRepository dogRepository;
    private final PersonRepository personRepository;

    @Autowired
    public DogService(DogRepository dogRepository, PersonService personService, PersonRepository personRepository){
        this.dogRepository = dogRepository;
        this.personRepository = personRepository;
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    public Optional<Dog> getDogById(Long id) {
        return dogRepository.findById(id);
    }

    public void addDog(Dog dog) {
        Person person = personRepository.findById(dog.getPerson().getId())
                .orElseThrow();
        dog.setPerson(person);
        dogRepository.save(dog);
    }

    public void deleteDogById(Long id) {
        dogRepository.deleteById(id);
    }

    public void updateDog(Dog dog) {
        dogRepository.save(dog);
    }

}
