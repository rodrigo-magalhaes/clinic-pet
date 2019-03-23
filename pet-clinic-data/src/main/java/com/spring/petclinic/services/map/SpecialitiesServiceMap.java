package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Speciality;
import com.spring.petclinic.services.SpecialitiesService;

import java.util.Set;

public class SpecialitiesServiceMap extends AbastractMapService<Speciality, Long> implements SpecialitiesService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality speciality) {
        super.delete(speciality);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return super.save(speciality);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
