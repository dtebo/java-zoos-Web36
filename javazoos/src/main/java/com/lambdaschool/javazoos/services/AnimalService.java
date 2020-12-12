package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.views.ZooAnimalCount;

import java.util.List;

public interface AnimalService {
    List<ZooAnimalCount> getZooAnimalCount();
}
