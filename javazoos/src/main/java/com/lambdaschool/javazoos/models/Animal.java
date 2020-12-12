package com.lambdaschool.javazoos.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    private String animaltype;

    @ManyToMany(mappedBy = "animals")
    Set<Zoo> zoos = new HashSet<>();

    public Animal() {
    }

    public Animal(String animaltype, Set<Zoo> zoos) {
        this.animaltype = animaltype;
        this.zoos = zoos;
    }

    public long getAnimalid() {
        return animalid;
    }

    public void setAnimalid(long animalid) {
        this.animalid = animalid;
    }

    public String getAnimaltype() {
        return animaltype;
    }

    public void setAnimaltype(String animaltype) {
        this.animaltype = animaltype;
    }

    public Set<Zoo> getZoos() {
        return zoos;
    }

    public void setZoos(Set<Zoo> zoos) {
        this.zoos = zoos;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalid=" + animalid +
                ", animaltype='" + animaltype + '\'' +
                ", zoos=" + zoos +
                '}';
    }
}
