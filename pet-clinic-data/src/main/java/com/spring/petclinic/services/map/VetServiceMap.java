package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Vet;
import com.spring.petclinic.services.CrudService;

import java.util.Set;

public class VetServiceMap extends AbastractMapService<Vet, Long> implements CrudService<Vet, Long> {

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}