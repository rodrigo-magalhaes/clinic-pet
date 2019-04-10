package com.spring.petclinic.bootstrap;

import com.spring.petclinic.model.*;
import com.spring.petclinic.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");

        PetType cat = new PetType();
        dog.setName("Cat");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        radiology.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        radiology.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        Owner peleh = new Owner("Pelé", "O Rei");
        peleh.setAddress("rua do rei");
        peleh.setCity("Cidade de Deus");
        peleh.setTelephone("707070denovo");

        Pet pelehDog = new Pet();
        pelehDog.setName("copa");
        pelehDog.setPetType(dog);
        pelehDog.setOwner(peleh);
        pelehDog.setBirthDate(LocalDate.now());
        peleh.getPets().add(pelehDog);

        Owner ronaldo = new Owner("Ronaldo", "Fenomeno");
        ronaldo.setAddress("estrada tortuosa");
        ronaldo.setCity("Mallorca");
        ronaldo.setTelephone("9999999999");

        Pet ronaldoCat = new Pet();
        ronaldoCat.setName("trave");
        ronaldoCat.setPetType(cat);
        ronaldoCat.setOwner(ronaldo);
        ronaldoCat.setBirthDate(LocalDate.now());
        ronaldo.getPets().add(ronaldoCat);

        this.ownerService.save(peleh);
        this.ownerService.save(ronaldo);

        Visit catVisit = new Visit();
        catVisit.setPet(ronaldoCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("just a checkup");

        visitService.save(catVisit);

        Vet michael = new Vet("Michael", "Jackson");
        michael.getSpecialities().add(radiology);

        Vet elvis = new Vet("Elvis", "Presley");
        elvis.getSpecialities().add(surgery);

        this.vetService.save(michael);
        this.vetService.save(elvis);

        System.out.println("Loaded data...");
    }
}
