    package com.agh.bazy.postgis;

import com.agh.bazy.postgis.db.controllers.*;
import com.agh.bazy.postgis.db.models.*;
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

            SMNodesTable=SMNodes.getCachedTable();
            nodesTable=nodes.getCachedTable();
            crossroadTable=crossroads.getCachedTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Populowanie LANES_SMNODES
        for(Object lane_smnode : lanesSMNodesTable){
           LanesSMNodesModel lane_smnodeObject= (LanesSMNodesModel) lane_smnode;
           for(Object lane : lanesTable){
               LanesModel laneObject= (LanesModel) lane;
               if(laneObject.getId().equals(lane_smnodeObject.getLane_id()))lane_smnodeObject.setLane(laneObject);
           }
            for(Object smnode : SMNodesTable){
                SMNodesModel smnodeObject= (SMNodesModel) smnode;
                if(smnodeObject.getId().equals(lane_smnodeObject.getSmnode_id()))lane_smnodeObject.setSmNode(smnodeObject);
            }
        }

        //Populowanie WAY_SEGMENTS
        for(Object way_segment : waySegmentsTable){
            WaySegmentModel way_segmentObject = (WaySegmentModel) way_segment;
            for(Object node : nodesTable){
                NodesModel laneObject= (NodesModel) node;
                if(laneObject.getId().equals(way_segmentObject.getNode1_id()))way_segmentObject.setNode1(laneObject);
                if(laneObject.getId().equals(way_segmentObject.getNode2_id()))way_segmentObject.setNode2(laneObject);
            }
        }

        //Populowanie CROSSROAD_WAYS
        for(Object crossroad_way : crossroadWayTable){
            CrossroadWaysModel crossroad_wayObject = (CrossroadWaysModel) crossroad_way;
            for(Object way_segment : waySegmentsTable){
                WaySegmentModel way_segmentObject = (WaySegmentModel) way_segment;
                if(way_segmentObject.getId().equals(crossroad_wayObject.getWay_segment_id()))crossroad_wayObject.setWaySegment(way_segmentObject);
           }

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
