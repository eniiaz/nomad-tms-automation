package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.GenericRequestBody;
import models.GenericResponse;

public class APIUtils {

    private static String token = "Bearer eyJhbGciOiJIUzI1NiIsImtpZCI6ImYvQkY4c1JreTlxQWphUFIiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3BmdXF1c21pd3Zlb2RkbHZhdnFrLnN1cGFiYXNlLmNvL2F1dGgvdjEiLCJzdWIiOiI0N2I1NWE4Ni0wZjU1LTQwNmYtYTIyNC0wM2Y5Y2NmMmUzMWMiLCJhdWQiOiJhdXRoZW50aWNhdGVkIiwiZXhwIjoxNzcxODI1MzY4LCJpYXQiOjE3NzE4MjE3NjgsImVtYWlsIjoiYXBpQGdtYWlsLmNvbSIsInBob25lIjoiIiwiYXBwX21ldGFkYXRhIjp7InByb3ZpZGVyIjoiZW1haWwiLCJwcm92aWRlcnMiOlsiZW1haWwiXX0sInVzZXJfbWV0YWRhdGEiOnsiZW1haWwiOiJhcGlAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcnN0TmFtZSI6IkFQSSIsImxhc3ROYW1lIjoiVGVzdGVyIiwib3JnYW5pemF0aW9uTmFtZSI6IkFQSSBMTEMiLCJwaG9uZV92ZXJpZmllZCI6ZmFsc2UsInN1YiI6IjQ3YjU1YTg2LTBmNTUtNDA2Zi1hMjI0LTAzZjljY2YyZTMxYyJ9LCJyb2xlIjoiYXV0aGVudGljYXRlZCIsImFhbCI6ImFhbDEiLCJhbXIiOlt7Im1ldGhvZCI6InBhc3N3b3JkIiwidGltZXN0YW1wIjoxNzcxNzMxNjY2fV0sInNlc3Npb25faWQiOiIxZmM3MzY3MS1mZjU4LTRjMTQtYWQ3OS1hY2M1ODdlMGIxYjUiLCJpc19hbm9ueW1vdXMiOmZhbHNlfQ.pUrMZNerpzvG1r4KTjAXWsMPw-TSa-4qMv7tQxFA8dk";
    private static GenericResponse genericResponse;
    private static GenericResponse [] genericResponseList;

    public static void POST(GenericRequestBody body, String url)  {
        Response response = RestAssured.given().header("authorization", token).header("content-type", "application/json").
                body(body).when().post(url);
        System.out.println("Status: " + response.statusCode());
        String responseJSON = response.asString();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            genericResponse = objectMapper.readValue(responseJSON, GenericResponse.class);
        } catch (JsonProcessingException e) {
            System.out.println("Object Mapper couldn't Map the JSON into your GenericResponse type");
            throw new RuntimeException(e);
        }

    }

    public static GenericResponse getGenericResponse(){
        // more code and some logic.
        if(genericResponse == null){
            System.out.println("You first need to run API Call. Currently Generic Response is NULL");
            throw new RuntimeException("Generic Response is NULL");
        }else{
            return genericResponse;
        }
    }

    public static GenericResponse [] getGenericResponseList(){
        if(genericResponseList == null){
            System.out.println("You first need to run API Call. Currently Generic Response is NULL");
            throw new RuntimeException("Generic Response is NULL");
        }else{
            return genericResponseList;
        }
    }


    public static void GET(String url){
        Response response = RestAssured.given().header("authorization", token).header("content-type", "application/json").get(url);
        System.out.println("Status: " + response.statusCode());
        String responseJSON = response.asString();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            genericResponseList = objectMapper.readValue(responseJSON, GenericResponse[].class);
        } catch (JsonProcessingException e) {
            System.out.println("Object Mapper couldn't Map the JSON into your GenericResponse type");
            throw new RuntimeException(e);
        }
    }



}
