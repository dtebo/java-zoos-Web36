package com.lambdaschool.javazoos.services;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooService")
public class ZooServiceImpl implements ZooService {
    @Autowired
    ZooRepository zooRepository;

    @Override
    public List<Zoo> findAllZoos(){
        List<Zoo> zooList = new ArrayList<>();

        zooRepository.findAll()
                .iterator()
                .forEachRemaining(zooList::add);

        return zooList;
    }

    @Override
    public Zoo findZooById(long id){
        return zooRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Zoo " + id + " Not Found!"));
    }

    @Transactional
    @Override
    public Zoo save(Zoo zoo){
        return zooRepository.save(zoo);
    }
}
