package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;
import com.agh.bazy.postgis.db.models.LanesSMNodesModel;
import com.agh.bazy.postgis.db.models.SMNodesModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Artur on 1/14/14.
 */
public class SMNodesController extends Controller {
    public SMNodesController(JDBCConncetion connection) {
        super(connection);
    }

    @Override
    public ArrayList<Object> selectTable() throws SQLException {
        ResultSet rs=selectWholeTable("krakow.smnodes");
        while (rs.next()) {
            SMNodesModel way=new SMNodesModel();
            way.setId(rs.getString("id"));
            way.setGeom(rs.getString("geom"));
            way.setNode_id(rs.getString("node_id"));
            cachedTable.add(way);
        }
        return cachedTable;

    }
}
