package com.agh.bazy.postgis.db.controllers;

import com.agh.bazy.postgis.JDBCConncetion;
import com.agh.bazy.postgis.db.models.WaysModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Artur on 1/14/14.
 */
public abstract class Controller {
    JDBCConncetion connection=null;
    ArrayList<Object> cachedTable = new ArrayList<Object>();

    protected Controller(JDBCConncetion connection) {
        this.connection = connection;
    }

    public ArrayList<Object> getCachedTable() throws SQLException {
        if(cachedTable.size()==0) selectTable();
        return cachedTable;
    }
    public ResultSet selectWholeTable(String table) throws SQLException {
        System.out.println("Get data: "+table);
        String selectTableSQL = "SELECT * from "+table;
        return connection.getStatement().executeQuery(selectTableSQL);
    }

    public abstract ArrayList<Object> selectTable() throws SQLException;

    }
