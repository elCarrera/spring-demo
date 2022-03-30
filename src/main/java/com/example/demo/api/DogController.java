package com.example.demo.api;

import com.example.demo.model.Dog;
import com.example.demo.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/dog")
@RestController
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @GetMapping(path = "/{id}")
    public Optional<Dog> getDog(Long id) {
        return dogService.getDogById(id);
    }

    @PostMapping
    public void addDog(@RequestBody Dog dog) {
        dogService.addDog(dog);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteDog(Long id) {
        dogService.deleteDogById(id);
    }

    @PostMapping(path = "/{id}")
    public void updateDog(Dog dog) {
        dogService.updateDog(dog);
    }

}
