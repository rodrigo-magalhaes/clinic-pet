package com.spring.petclinic.bootstrap;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.model.PetType;
import com.spring.petclinic.model.Vet;
import com.spring.petclinic.services.OwnerService;
import com.spring.petclinic.services.PetTypeService;
import com.spring.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDog = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCat = petTypeService.save(cat);

        Owner peleh = new Owner("Pelé", "O Rei");
        Owner garrincha = new Owner("Ronaldo", "Fenomeno");

        this.ownerService.save(peleh);
        this.ownerService.save(garrincha);

        Vet michael = new Vet("Michael", "Jackson");
        Vet elvis = new Vet("Elvis", "Presley");

        this.vetService.save(michael);
        this.vetService.save(elvis);

        System.out.println("Loaded data...");
    }
}
