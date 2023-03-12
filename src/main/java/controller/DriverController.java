package controller;

import database.DriversManager;
import database.TripManager;
import models.Cab;
import models.CabType;
import models.Driver;
import models.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 1) Register Driver (Driver Enrolled in the System as a Cab provider)
 * 2) Update Driver's Details (Available/Not Available), (Update Rating,Associated Cab)
 * 3) Delete Driver (Delete Driver from the System)
 * 4) Get All Available Driver's (Get all Available Drivers nearest to the Rider's Location)
 * 5) Trip Management (Accept a Trip, Start a Trip and End A Trip)
 */
@RestController
public class DriverController {
    private DriversManager driversManager;
    private TripManager tripManager;

    public DriverController(DriversManager driversManager, TripManager tripManager) {
        this.driversManager = driversManager;
        this.tripManager = tripManager;
    }

    @RequestMapping(value = "/driver",method = RequestMethod.POST)
    public ResponseEntity register(String driverId, String driverName, String driverMobile, String cabId, String model, CabType type){
        Driver driver  = new Driver(driverId,driverName,driverMobile,0.0,0,true,new Cab(cabId,model,type));
        this.driversManager.createDriver(driver);
        return ResponseEntity.ok("Driver Registered");
    }

    @RequestMapping(value = "/driver",method = RequestMethod.GET)
    public ResponseEntity fetch(String driverId){
        Driver driver = this.driversManager.getDriver(driverId);
        return ResponseEntity.ok(driver);
    }

    @RequestMapping(value = "/driver",method = RequestMethod.DELETE)
    public ResponseEntity delete(String driverId){
        this.driversManager.deleteDriver(driverId);
        return ResponseEntity.ok("Driver Deleted");
    }

    @RequestMapping(value = "/driver/availability",method = RequestMethod.PATCH)
    public ResponseEntity update(String driverId, boolean availability, Location currentLocation){
        this.driversManager.updateDriverAvailability(currentLocation,driverId,availability);
        return ResponseEntity.ok("Driver Availability Updated");
    }

    @RequestMapping(value = "/drivers" ,method = RequestMethod.GET)
    public ResponseEntity get(Location currentLocation){
        List<Driver> drivers = this.driversManager.getAllAvaiableNearestDrivers(currentLocation);
        return ResponseEntity.ok(drivers);
    }

}
