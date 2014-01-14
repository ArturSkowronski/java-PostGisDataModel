package com.agh.bazy.postgis.db.models;

import org.postgis.PGgeometry;

/**
 * Created by Artur on 1/14/14.
 */
public class SMNodesModel {
    String id;
    String node_id;

    public PGgeometry getGeom() {
        return geom;
    }

    public void setGeom(PGgeometry geom) {
        this.geom = geom;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    PGgeometry geom;
}
