package com.agh.bazy.postgis.model;

/**
 * Created by Artur on 1/11/14.
 */
public class Way {
    Crossroad target;
    int length;
    int velocity;

    public Way(Crossroad target, int velocity) {
        this.target = target;
        this.length = 10;
        this.velocity = velocity;
    }


}
