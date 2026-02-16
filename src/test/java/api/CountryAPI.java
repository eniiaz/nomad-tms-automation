package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountryAPI {

    @Test
    public void currencyTest(){

        // 1. Collect all the API details
        // 2. Make a API call/request
        // 3. get and Store the response
        // 4. Read the piece of data(target data)
        // 5. Assertion/Validation

        Response response = RestAssured.get("https://restcountries.com/v3.1/name/russian");

        System.out.println(response.statusCode());
        String resultString = response.asString();

        String currencyName = response.jsonPath().getString("[0].currencies.RUB.name");

        System.out.println(currencyName);

        Assertions.assertEquals("russian ruble", currencyName);

    }

}
