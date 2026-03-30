package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.GenericRequestBody;
import models.GenericResponse;
import org.junit.Assert;
import utilities.APIUtils;
import utilities.ConfigUtil;
import utilities.MyLogger;

public class TruckApiSteps {

    private String createdTruckId;
    private final Faker faker = new Faker();

    private String trucksEndpoint() {
        return ConfigUtil.getValue("apiBaseURL") + "/trucks";
    }

    @Given("user creates a truck with {string} {string} {string} {string} {string} {string} {string}")
    public void user_creates_a_truck_with(String name, String model, String unitNumber,
                                          String plateNumber, String vin, String yearStr, String state) {
        String suffix = String.valueOf(faker.random().nextInt(10000, 999999));
        if (!unitNumber.isEmpty()) unitNumber = unitNumber + "-" + suffix;
        if (!vin.isEmpty()) vin = vin + suffix;
        if (!plateNumber.isEmpty()) plateNumber = plateNumber + suffix;

        int year = 0;
        try {
            year = Integer.parseInt(yearStr);
        } catch (NumberFormatException ignored) {
        }

        GenericRequestBody requestBody = new GenericRequestBody();
        requestBody.name = name.isEmpty() ? null : name;
        requestBody.model = model.isEmpty() ? null : model;
        requestBody.unit_number = unitNumber.isEmpty() ? null : unitNumber;
        requestBody.plate_number = plateNumber.isEmpty() ? null : plateNumber;
        requestBody.vin = vin.isEmpty() ? null : vin;
        requestBody.year = year;
        requestBody.state = state.isEmpty() ? null : state;

        MyLogger.info("Creating truck: " + name + " | " + model + " | " + unitNumber);
        APIUtils.POST(requestBody, trucksEndpoint());

        if (APIUtils.getLastStatusCode() >= 200 && APIUtils.getLastStatusCode() < 300) {
            GenericResponse response = APIUtils.getGenericResponse();
            createdTruckId = response.id;
            MyLogger.info("Truck created with ID: " + createdTruckId);
        } else {
            MyLogger.warn("Truck creation returned status: " + APIUtils.getLastStatusCode());
        }
    }

    @Then("user verifies the truck is created successfully with name {string}")
    public void user_verifies_the_truck_is_created_successfully_with_name(String expectedName) {
        Assert.assertNotNull("Truck ID should not be null after creation", createdTruckId);
        Assert.assertFalse("Truck ID should not be empty", createdTruckId.isEmpty());

        GenericResponse response = APIUtils.getGenericResponse();
        Assert.assertEquals("Truck name mismatch", expectedName, response.name);
        MyLogger.info("Verified truck created: " + response.name + " with ID: " + createdTruckId);
    }

    @And("user verifies the created truck appears in the trucks list")
    public void user_verifies_the_created_truck_appears_in_the_trucks_list() {
        APIUtils.GET(trucksEndpoint());
        GenericResponse[] trucks = APIUtils.getGenericResponseList();

        boolean found = false;
        for (GenericResponse truck : trucks) {
            if (createdTruckId.equals(truck.id)) {
                found = true;
                MyLogger.info("Found created truck in list: " + truck.name + " (ID: " + truck.id + ")");
                break;
            }
        }
        Assert.assertTrue("Created truck with ID " + createdTruckId + " was not found in the trucks list", found);
    }

    @And("user deletes the created truck")
    public void user_deletes_the_created_truck() {
        Assert.assertNotNull("No truck ID available for deletion", createdTruckId);
        String deleteUrl = trucksEndpoint() + "/" + createdTruckId;
        MyLogger.info("Deleting truck at: " + deleteUrl);
        APIUtils.DELETE(deleteUrl);
    }

    @Then("user verifies the response status code is {int}")
    public void user_verifies_the_response_status_code_is(int expectedStatus) {
        Assert.assertEquals("Status code mismatch", expectedStatus, APIUtils.getLastStatusCode());
        MyLogger.info("Verified status code: " + APIUtils.getLastStatusCode());
    }

    @Then("user verifies the response status code is not {int}")
    public void user_verifies_the_response_status_code_is_not(int unexpectedStatus) {
        Assert.assertNotEquals("Status code should not be " + unexpectedStatus,
                unexpectedStatus, APIUtils.getLastStatusCode());
        MyLogger.info("Verified status code " + APIUtils.getLastStatusCode() + " is not " + unexpectedStatus);
    }

    @And("user verifies the deleted truck no longer appears in the trucks list")
    public void user_verifies_the_deleted_truck_no_longer_appears_in_the_trucks_list() {
        APIUtils.GET(trucksEndpoint());
        GenericResponse[] trucks = APIUtils.getGenericResponseList();

        for (GenericResponse truck : trucks) {
            Assert.assertNotEquals("Deleted truck with ID " + createdTruckId + " should not be in the list",
                    createdTruckId, truck.id);
        }
        MyLogger.info("Verified deleted truck " + createdTruckId + " is no longer in the trucks list");
    }

    @Given("user attempts to delete a truck with ID {string}")
    public void user_attempts_to_delete_a_truck_with_id(String truckId) {
        String deleteUrl = trucksEndpoint() + "/" + truckId;
        MyLogger.info("Attempting to delete truck with invalid ID at: " + deleteUrl);
        APIUtils.DELETE(deleteUrl);
    }

    @Then("user verifies the truck creation failed")
    public void user_verifies_the_truck_creation_failed() {
        int status = APIUtils.getLastStatusCode();
        Assert.assertTrue("Expected non-success status code but got " + status,
                status < 200 || status >= 300);
        MyLogger.info("Verified truck creation failed with status: " + status);
    }
}
