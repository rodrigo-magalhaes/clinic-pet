package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Visit;
import com.spring.petclinic.services.PetService;
import com.spring.petclinic.services.VisitService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VisitMapService extends AbastractMapService<Visit, Long> implements VisitService {

    private final PetService petService;

    public VisitMapService(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Visit save(Visit visit) {

        if(visit == null) {
            return null;
        }
        if(visit.getPet() != null && visit.getPet().getId() == null) {
            petService.save(visit.getPet());
        }
        return super.save(visit);
    }

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Visit visit) {
        super.delete(visit);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
