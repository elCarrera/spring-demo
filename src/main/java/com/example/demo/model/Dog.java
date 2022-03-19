package com.example.demo.model;

import javax.persistence.*;

@Entity(name = "Dog")
@Table(name = "Dog")
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            nullable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;


    @ManyToOne
    @JoinColumn(name = "id")
    private Person ownerPerson;

    public Dog() {
    }

    public Dog(String name, Person ownerPerson) {
        this.name = name;
        this.ownerPerson = ownerPerson;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwnerPerson() {
        return ownerPerson;
    }

    public void setOwnerPerson(Person ownerPerson) {
        this.ownerPerson = ownerPerson;
    }

}
