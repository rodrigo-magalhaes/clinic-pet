package com.spring.petclinic.bootstrap;

import com.spring.petclinic.model.Owner;
import com.spring.petclinic.model.Vet;
import com.spring.petclinic.services.OwnerService;
import com.spring.petclinic.services.VetService;
import com.spring.petclinic.services.map.OwnerServiceMap;
import com.spring.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner peleh = new Owner(1L, "Pelé", "O Rei");
        Owner garrincha = new Owner(2L, "Ronaldo", "Fenomeno");

        this.ownerService.save(peleh);
        this.ownerService.save(garrincha);

        Vet michael = new Vet(1L, "Michael", "Jackson");
        Vet elvis = new Vet(2L, "Elvis", "Presley");

        this.vetService.save(michael);
        this.vetService.save(elvis);

        System.out.println("Loaded data...");
    }
}
