package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import models.Company;
import models.GenericRequestBody;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.APIUtils;
import utilities.EmailUtils;

public class CompanyTests {


    @Test
    public void getAllCompanies() throws JsonProcessingException {

        String token = "Bearer eyJhbGciOiJIUzI1NiIsImtpZCI6ImYvQkY4c1JreTlxQWphUFIiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL3BmdXF1c21pd3Zlb2RkbHZhdnFrLnN1cGFiYXNlLmNvL2F1dGgvdjEiLCJzdWIiOiI0N2I1NWE4Ni0wZjU1LTQwNmYtYTIyNC0wM2Y5Y2NmMmUzMWMiLCJhdWQiOiJhdXRoZW50aWNhdGVkIiwiZXhwIjoxNzcxODE5NjAwLCJpYXQiOjE3NzE4MTYwMDAsImVtYWlsIjoiYXBpQGdtYWlsLmNvbSIsInBob25lIjoiIiwiYXBwX21ldGFkYXRhIjp7InByb3ZpZGVyIjoiZW1haWwiLCJwcm92aWRlcnMiOlsiZW1haWwiXX0sInVzZXJfbWV0YWRhdGEiOnsiZW1haWwiOiJhcGlAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImZpcnN0TmFtZSI6IkFQSSIsImxhc3ROYW1lIjoiVGVzdGVyIiwib3JnYW5pemF0aW9uTmFtZSI6IkFQSSBMTEMiLCJwaG9uZV92ZXJpZmllZCI6ZmFsc2UsInN1YiI6IjQ3YjU1YTg2LTBmNTUtNDA2Zi1hMjI0LTAzZjljY2YyZTMxYyJ9LCJyb2xlIjoiYXV0aGVudGljYXRlZCIsImFhbCI6ImFhbDEiLCJhbXIiOlt7Im1ldGhvZCI6InBhc3N3b3JkIiwidGltZXN0YW1wIjoxNzcxNzMxNjY2fV0sInNlc3Npb25faWQiOiIxZmM3MzY3MS1mZjU4LTRjMTQtYWQ3OS1hY2M1ODdlMGIxYjUiLCJpc19hbm9ueW1vdXMiOmZhbHNlfQ.RN4WLMdRMobEdSEwfNPPK_H7e8d83NnTWr4bw_tiSjg";

        Response response = RestAssured.given().header("authorization", token).header("content-type", "application/json").get("https://nomadtms.up.railway.app/api/companies");

        System.out.println("Status: " + response.statusCode());

        System.out.println();

        ObjectMapper objectMapper = new ObjectMapper();

        Company [] allCompanies = objectMapper.readValue(response.asString(), Company[].class);

        for (Company singleCompany: allCompanies){

            System.out.println("name: " + singleCompany.name);
            System.out.println();

            Assertions.assertNotNull(singleCompany.name, "Company name is a NULL: " + singleCompany.name);
            boolean emailValidityResult = EmailUtils.isValidEmail(singleCompany.email);
//            Assertions.assertTrue(emailValidityResult, "Email Validation failed: " + singleCompany.email);

            Assertions.assertEquals(9, singleCompany.tax_id.length(), "Tax ID length failed: " + singleCompany.tax_id);


        }

    }


    @Test
    public void companyCreation(){

        String url = "https://nomadtms.up.railway.app/api/companies";

        GenericRequestBody requestBody = new GenericRequestBody();
        requestBody.name = "My Newest Compani";
        requestBody.email = "compie@gmail.com";
        requestBody.phone = "340284204";
        requestBody.mc_number = "3298ru23092";
        requestBody.tax_id = "328094u7230";
        requestBody.dot_number = "24084jd";
        APIUtils.POST(requestBody, url);

        System.out.println(APIUtils.getGenericResponse().name);
        System.out.println(APIUtils.getGenericResponse().email);

    }

}
