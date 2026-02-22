package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CountryAPI {

    @Test
    public void currencyTest(){

        // 1. Collect all the API details
        // 2. Make a API call/request
        // 3. get and Store the response
        // 4. Read the piece of data(target data)
        // 5. Assertion/Validation

        Response response = RestAssured.get("https://restcountries.com/v3.1/name/russia");

        System.out.println(response.statusCode());
        String resultString = response.asString();

        String currencyName = response.jsonPath().getString("[0].currencies.RUB.name");

        System.out.println(currencyName);

        Assertions.assertEquals("russian ruble", currencyName.toLowerCase());

        String altName = response.jsonPath().getString("[0].altSpellings[2]");

        System.out.println("Alt Name: " + altName);

        List<String> russianBorders = response.jsonPath().getList("[0].borders");

        System.out.println("Border size: " + russianBorders.size());

        String expectedBorders = "AZE, BLR, CHN, EST, FIN, GEO, KAZ, PRK, LVA, LTU, MNG, NOR, POL, UKR";

        for(String border: russianBorders){
            Assertions.assertTrue(expectedBorders.contains(border), "Border: " + border + " is not in the expected list of borders: " + expectedBorders);
        }
        // Expected Result
        List<Integer> coordinates = response.jsonPath().getList("[0].latlng");

        System.out.println(coordinates.size());


    }

}
