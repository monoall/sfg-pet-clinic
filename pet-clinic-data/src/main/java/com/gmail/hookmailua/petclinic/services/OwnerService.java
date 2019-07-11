package com.gmail.hookmailua.petclinic.services;

import com.gmail.hookmailua.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
