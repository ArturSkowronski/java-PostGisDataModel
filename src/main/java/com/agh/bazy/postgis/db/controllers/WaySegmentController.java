package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;
import com.agh.bazy.postgis.db.models.WaySegmentModel;
import com.agh.bazy.postgis.db.models.WaysModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Artur on 1/14/14.
 */
public class WaySegmentController extends Controller {
    public WaySegmentController(JDBCConncetion connection) {
        super(connection);
    }

    @Override
    public ArrayList<Object> selectTable() throws SQLException {
        ResultSet rs=selectWholeTable("krakow.way_segments");
        while (rs.next()) {
            WaySegmentModel way=new WaySegmentModel();
            way.setId(rs.getString("id"));
            way.setWay_id(rs.getString("way_id"));
            way.setSequence_id(rs.getString("sequence_id"));
            way.setNode1_id(rs.getString("node1_id"));
            way.setNode2_id(rs.getString("node2_id"));
            way.setOneway(rs.getString("oneway"));
            way.setHighway(rs.getString("highway"));
            cachedTable.add(way);
        }
        return cachedTable;
    }
}
