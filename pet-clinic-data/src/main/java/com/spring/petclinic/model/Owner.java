package com.spring.petclinic.model;

public class Owner extends Person {

    public Owner() {
    }

    public Owner(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Owner(Long id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

}
