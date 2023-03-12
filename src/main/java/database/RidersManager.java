package database;

import exceptions.RiderAlreadyExistsException;
import exceptions.RiderNotFoundException;
import lombok.NonNull;
import models.Rider;
import models.Trip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RidersManager {

    Map<String ,Rider> riderMap = new HashMap<>();
    Map<String, List<Trip>> riderTripsMap = new HashMap<>();

    public void createRider(@NonNull final Rider rider){
        if(riderMap.containsKey(rider.getId())){
            throw new RiderAlreadyExistsException();
        }
        riderMap.put(rider.getId(),rider);
        riderTripsMap.put(rider.getId(),new ArrayList<Trip>());
    }

    public void deleteRider(@NonNull final String riderId){
        if(!riderTripsMap.containsKey(riderId)){
            throw new RiderNotFoundException();
        }

        riderTripsMap.remove(riderId);
    }

    public void updateRiderTrips(@NonNull final Trip trip,@NonNull final String riderId){
        if(!riderTripsMap.containsKey(riderId)){
            throw new RiderNotFoundException();
        }

        List<Trip> riderTrips = riderTripsMap.get(trip);
        if(riderTrips == null){
            riderTrips = new ArrayList<>();
        }
        riderTrips.add(trip);
        riderTripsMap.put(riderId,riderTrips);
    }

    public List<Trip> getRiderTrips(String riderId){
        if(!riderTripsMap.containsKey(riderId)){
            throw new RiderNotFoundException();
        }
        return riderTripsMap.get(riderId);
    }
}
