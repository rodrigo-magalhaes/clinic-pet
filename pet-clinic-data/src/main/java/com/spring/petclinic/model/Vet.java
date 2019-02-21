package com.spring.petclinic.model;

public class Vet extends Person {

    public Vet() {
    }

    public Vet(Long id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

}
