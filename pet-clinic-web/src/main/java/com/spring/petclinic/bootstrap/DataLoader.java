package com.spring.petclinic.bootstrap;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.model.Vet;
import com.spring.petclinic.services.OwnerService;
import com.spring.petclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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
