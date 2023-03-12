package controller;

import database.RidersManager;
import models.Rider;
import models.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 1) Register as a Rider
 * 2) Get the Rider Details (Past Rides History)
 * 3) Delete the Rider
 *
 */
@RestController
public class RiderController {

    private RidersManager ridersManager;

    public RiderController(RidersManager ridersManager){
        this.ridersManager = ridersManager;
    }

    @RequestMapping(value = "/rider" , method = RequestMethod.POST)
    public ResponseEntity createRider(String riderId,String riderName,String riderMobile){
        this.ridersManager.createRider(new Rider(riderId,riderName,riderMobile,0.0));
        return ResponseEntity.ok("Rider Created");
    }

    @RequestMapping(value = "/rider/trips",method = RequestMethod.GET)
    public ResponseEntity getPastTrips(String riderId){
        List<Trip> pastTrips = this.ridersManager.getRiderTrips(riderId);
        return ResponseEntity.ok(pastTrips);
    }

    @RequestMapping(value = "/rider",method = RequestMethod.DELETE)
    public ResponseEntity deleteRider(String riderId){
        this.ridersManager.deleteRider(riderId);
        return ResponseEntity.ok("Rider Deleted");
    }

}
