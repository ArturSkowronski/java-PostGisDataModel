package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;
import com.agh.bazy.postgis.db.models.LanesModel;
import com.agh.bazy.postgis.db.models.LanesSMNodesModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Artur on 1/14/14.
 */
public class LanesSMNodesController extends Controller {
    public LanesSMNodesController(JDBCConncetion connection) {
        super(connection);
    }

    @Override
    public ArrayList<Object> selectTable() throws SQLException {
        ResultSet rs=selectWholeTable("krakow.lane_smnodes");
        while (rs.next()) {
            LanesSMNodesModel way=new LanesSMNodesModel();
            way.setLane_id(rs.getString("lane_id"));
            way.setSmnode_id(rs.getString("smnode_id"));
            way.setSequence_id(rs.getString("sequence_id"));
            cachedTable.add(way);
        }
        return cachedTable;
    }
}
