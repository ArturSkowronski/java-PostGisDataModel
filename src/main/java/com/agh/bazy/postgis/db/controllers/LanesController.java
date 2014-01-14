package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;
import com.agh.bazy.postgis.db.models.LanesModel;
import com.agh.bazy.postgis.db.models.WayNodeModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Artur on 1/14/14.
 */
public class LanesController extends Controller {
    public LanesController(JDBCConncetion connection) {
        super(connection);
    }

    @Override
    public ArrayList<Object> selectTable() throws SQLException {

        ResultSet rs=selectWholeTable("krakow.lanes");
        while (rs.next()) {
            LanesModel way=new LanesModel();
            way.setId(rs.getString("id"));
            way.setNumber(rs.getString("number"));
            way.setWay_id(rs.getString("way_id"));
            cachedTable.add(way);
        }
        return cachedTable;
    }
}
