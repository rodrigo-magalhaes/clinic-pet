package com.spring.petclinic.model;

import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specialities;

    public Vet() {
    }

    public Vet(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Vet(Long id, String firstName, String lastName) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
