package strategies;

import models.Driver;
import models.Location;
import models.Rider;
import models.Trip;

import java.util.List;

public class MoreClosestDriverStrategy implements CabMatchingStrategy{
    @Override
    public Trip matchDriverWithRider(Rider rider, List<Driver> availableDrivers, Location currentLocation, Location dropLocation) {
        return null;
    }
}
