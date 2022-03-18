package com.example.demo.service;

import com.example.demo.model.Dog;
import com.example.demo.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    private final DogRepository dogRepository;

    @Autowired
    public DogService(DogRepository dogRepository){
        this.dogRepository = dogRepository;
    }
    

    public void addDog(Dog dog) {
        dogRepository.save(dog);
    }
}
