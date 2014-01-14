package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Artur on 1/14/14.
 */
public class WayTagsController extends Controller {
    protected WayTagsController(JDBCConncetion connection) {
        super(connection);
    }

    @Override
    public ArrayList<Object> selectTable() throws SQLException {
        return null;
    }
}
