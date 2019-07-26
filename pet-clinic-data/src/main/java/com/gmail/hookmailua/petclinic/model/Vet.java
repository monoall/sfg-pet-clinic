package com.gmail.hookmailua.petclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Speciality> specialoties = new HashSet<>();

    public Set<Speciality> getSpecialoties() {
        return specialoties;
    }

    public void setSpecialoties(Set<Speciality> specialoties) {
        this.specialoties = specialoties;
    }
}
