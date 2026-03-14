package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.GenericRequestBody;
import models.GenericResponse;

public class APIUtils {

    private static GenericResponse genericResponse;
    private static GenericResponse [] genericResponseList;

    public static void POST(GenericRequestBody body, String url)  {
        Response response = RestAssured.given().header("authorization", ConfigUtil.getValue("apiToken")).header("content-type", "application/json").
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
        Response response = RestAssured.given().header("authorization", ConfigUtil.getValue("apiToken")).header("content-type", "application/json").get(url);
        System.out.println("Status: " + response.statusCode());
        String responseJSON = response.asString();

        System.out.println(responseJSON);
        System.out.println();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            genericResponseList = objectMapper.readValue(responseJSON, GenericResponse[].class);
        } catch (JsonProcessingException e) {
            System.out.println("Object Mapper couldn't Map the JSON into your GenericResponse type");
            throw new RuntimeException(e);
        }
    }



}
