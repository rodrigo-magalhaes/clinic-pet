package com.spring.petclinic.services.map;

import com.spring.petclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "lastName";
    final String lastNameNotFound = "not found";

    @BeforeEach
    void setUp(){
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());

        ownerMapService.save(Owner.builder().id(ownerId).lastName(lastName).build());
    }

    @Test
    void saveWithGivenId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();

        Owner savedOwner2 = ownerMapService.save(owner2);

        assertEquals(id, savedOwner2.getId());
    }

    @Test
    void saveWithNoId() {

        Owner savedOwner2 = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner2);
        assertNotNull(savedOwner2.getId());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);

        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner owner1 = ownerMapService.findByLastName(lastName);
        assertNotNull(owner1);
        assertEquals(ownerId, owner1.getId());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner1 = ownerMapService.findByLastName(lastNameNotFound);
        assertNull(owner1);
    }
}