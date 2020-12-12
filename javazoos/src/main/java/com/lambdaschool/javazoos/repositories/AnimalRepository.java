package com.lambdaschool.javazoos.repositories;

import com.lambdaschool.javazoos.models.Animal;
import com.lambdaschool.javazoos.views.ZooAnimalCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    @Query(value = "SELECT a.animaltype, a.animalid, COUNT(za.zooid) as countzoos " +
            "FROM zoos z " +
            "RIGHT JOIN zooanimals za " +
            "ON z.zooid = za.zooid " +
            "RIGHT JOIN animals a " +
            "ON a.animalid = za.animalid " +
            "GROUP BY a.animaltype", nativeQuery = true)
    List<ZooAnimalCount> getZooAnimalCount();
}
