package com.spring.petclinic.services;

import com.spring.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByLastName(String lastName);

    Set<Vet> findAll();

    Vet save(Vet vet);
}
