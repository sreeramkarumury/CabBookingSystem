package strategies;

import models.Driver;
import models.Location;
import models.Rider;
import models.Trip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnyDriverStrategy implements CabMatchingStrategy{
    @Override
    public Trip matchDriverWithRider(Rider rider, List<Driver> availableDrivers, Location currentLocation, Location dropLocation) {
        Trip trip = new Trip(currentLocation,dropLocation,currentLocation,new ArrayList<>(Arrays.asList(rider)),availableDrivers.get(0),10
        ,System.currentTimeMillis(),System.currentTimeMillis()+100);

        return trip;
    }
}
