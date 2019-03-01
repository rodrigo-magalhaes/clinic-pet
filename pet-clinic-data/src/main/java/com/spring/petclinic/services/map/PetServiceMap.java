package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Pet;
import com.spring.petclinic.services.CrudService;

import java.util.Set;

public class PetServiceMap extends AbastractMapService<Pet, Long> implements CrudService<Pet, Long> {

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Pet pet) {
        super.delete(pet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
