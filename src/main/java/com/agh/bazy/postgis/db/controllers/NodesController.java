package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;
import com.agh.bazy.postgis.db.models.LanesSMNodesModel;
import com.agh.bazy.postgis.db.models.NodesModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Artur on 1/14/14.
 */
public class NodesController extends Controller {
    public NodesController(JDBCConncetion connection) {
        super(connection);
    }

    @Override
    public ArrayList<Object> selectTable() throws SQLException {
        ResultSet rs=selectWholeTable("krakow.nodes");
        while (rs.next()) {
            NodesModel way=new NodesModel();
            way.setId(rs.getString("id"));
            way.setGeom(rs.getString("geom"));
            way.setChangeset_id(rs.getString("changeset_id"));
            way.setTstamp(rs.getString("tstamp"));
            way.setUser_id(rs.getString("user_id"));
            way.setVersion(rs.getString("version"));
            cachedTable.add(way);
        }
        return cachedTable;

    }
}
