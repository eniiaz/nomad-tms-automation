package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.GenericRequestBody;
import utilities.APIUtils;

public class CompaniesSteps {

    @Given("user makes an api call to create a company with {string} {string} {string} {string} at endpoint {string}")
    public void user_makes_an_api_call_to_create_a_company_with_at_endpoint(String companyName, String email, String taxId, String dot, String endpoint) {
        Faker faker = new Faker();

        String emailStart = email.substring(0, email.indexOf("@"));
        String emailLast = email.substring(email.indexOf("@"));
        emailStart = emailStart + faker.random().nextInt(1000, 100000);
        email = emailStart + emailLast;

        taxId = faker.random().nextInt(10000000, 999999999) + "";
        dot = faker.random().nextInt(10000000, 999999999) + "";

        System.out.println(email);
        System.out.println(taxId);
        System.out.println(dot);

        GenericRequestBody requestBody = new GenericRequestBody();
        requestBody.name = companyName;
        requestBody.email = email;
        requestBody.tax_id = taxId;
        requestBody.dot_number = dot;
        APIUtils.POST(requestBody, endpoint);
    }

    @Then("user verifies that company is created successfully for the name {string}")
    public void user_verifies_that_company_is_created_successfully_for_the_name(String companyName) {
        System.out.println(APIUtils.getGenericResponse().name);
    }
}
