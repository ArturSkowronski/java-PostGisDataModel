package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;
import com.agh.bazy.postgis.db.models.CrossroadWaysModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Artur on 1/14/14.
 */
public class CrossroadWaysController extends Controller {

    public CrossroadWaysController(JDBCConncetion connection) {
        super(connection);
    }

    @Override
    public ArrayList<Object> selectTable() throws SQLException {
        ResultSet rs=selectWholeTable("krakow.crossroad_ways");
        while (rs.next()) {
            CrossroadWaysModel way=new CrossroadWaysModel();
            way.setCrosroad_id(rs.getString("crosroad_id"));
            way.setWay_segment_id(rs.getString("way_segment_id"));
            way.setRole(rs.getString("role"));
            cachedTable.add(way);
        }
        return cachedTable;
    }
}
