package com.agh.bazy.postgis;

import com.agh.bazy.postgis.model.Crossroad;
import com.agh.bazy.postgis.model.LocationPoint;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Artur on 1/11/14.
 */
public class Generator {
    Set<Crossroad> crossroadsSet = new LinkedHashSet<>();
    final int AMOUNT_OF_CROSSROADS=2500;
    final int SIZE=2500;
    public void generateData(){
        System.out.println("Generating crossroads...");
        generateCrossroads();
        System.out.println("Generated " + crossroadsSet.size() + " dummy crossroads");
        System.out.println("Generating dummy ways");
        generateRoads();

    }

    private Object getHashRandomElement(Set myHashSet){
        int size = myHashSet.size();
        int item = new Random().nextInt(size); // In real life, the Random object should be rather more shared than this
        int i = 0;
        for(Object obj : myHashSet)
        {
            if (i == item)
                return obj;
            i = i + 1;
        }
        return null;
    }

    private void generateCrossroads() {
        int amount=0;
        while(amount<AMOUNT_OF_CROSSROADS){
            int Min=0;
            int Max=SIZE;
            int x= Min + (int)(Math.random() * ((Max - Min) + 1));
            int y= Min + (int)(Math.random() * ((Max - Min) + 1));
            LocationPoint locationPoint=new LocationPoint(x, y);
            Crossroad crossroad=new Crossroad(locationPoint);
            if(crossroadsSet.add(crossroad))amount++;
        }

    }

    private void generateRoads(){
        int generateRoadsRun=0;
        int targetRoadAmount=3;
        if(generateRoadsRun>0)targetRoadAmount=2;
        for (Crossroad tf : crossroadsSet) {
            if(tf.getRoadListSize()<targetRoadAmount){
                Crossroad anotherCrossroad = (Crossroad) getHashRandomElement(crossroadsSet);
                if(anotherCrossroad==tf){}
                else{

                }
            }
        }
    }
}
