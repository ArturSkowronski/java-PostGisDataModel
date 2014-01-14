package com.agh.bazy.postgis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Artur on 1/11/14.
 */
public class JDBCConncetion {
    public Connection getConnection() {
        return connection;
    }

    Connection connection = null;
    Statement statement = null;

    public JDBCConncetion() {

    }

    public Statement getStatement() throws SQLException {
        return statement = connection.createStatement();

    }

    public Connection connect() throws ClassNotFoundException, SQLException {
        System.out.println("-------- PostgreSQL "  + "JDBC Connection Testing ------------");
        Class.forName("org.postgresql.Driver");
        String host="localhost";
        String username="postgres";
        String password="cbtcsz1";
        String port="5432";
        String db="zikit";
        System.out.println("jdbc:postgresql://"+host+":"+port+"/"+db+":"+username+":"+password);
        connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db, username, password);
        System.out.println("Connected");
        return connection;
    }
}
