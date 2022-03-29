package com.example.demo.api;

import com.example.demo.model.Dog;
import com.example.demo.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/dog")
@RestController
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @PostMapping
    public void addDog(@RequestBody Dog dog) {
        dogService.addDog(dog);
    }



}
