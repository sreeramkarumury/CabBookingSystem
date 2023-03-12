package models;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Cab {
    private String id;
    @Setter private String model;
    @Setter private CabType type;
    @Setter private Location currentLocation;

    public Cab(String id, String model, CabType type) {
        this.id = id;
        this.model = model;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", type=" + type +
                ", currentLocation=" + currentLocation +
                '}';
    }
}
