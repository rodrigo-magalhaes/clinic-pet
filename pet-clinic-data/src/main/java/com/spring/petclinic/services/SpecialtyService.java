package com.spring.petclinic.services;

import com.spring.petclinic.model.Speciality;
import org.springframework.stereotype.Service;

@Service
public interface SpecialtyService extends  CrudService<Speciality, Long>{
}
