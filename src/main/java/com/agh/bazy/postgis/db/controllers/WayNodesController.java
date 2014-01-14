package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;
import com.agh.bazy.postgis.db.models.WayNodeModel;
import com.agh.bazy.postgis.db.models.WaysModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Artur on 1/14/14.
 */
public class WayNodesController extends Controller {
    public WayNodesController(JDBCConncetion connection) {
        super(connection);
    }

    @Override
    public ArrayList<Object> selectTable() throws SQLException {

        ResultSet rs=selectWholeTable("krakow.way_nodes");
        while (rs.next()) {
            WayNodeModel way=new WayNodeModel();
            way.setWay_id(rs.getString("way_id"));
            way.setNode_id(rs.getString("node_id"));
            way.setSequence_id(rs.getString("sequence_id"));
            cachedTable.add(way);
        }
        return cachedTable;
    }
}
