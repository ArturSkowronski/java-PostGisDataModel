package com.agh.bazy.postgis.db.models;

/**
 * Created by Artur on 1/14/14.
 */
public class WayNodeModel {
    String way_id;
    String node_id;

    public void setSequence_id(String sequence_id) {
        this.sequence_id = sequence_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public void setWay_id(String way_id) {
        this.way_id = way_id;
    }

    String sequence_id;
}
