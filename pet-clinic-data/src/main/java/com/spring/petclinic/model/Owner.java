package com.spring.petclinic.model;

import java.util.Set;

public class Owner extends Person {

    private Set<Pet> pets;

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

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

}
