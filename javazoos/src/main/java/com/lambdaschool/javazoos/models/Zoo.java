package com.lambdaschool.javazoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.h2.api.DatabaseEventListener;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "zoos")
public class Zoo extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    private String zooname;

    private String incomingzoo;

    @OneToMany(mappedBy = "zoo",
               cascade = CascadeType.ALL,
               orphanRemoval = true)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private List<Telephone> telephones = new ArrayList<>();

    @OneToMany(mappedBy = "zoo",
               cascade = CascadeType.ALL)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true)
    private Set<ZooAnimals> animals = new HashSet<>();

    public Zoo() {
    }

    public Zoo(long zooid, String zooname) {
        this.zooid = zooid;
        this.zooname = zooname;
//        this.createdby = created_by;
//        this.createddate = created_date;
//        this.lastmodifiedby = last_modified_by;
//        this.lastmodifieddate = last_modified_date;
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

    public Set<ZooAnimals> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<ZooAnimals> animals) {
        this.animals = animals;
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
                ", animals=" + animals +
                '}';
    }
}
