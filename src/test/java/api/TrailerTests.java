package api;

import models.GenericRequestBody;
import models.GenericResponse;
import org.junit.jupiter.api.Test;
import utilities.APIUtils;

public class TrailerTests {


    @Test
    public void createTrailer(){

        GenericRequestBody requestBody = new GenericRequestBody();

        requestBody.make = "Great Dane";
        requestBody.type = "Flatbed";
        requestBody.ownership = "Lease";
        requestBody.vin = "1HGCM82633A123456";
        requestBody.model = "TrailPro";
        requestBody.unit_number = "U-0938";
        requestBody.year = 2012;
        requestBody.plate_number = "IL2847";

        String trailerCreationURL = "https://nomadtms.up.railway.app/api/trailers";

        APIUtils.POST(requestBody, trailerCreationURL);

        System.out.println(APIUtils.getGenericResponse().make);
        System.out.println(APIUtils.getGenericResponse().unit_number);

    }

    @Test
    public void trailerList(){
        String trailerCreationURL = "https://nomadtms.up.railway.app/api/trailers";
        APIUtils.GET(trailerCreationURL);
        for(GenericResponse trailer: APIUtils.getGenericResponseList()){
            System.out.println(trailer.make);
            System.out.println(trailer.unit_number);
            System.out.println(trailer.type);
            System.out.println(trailer.plate_number);
            System.out.println();

        }
    }

}
