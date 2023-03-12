package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Driver {
    public String driverId;
    public String driverName;
    public String driverMobile;
    public double rating;
    public int numberOfTrips;
    public boolean available;
    public Cab cab;
}
