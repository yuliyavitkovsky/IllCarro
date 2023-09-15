package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class Car {

    String location;
    String manufacture;
    String model;
    String year;
    String fuel;
    String seats;
    String carClass;
    String carRegNumber;
    String price;
    String about;

}
