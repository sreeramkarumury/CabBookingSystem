package database;

import exceptions.DriverAlreadyExistsException;
import exceptions.DriverNotFoundException;
import lombok.NonNull;
import models.Cab;
import models.Driver;
import models.Location;
import utils.DistanceCalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DriversManager {
    Map<String, Driver> driverMap = new HashMap<>();

    public void createDriver(@NonNull final Driver driver){
        if(driverMap.containsKey(driver.getDriverId())){
            throw new DriverAlreadyExistsException();
        }

        driverMap.put(driver.getDriverId(), driver);
    }

    public Driver getDriver(@NonNull final String id){
        if(!driverMap.containsKey(id)){
            throw new DriverNotFoundException();
        }

        return driverMap.get(id);
    }

    public void deleteDriver(@NonNull final String id){
        if(!driverMap.containsKey(id)){
            throw new DriverNotFoundException();
        }

        driverMap.remove(id);
    }

    public void updateDriverAvailability(@NonNull final Location currentLocation,@NonNull final String driverId,
                                         @NonNull final boolean availability){
        if(!driverMap.containsKey(driverId)){
            throw new DriverNotFoundException();
        }

        //Update Driver's availability
        Driver driver = driverMap.get(driverId);
        driver.setAvailable(availability);

        //Update Cab's Current Location
        Cab cab = driver.getCab();
        cab.setCurrentLocation(currentLocation);

        driverMap.put(driverId,driver);
    }


    public List<Driver> getAllAvaiableNearestDrivers(@NonNull final Location location) {
        List<Driver> driverList = new ArrayList<>();
        for(Driver driver:driverMap.values()){
            if(driver.isAvailable() && DistanceCalculator.calculateDistance(driver.getCab().getCurrentLocation(),location) <= 10){
                driverList.add(driver);
            }
        }
        return driverList;
    }
}
