package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Trip {
    private Location pickUpLocation;
    private Location dropLocation;
    private Location currentLocation;
    private List<Rider> riders;
    private Driver driver;
    private double cost;
    private long startTimeInMillis;
    private long endTimeInMillis;
}
