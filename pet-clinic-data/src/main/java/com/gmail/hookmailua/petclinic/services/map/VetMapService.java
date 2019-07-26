package com.gmail.hookmailua.petclinic.services.map;

import com.gmail.hookmailua.petclinic.model.Speciality;
import com.gmail.hookmailua.petclinic.model.Vet;
import com.gmail.hookmailua.petclinic.services.SpecialtiesService;
import com.gmail.hookmailua.petclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtiesService specialtiesService;

    public VetMapService(SpecialtiesService specialtiesService) {
        this.specialtiesService = specialtiesService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialoties().size() > 0) {
            object.getSpecialoties().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpeciality = specialtiesService.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
