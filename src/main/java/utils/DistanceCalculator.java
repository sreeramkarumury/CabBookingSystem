package utils;

import models.Location;

public class DistanceCalculator {
    public static double calculateDistance(Location start, Location end){
        //Calculate Distance between pickup and drop
        return Math.sqrt(Math.pow(end.getX()-start.getX(),2)+Math.pow(end.getY()-start.getY(),2));
    }
}
