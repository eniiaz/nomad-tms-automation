package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericResponse {

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
    public String phone;
    public String tax_id;
    public String mc_number;
    public String email;
    public String dot_number;
    public String make;
    public String type;
    public String ownership;
}
