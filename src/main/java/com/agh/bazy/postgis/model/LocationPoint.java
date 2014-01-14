package com.agh.bazy.postgis.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by Artur on 1/11/14.
 */
public class LocationPoint {
    int x;
    int y;

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }


    public LocationPoint(int x, int y) {
        this.x = x;
        this.y = y;
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
        LocationPoint rhs = (LocationPoint) obj;
        return new EqualsBuilder()
                .append(this.x, rhs.x)
                .append(this.y, rhs.y)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(x)
                .append(y)
                .toHashCode();
    }
}
