package com.agh.bazy.postgis.db.models;

/**
 * Created by Artur on 1/14/14.
 */
public class LanesSMNodesModel {
    String lane_id;
    String smnode_id;
    SMNodesModel smNode;

    public LanesModel getLane() {
        return lane;
    }

    public void setLane(LanesModel lane) {
        this.lane = lane;
    }

    public SMNodesModel getSmNode() {
        return smNode;
    }

    public void setSmNode(SMNodesModel smNode) {
        this.smNode = smNode;
    }

    LanesModel lane;
    public String getSequence_id() {
        return sequence_id;
    }

    public void setSequence_id(String sequence_id) {
        this.sequence_id = sequence_id;
    }

    public String getSmnode_id() {
        return smnode_id;
    }

    public void setSmnode_id(String smnode_id) {
        this.smnode_id = smnode_id;
    }

    public String getLane_id() {
        return lane_id;
    }

    public void setLane_id(String lane_id) {
        this.lane_id = lane_id;
    }

    String sequence_id;
}
