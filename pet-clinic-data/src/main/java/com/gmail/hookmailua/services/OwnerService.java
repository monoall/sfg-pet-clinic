package com.gmail.hookmailua.services;

import com.gmail.hookmailua.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
