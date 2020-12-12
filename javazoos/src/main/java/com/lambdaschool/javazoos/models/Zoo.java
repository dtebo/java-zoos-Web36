package com.lambdaschool.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "zoos")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    private String zooname;

    @OneToMany(mappedBy = "zoo",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private List<Telephone> telephones = new ArrayList<>();

    @ManyToMany()
    @JoinTable(name = "zooanimals",
               joinColumns = @JoinColumn(name = "zooid"),
               inverseJoinColumns = @JoinColumn(name = "animalid"))
    Set<Animal> animals = new HashSet<>();

    public Zoo() {
    }

    public Zoo(String zooname, List<Telephone> telephones) {
        this.zooname = zooname;
        this.telephones = telephones;
    }

    public long getZooid() {
        return zooid;
    }

    public void setZooid(long zooid) {
        this.zooid = zooid;
    }

    public String getZooname() {
        return zooname;
    }

    public void setZooname(String zooname) {
        this.zooname = zooname;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "zooid=" + zooid +
                ", zooname='" + zooname + '\'' +
                ", telephones=" + telephones +
                '}';
    }
}
