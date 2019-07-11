package com.mail.hookmailua.petclinic.bootstrap;

import com.gmail.hookmailua.petclinic.model.Owner;
import com.gmail.hookmailua.petclinic.model.Vet;
import com.gmail.hookmailua.petclinic.services.OwnerService;
import com.gmail.hookmailua.petclinic.services.VetService;
import com.gmail.hookmailua.petclinic.services.map.OwnerServiceMap;
import com.gmail.hookmailua.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("John");
        owner1.setLastName("Smith");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Alex");
        owner2.setLastName("Williams");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Tim");
        vet1.setLastName("Barton");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Chloe");
        vet2.setLastName("Janet");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
