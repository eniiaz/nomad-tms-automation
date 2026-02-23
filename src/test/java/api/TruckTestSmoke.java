package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Truck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TruckTestSmoke {

    @Test
    public void createTruck() throws JsonProcessingException {

        Truck truck = new Truck();

        truck.name = "Decent Duper Truck";
        truck.model = "HsST";
        truck.unit_number = "1923";
        truck.plate_number = "IL2389824G";
        truck.year = 2021;
        truck.vin = "24802847243082";
        truck.state = "IL";

        String token = "Bearer eyJhbGciOiJIUzI1NiIsImtpZCI6ImYvQkY4c1JreTlxQWphUFIiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3BmdXF1c21pd3Zlb2RkbHZhdnFrLnN1cGFiYXNlLmNvL2F1dGgvdjEiLCJzdWIiOiI0N2I1NWE4Ni0wZjU1LTQwNmYtYTIyNC0wM2Y5Y2NmMmUzMWMiLCJhdWQiOiJhdXRoZW50aWNhdGVkIiwiZXhwIjoxNzcxNzM5Mjc0LCJpYXQiOjE3NzE3MzU2NzQsImVtYWlsIjoiYXBpQGdtYWlsLmNvbSIsInBob25lIjoiIiwiYXBwX21ldGFkYXRhIjp7InByb3ZpZGVyIjoiZW1haWwiLCJwcm92aWRlcnMiOlsiZW1haWwiXX0sInVzZXJfbWV0YWRhdGEiOnsiZW1haWwiOiJhcGlAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcnN0TmFtZSI6IkFQSSIsImxhc3ROYW1lIjoiVGVzdGVyIiwib3JnYW5pemF0aW9uTmFtZSI6IkFQSSBMTEMiLCJwaG9uZV92ZXJpZmllZCI6ZmFsc2UsInN1YiI6IjQ3YjU1YTg2LTBmNTUtNDA2Zi1hMjI0LTAzZjljY2YyZTMxYyJ9LCJyb2xlIjoiYXV0aGVudGljYXRlZCIsImFhbCI6ImFhbDEiLCJhbXIiOlt7Im1ldGhvZCI6InBhc3N3b3JkIiwidGltZXN0YW1wIjoxNzcxNzMxNjY2fV0sInNlc3Npb25faWQiOiIxZmM3MzY3MS1mZjU4LTRjMTQtYWQ3OS1hY2M1ODdlMGIxYjUiLCJpc19hbm9ueW1vdXMiOmZhbHNlfQ.5ah_QZA_XP3uv8Crf3pjdbg9EoeZgXDuVWCt01cBTxo";

        Response response = RestAssured.given().header("authorization", token).header("content-type", "application/json").
                                                           body(truck).when().post("https://nomadtms.up.railway.app/api/trucks");

        System.out.println("Status: " + response.statusCode());
        String responseJSON = response.asString();

        ObjectMapper objectMapper = new ObjectMapper();

        Truck responsePOJO = objectMapper.readValue(responseJSON, Truck.class);

        System.out.println("Name: " + responsePOJO.name);
        System.out.println("Year: " + responsePOJO.year);
        System.out.println("State: " + responsePOJO.state);
    }

    @Test
    public void getTrucksList() throws JsonProcessingException {

        String token = "Bearer eyJhbGciOiJIUzI1NiIsImtpZCI6ImYvQkY4c1JreTlxQWphUFIiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3BmdXF1c21pd3Zlb2RkbHZhdnFrLnN1cGFiYXNlLmNvL2F1dGgvdjEiLCJzdWIiOiI0N2I1NWE4Ni0wZjU1LTQwNmYtYTIyNC0wM2Y5Y2NmMmUzMWMiLCJhdWQiOiJhdXRoZW50aWNhdGVkIiwiZXhwIjoxNzcxNzM5Mjc0LCJpYXQiOjE3NzE3MzU2NzQsImVtYWlsIjoiYXBpQGdtYWlsLmNvbSIsInBob25lIjoiIiwiYXBwX21ldGFkYXRhIjp7InByb3ZpZGVyIjoiZW1haWwiLCJwcm92aWRlcnMiOlsiZW1haWwiXX0sInVzZXJfbWV0YWRhdGEiOnsiZW1haWwiOiJhcGlAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcnN0TmFtZSI6IkFQSSIsImxhc3ROYW1lIjoiVGVzdGVyIiwib3JnYW5pemF0aW9uTmFtZSI6IkFQSSBMTEMiLCJwaG9uZV92ZXJpZmllZCI6ZmFsc2UsInN1YiI6IjQ3YjU1YTg2LTBmNTUtNDA2Zi1hMjI0LTAzZjljY2YyZTMxYyJ9LCJyb2xlIjoiYXV0aGVudGljYXRlZCIsImFhbCI6ImFhbDEiLCJhbXIiOlt7Im1ldGhvZCI6InBhc3N3b3JkIiwidGltZXN0YW1wIjoxNzcxNzMxNjY2fV0sInNlc3Npb25faWQiOiIxZmM3MzY3MS1mZjU4LTRjMTQtYWQ3OS1hY2M1ODdlMGIxYjUiLCJpc19hbm9ueW1vdXMiOmZhbHNlfQ.5ah_QZA_XP3uv8Crf3pjdbg9EoeZgXDuVWCt01cBTxo";

        Response response = RestAssured.given().header("authorization", token).header("content-type", "application/json").get("https://nomadtms.up.railway.app/api/trucks");

        System.out.println("Status: " + response.statusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        Truck [] allTrucks = objectMapper.readValue(response.asString(), Truck[].class);

        System.out.println("Size: " + allTrucks.length);

        for(Truck truck: allTrucks){
            System.out.println("name: " + truck.name);
            System.out.println("Vin: " + truck.vin);
            System.out.println();
            Assertions.assertNotNull(truck.name, "Truck name is null here");
            Assertions.assertNotNull(truck.vin, "Truck name is null here");
        }

    }

}
