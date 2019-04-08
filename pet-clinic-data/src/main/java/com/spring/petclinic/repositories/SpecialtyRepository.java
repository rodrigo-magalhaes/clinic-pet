package com.spring.petclinic.repositories;

import com.spring.petclinic.model.Speciality;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
