package com.spring.petclinic.services;

import com.spring.petclinic.model.Owner;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> finadAllByLastNameLike(String lastName);
}
