package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Truck {

    public String status;
    public String assignment_status;
    public int odometer;
    public String name;
    public String model;
    public String unit_number;
    public String plate_number;
    public String vin;
    public int year;
    public String state;

}
