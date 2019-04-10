package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Speciality;
import com.spring.petclinic.model.Vet;
import com.spring.petclinic.services.SpecialtyService;
import com.spring.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetMapService extends AbastractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Vet save(Vet vet) {

        if(vet == null) {
            return null;
        }
        if(vet.getSpecialities() != null) {
            vet.getSpecialities().forEach(specialty -> {
                if(specialty.getId() == null) {
                    Speciality savedSpecialty = specialtyService.save(specialty);
                    specialty.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(vet);
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
