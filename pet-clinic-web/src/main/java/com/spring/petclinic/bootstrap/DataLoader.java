package com.spring.petclinic.bootstrap;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.model.Pet;
import com.spring.petclinic.model.PetType;
import com.spring.petclinic.model.Vet;
import com.spring.petclinic.services.OwnerService;
import com.spring.petclinic.services.PetTypeService;
import com.spring.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        PetType cat = new PetType();
        dog.setName("Cat");

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

        Vet michael = new Vet("Michael", "Jackson");
        Vet elvis = new Vet("Elvis", "Presley");

        this.vetService.save(michael);
        this.vetService.save(elvis);

        System.out.println("Loaded data...");
    }
}
