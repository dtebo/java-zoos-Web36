package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.repositories.AnimalRepository;
import com.lambdaschool.javazoos.views.ZooAnimalCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    AnimalRepository animalRepository;

    @Override
    public List<ZooAnimalCount> getZooAnimalCount(){
        return animalRepository.getZooAnimalCount();
    }
}
