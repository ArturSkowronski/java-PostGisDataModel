package com.agh.bazy.postgis.model;

import java.util.ArrayList;

/**
 * Created by Artur on 1/11/14.
 */
public class Crossroad {
    ArrayList<Road> roadArrayList = new ArrayList<Road>();
    LocationPoint locationPoint;


    public Crossroad(LocationPoint locationPoint) {
        this.locationPoint=locationPoint;
    }

    public int getRoadListSize(){
        return roadArrayList.size();
    }
    public void setRoadArrayListItem(Road road){
        roadArrayList.add(road);
    }

    public LocationPoint getLocationPoint() {
        return locationPoint;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Crossroad rhs = (Crossroad) obj;
        return new org.apache.commons.lang3.builder.EqualsBuilder()
                .append(this.locationPoint, rhs.locationPoint)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder()
                .append(locationPoint)
                .toHashCode();
    }
}
