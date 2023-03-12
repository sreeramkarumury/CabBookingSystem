package controller;

import database.DriversManager;
import exceptions.DriversNotFoundException;
import models.Driver;
import models.Location;
import models.Rider;
import models.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import strategies.CabMatchingStrategy;

import java.util.List;

@RestController
public class TripController {

    private DriversManager driversManager;

    public TripController(DriversManager driversManager){
        this.driversManager = driversManager;
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity bookCab(Rider rider, Location pickUpLocation, Location dropLocation, CabMatchingStrategy cabMatchingStrategy){
        //Find Available Cabs
        List<Driver> driverList = this.driversManager.getAllAvaiableNearestDrivers(pickUpLocation);
        if(driverList.isEmpty()){
            throw new DriversNotFoundException();
        }

        //Match Driver with Rider and create a trip
        Trip trip = cabMatchingStrategy.matchDriverWithRider(rider,driverList,pickUpLocation,dropLocation);
        String responseBody = String.format("Cab Booked, Driver on the way !! , Details : %s",trip);
        return ResponseEntity.ok(responseBody);
    }
}
