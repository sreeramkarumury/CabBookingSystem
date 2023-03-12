package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Setter
@Getter
public class Rider {
    private String id;
    private String name;
    private String mobileNumber;
    private double rating;
}
