    package com.agh.bazy.postgis;

import com.agh.bazy.postgis.db.controllers.*;
import com.agh.bazy.postgis.db.models.CrossroadWaysModel;
import com.agh.bazy.postgis.db.models.CrossroadsModel;
import com.agh.bazy.postgis.db.models.WaysModel;
import com.agh.bazy.postgis.model.Crossroad;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Artur on 1/11/14.
 */
public class DB {
    private static ArrayList<Object> waysTable;
    private static ArrayList<Object> wayNodesTable;
    private static ArrayList<Object> waySegmentsTable;
    private static ArrayList<Object> lanesTable;
    private static ArrayList<Object> lanesSMNodesTable;
    private static ArrayList<Object> SMNodesTable;
    private static ArrayList<Object> nodesTable;
    private static ArrayList<Object> crossroadWayTable;
    private static ArrayList<Object> crossroadTable;

    public static void main(String[] argv) {
        Generator generator=new Generator();
        DB db = new DB();
        JDBCConncetion connection= db.startJDBCConnection();
        WaysController ways=new WaysController(connection);
        WayNodesController wayNodes=new WayNodesController(connection);
        WaySegmentController waySegments=new WaySegmentController(connection);
        LanesController lanes=new LanesController(connection);
        LanesSMNodesController lanesSMNodes=new LanesSMNodesController(connection);
        CrossroadWaysController crossroadWay= new CrossroadWaysController(connection);
        SMNodesController SMNodes=new SMNodesController(connection);
        NodesController nodes=new NodesController(connection);
        CrossroadsController crossroads= new CrossroadsController(connection);
        try {
     //     waysTable=ways.getCachedTable();
     //     wayNodesTable=wayNodes.getCachedTable();
            waySegmentsTable=waySegments.getCachedTable();
            lanesTable=lanes.getCachedTable();
            lanesSMNodesTable=lanesSMNodes.getCachedTable();
            crossroadWayTable=crossroadWay.getCachedTable();

            //SMNodesTable=SMNodes.getCachedTable();
            //nodesTable=nodes.getCachedTable();
            //crossroadTable=crossroads.getCachedTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        generator.generateData();

    }

    private JDBCConncetion startJDBCConnection() {
        JDBCConncetion jdbcConncetion= new JDBCConncetion();
        try {
            jdbcConncetion.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jdbcConncetion;
    }
}
