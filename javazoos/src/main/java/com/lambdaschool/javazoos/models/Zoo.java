package com.lambdaschool.javazoos.models;

import javax.persistence.*;

@Entity
@Table(name = "zoos")
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    private String zooname;

    public Zoo() {
    }

    public Zoo(String zooname) {
        this.zooname = zooname;
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

    @Override
    public String toString() {
        return "Zoo{" +
                "zooid=" + zooid +
                ", zooname='" + zooname + '\'' +
                '}';
    }
}
