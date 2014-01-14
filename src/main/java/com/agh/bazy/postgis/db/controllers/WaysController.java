package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;
import com.agh.bazy.postgis.db.models.WaysModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Artur on 1/13/14.
 */
public class WaysController extends Controller{
    public WaysController(JDBCConncetion connection) {
        super(connection);
    }

    public ArrayList<Object> selectTable() throws SQLException {
        ResultSet rs=selectWholeTable("krakow.ways");
        while (rs.next()) {
            WaysModel way=new WaysModel();
            way.setId(rs.getString("id"));
            way.setVersion(rs.getString("version"));
            way.setUser_id(rs.getString("user_id"));
            way.setTstamp(rs.getString("tstamp"));
            way.setChangeset_id(rs.getString("changeset_id"));
            cachedTable.add(way);
        }
        return cachedTable;
    }
}
