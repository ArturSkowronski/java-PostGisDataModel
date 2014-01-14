package com.agh.bazy.postgis.db.models;

/**
 * Created by Artur on 1/14/14.
 */
public class WaySegmentModel {
    String id;
    String way_id;
    String sequence_id;
    String node1_id;

    public String getHighway() {
        return highway;
    }

    public void setHighway(String highway) {
        this.highway = highway;
    }

    public String getOneway() {
        return oneway;
    }

    public void setOneway(String oneway) {
        this.oneway = oneway;
    }

    public String getNode2_id() {
        return node2_id;
    }

    public void setNode2_id(String node2_id) {
        this.node2_id = node2_id;
    }

    public String getNode1_id() {
        return node1_id;
    }

    public void setNode1_id(String node1_id) {
        this.node1_id = node1_id;
    }

    public String getSequence_id() {
        return sequence_id;
    }

    public void setSequence_id(String sequence_id) {
        this.sequence_id = sequence_id;
    }

    public String getWay_id() {
        return way_id;
    }

    public void setWay_id(String way_id) {
        this.way_id = way_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String node2_id;
    String oneway;
    String highway;
    NodesModel node2;

    public NodesModel getNode1() {
        return node1;
    }

    public void setNode1(NodesModel node1) {
        this.node1 = node1;
    }

    public NodesModel getNode2() {
        return node2;
    }

    public void setNode2(NodesModel node2) {
        this.node2 = node2;
    }

    NodesModel node1;
}
