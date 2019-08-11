package com.gmail.hookmailua.petclinic.repositories;

import com.gmail.hookmailua.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
