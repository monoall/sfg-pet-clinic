package com.gmail.hookmailua.petclinic.bootstrap;

import com.gmail.hookmailua.petclinic.model.*;
import com.gmail.hookmailua.petclinic.services.OwnerService;
import com.gmail.hookmailua.petclinic.services.PetTypeService;
import com.gmail.hookmailua.petclinic.services.SpecialtiesService;
import com.gmail.hookmailua.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtiesService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("John");
        owner1.setLastName("Smith");
        owner1.setAddress("2 Street");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        Pet johnsPet = new Pet();
        johnsPet.setPetType(savedDogType);
        johnsPet.setOwner(owner1);
        johnsPet.setBirthDate(LocalDate.now());
        johnsPet.setName("Rosco");
        owner1.getPets().add(johnsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Alex");
        owner2.setLastName("Williams");
        owner2.setAddress("33 Street");
        owner2.setCity("New York");
        owner2.setTelephone("222222233");

        Pet alexsCat = new Pet();
        alexsCat.setPetType(savedCatType);
        alexsCat.setOwner(owner2);
        alexsCat.setBirthDate(LocalDate.now());
        alexsCat.setName("Jymbo");
        owner2.getPets().add(alexsCat);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Tim");
        vet1.setLastName("Barton");
        vet1.getSpecialoties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Chloe");
        vet2.setLastName("Janet");
        vet2.getSpecialoties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
