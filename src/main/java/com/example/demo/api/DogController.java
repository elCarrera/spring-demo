package com.example.demo.api;

import com.example.demo.model.Dog;
import com.example.demo.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PutMapping(path = "/{id}")
    public ResponseEntity<Dog> updateDog(Long id, Dog dog) {
        return dogService.updateDog(id, dog);
    }

}
