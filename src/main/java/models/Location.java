package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@AllArgsConstructor
public class Location {
    private double x;
    private double y;

    public Double calculateDistance(Location start,Location end){
        return Math.sqrt(Math.pow(end.x-start.x,2)+Math.pow(end.y-start.y,2));
    }

}
