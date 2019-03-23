package com.spring.petclinic.services;

import com.spring.petclinic.model.Speciality;
import org.springframework.stereotype.Service;

@Service
public interface SpecialitiesService extends  CrudService<Speciality, Long>{
}
