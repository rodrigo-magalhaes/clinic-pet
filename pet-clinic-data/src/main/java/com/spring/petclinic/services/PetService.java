package com.spring.petclinic.services;

import com.spring.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByLastName(String lastName);

    Set<Pet> findAll();

    Pet save(Pet pet);
}
