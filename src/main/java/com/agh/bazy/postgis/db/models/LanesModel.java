package com.agh.bazy.postgis.db.models;

/**
 * Created by Artur on 1/14/14.
 */
public class LanesModel {
    String id;
    String number;
    String way_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWay_id() {
        return way_id;
    }

    public void setWay_id(String way_id) {
        this.way_id = way_id;
    }
}
