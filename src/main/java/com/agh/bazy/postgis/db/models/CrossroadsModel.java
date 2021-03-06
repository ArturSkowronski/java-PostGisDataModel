package com.agh.bazy.postgis.db.models;

import org.postgis.PGgeometry;

/**
 * Created by Artur on 1/14/14.
 */
public class CrossroadsModel {
    String id;
    String name;
    PGgeometry boundary;

    public PGgeometry getBoundary() {
        return boundary;
    }

    public void setBoundary(PGgeometry boundary) {
        this.boundary = boundary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
