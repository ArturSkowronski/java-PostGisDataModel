package com.agh.bazy.postgis.db.models;

import com.agh.bazy.postgis.model.Crossroad;

/**
 * Created by Artur on 1/14/14.
 */
public class CrossroadWaysModel {
    String crosroad_id;
    String way_segment_id;
    String crossroad_way_role;
    WaySegmentModel waySegment;

    public CrossroadsModel getCrossroad() {
        return crossroad;
    }

    public void setCrossroad(CrossroadsModel crossroad) {
        this.crossroad = crossroad;
    }

    public WaySegmentModel getWaySegment() {
        return waySegment;
    }

    public void setWaySegment(WaySegmentModel waySegment) {
        this.waySegment = waySegment;
    }

    CrossroadsModel crossroad;

    public void setCrossroad_way_role(String crossroad_way_role) {
        this.crossroad_way_role = crossroad_way_role;
    }

    public String getCrosroad_id() {
        return crosroad_id;
    }

    public void setCrosroad_id(String crosroad_id) {
        this.crosroad_id = crosroad_id;
    }

    public String getWay_segment_id() {
        return way_segment_id;
    }

    public void setWay_segment_id(String way_segment_id) {
        this.way_segment_id = way_segment_id;
    }

    public String getCrossroad_way_role() {
        return crossroad_way_role;
    }

    public void setRole(String crossroad_way_role) {
        this.crossroad_way_role = crossroad_way_role;
    }
}
