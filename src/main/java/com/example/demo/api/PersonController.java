package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "/{id}")
    public Optional<Person> gePersonById(@PathVariable Long id) {
        return personService.getPersonById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePersonById(@PathVariable Long id){
        personService.deletePerson(id);
    }

    @PostUpdate
    public void updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
    }

}
