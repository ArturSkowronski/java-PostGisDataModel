package com.agh.bazy.postgis.model;

import java.util.ArrayList;

/**
 * Created by Artur on 1/11/14.
 */
public class Road {
    ArrayList<Crossroad> crossroadArrayList=new ArrayList<>();

    public void setCrossroadArrayListItem(Crossroad crossroadArrayListItem) {
        this.crossroadArrayList.add(crossroadArrayListItem);
    }

    public int hashCode(){
        return crossroadArrayList.hashCode();
    }
}
