package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Zoo;

import java.util.List;

public interface ZooService {
    List<Zoo> findAllZoos();
    Zoo findZooById(long id);
    Zoo save(Zoo zoo);
}
