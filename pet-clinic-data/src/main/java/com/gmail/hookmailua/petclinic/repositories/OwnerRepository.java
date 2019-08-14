package com.gmail.hookmailua.petclinic.repositories;

import com.gmail.hookmailua.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
