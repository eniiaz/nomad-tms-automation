package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Truck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TruckTests {

    @Test
    public void truckDetailsTest(){

        String token = "Bearer eyJhbGciOiJIUzI1NiIsImtpZCI6ImYvQkY4c1JreTlxQWphUFIiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3BmdXF1c21pd3Zlb2RkbHZhdnFrLnN1cGFiYXNlLmNvL2F1dGgvdjEiLCJzdWIiOiI0N2I1NWE4Ni0wZjU1LTQwNmYtYTIyNC0wM2Y5Y2NmMmUzMWMiLCJhdWQiOiJhdXRoZW50aWNhdGVkIiwiZXhwIjoxNzcxMjIwMTM1LCJpYXQiOjE3NzEyMTY1MzUsImVtYWlsIjoiYXBpQGdtYWlsLmNvbSIsInBob25lIjoiIiwiYXBwX21ldGFkYXRhIjp7InByb3ZpZGVyIjoiZW1haWwiLCJwcm92aWRlcnMiOlsiZW1haWwiXX0sInVzZXJfbWV0YWRhdGEiOnsiZW1haWwiOiJhcGlAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcnN0TmFtZSI6IkFQSSIsImxhc3ROYW1lIjoiVGVzdGVyIiwib3JnYW5pemF0aW9uTmFtZSI6IkFQSSBMTEMiLCJwaG9uZV92ZXJpZmllZCI6ZmFsc2UsInN1YiI6IjQ3YjU1YTg2LTBmNTUtNDA2Zi1hMjI0LTAzZjljY2YyZTMxYyJ9LCJyb2xlIjoiYXV0aGVudGljYXRlZCIsImFhbCI6ImFhbDEiLCJhbXIiOlt7Im1ldGhvZCI6InBhc3N3b3JkIiwidGltZXN0YW1wIjoxNzcxMjA5OTYyfV0sInNlc3Npb25faWQiOiI3MGEwYThiMy0zNzZlLTQyNDYtOGYzMS1mMTg1ZDQzZTM0ODciLCJpc19hbm9ueW1vdXMiOmZhbHNlfQ.QXJXzkEOgrflMr_urKr_yDUPzoPVlXkHJrhPc_AoERY";

        Response response = RestAssured.given().header("authorization", token).header("content-type", "application/json").get("https://nomadtms.up.railway.app/api/trucks");

        System.out.println(response.statusCode());

        String plateNum1 = response.jsonPath().getString("[0].plate_number");
        String vinNum1 = response.jsonPath().getString("[0].vin");

        response.prettyPrint();
        System.out.println(plateNum1);
        System.out.println(vinNum1);

        Assertions.assertTrue(plateNum1.startsWith("IL") && plateNum1.length() == 7);
        Assertions.assertTrue(vinNum1.length() == 16);

    }

//    @Test
//    public void truckTEst() throws JsonProcessingException {
//
//        String token = "Bearer eyJhbGciOiJIUzI1NiIsImtpZCI6ImYvQkY4c1JreTlxQWphUFIiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3BmdXF1c21pd3Zlb2RkbHZhdnFrLnN1cGFiYXNlLmNvL2F1dGgvdjEiLCJzdWIiOiI0N2I1NWE4Ni0wZjU1LTQwNmYtYTIyNC0wM2Y5Y2NmMmUzMWMiLCJhdWQiOiJhdXRoZW50aWNhdGVkIiwiZXhwIjoxNzcxNzIwMDM0LCJpYXQiOjE3NzE3MTY0MzQsImVtYWlsIjoiYXBpQGdtYWlsLmNvbSIsInBob25lIjoiIiwiYXBwX21ldGFkYXRhIjp7InByb3ZpZGVyIjoiZW1haWwiLCJwcm92aWRlcnMiOlsiZW1haWwiXX0sInVzZXJfbWV0YWRhdGEiOnsiZW1haWwiOiJhcGlAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcnN0TmFtZSI6IkFQSSIsImxhc3ROYW1lIjoiVGVzdGVyIiwib3JnYW5pemF0aW9uTmFtZSI6IkFQSSBMTEMiLCJwaG9uZV92ZXJpZmllZCI6ZmFsc2UsInN1YiI6IjQ3YjU1YTg2LTBmNTUtNDA2Zi1hMjI0LTAzZjljY2YyZTMxYyJ9LCJyb2xlIjoiYXV0aGVudGljYXRlZCIsImFhbCI6ImFhbDEiLCJhbXIiOlt7Im1ldGhvZCI6InBhc3N3b3JkIiwidGltZXN0YW1wIjoxNzcxMjA5OTYyfV0sInNlc3Npb25faWQiOiI3MGEwYThiMy0zNzZlLTQyNDYtOGYzMS1mMTg1ZDQzZTM0ODciLCJpc19hbm9ueW1vdXMiOmZhbHNlfQ.ovrhY25006t7ow6vYS45VJa0PQtW13w8Sizfg0x8oCs";
//
//
//
//        Truck truck = new Truck();
//        truck.name = "BB Ru Nu GG";
//        truck.model = "Miko";
//        truck.unit_number = "82072223";
//        truck.plate_number = "894244482442429";
//        truck.vin = "928492823244982309";
//        truck.year = 2011;
//        truck.state = "CA";
//
//        Response response = RestAssured.given().header("authorization", token).header("content-type", "application/json").body(truck).when().post("https://nomadtms.up.railway.app/api/trucks");
//
//        System.out.println(response.statusCode());
//
//        ObjectMapper mapper = new ObjectMapper();
//
//        // ✅ DESERIALIZE
//        Truck truckResponse = mapper.readValue(response.asString(), Truck.class);
//
//        System.out.println("Result: " + truckResponse.name);
//        System.out.println("Result: " + truckResponse.year);
//
//    }

}
