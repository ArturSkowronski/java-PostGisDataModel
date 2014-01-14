package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;
import com.agh.bazy.postgis.db.models.CrossroadsModel;
import org.postgis.PGgeometry;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Artur on 1/14/14.
 */
public class CrossroadsController extends Controller {
    public CrossroadsController(JDBCConncetion connection) {
        super(connection);
    }

    @Override
    public ArrayList<Object> selectTable() throws SQLException {
        ResultSet rs=selectWholeTable("krakow.crossroads");
        while (rs.next()) {
            CrossroadsModel way=new CrossroadsModel();
            way.setId(rs.getString("id"));
            way.setName(rs.getString("name"));
            way.setBoundary((PGgeometry)rs.getObject(3));
            cachedTable.add(way);
        }
        return cachedTable;
    }
}
