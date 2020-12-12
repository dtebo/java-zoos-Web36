package com.lambdaschool.javazoos.controllers;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController {
    @Autowired
    ZooService zooService;

    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> findAllZoos(){
        List<Zoo> myZoos = zooService.findAllZoos();

        return new ResponseEntity<>(myZoos, HttpStatus.OK);
    }

    @GetMapping(value = "/zoo/{id}", produces = "application/json")
    public ResponseEntity<?> findZooById(@PathVariable long id){
        Zoo myZoo = zooService.findZooById(id);

        return new ResponseEntity<>(myZoo, HttpStatus.OK);
    }
}
