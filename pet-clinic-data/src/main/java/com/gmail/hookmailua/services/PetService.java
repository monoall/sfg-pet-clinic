package com.gmail.hookmailua.services;

import com.gmail.hookmailua.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
