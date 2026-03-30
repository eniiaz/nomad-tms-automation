package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.GenericRequestBody;
import models.GenericResponse;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TrailersPage;
import utilities.APIUtils;
import utilities.ConfigUtil;
import utilities.DriverUtil;
import utilities.MyLogger;

import java.time.Duration;

public class TrailerApiUISteps {

    private final Faker faker = new Faker();

    @Given("user creates a trailer via API with {string} {string} {string} {string} {string}")
    public void user_creates_a_trailer_via_api_with(String make, String type, String vin,
                                                     String unitNumber, String yearStr) {
        String suffix = String.valueOf(faker.random().nextInt(10000, 999999));
        vin = vin + suffix;

        GenericRequestBody body = new GenericRequestBody();
        body.make = make;
        body.type = type;
        body.vin = vin;
        body.unit_number = unitNumber;
        body.year = Integer.parseInt(yearStr);
        body.status = "Available";
        body.fleet_status = "Available";
        body.ownership = "Lease";

        String endpoint = ConfigUtil.getValue("apiBaseURL") + "/trailers";
        MyLogger.info("Creating trailer via API: " + make + " | " + type + " | Unit: " + unitNumber);
        APIUtils.POST(body, endpoint);

        Assert.assertTrue("Trailer creation failed with status: " + APIUtils.getLastStatusCode(),
                APIUtils.getLastStatusCode() >= 200 && APIUtils.getLastStatusCode() < 300);

        GenericResponse response = APIUtils.getGenericResponse();
        MyLogger.info("Trailer created via API with ID: " + response.id + ", Unit: " + response.unit_number);
    }

    @And("user opens the trailer with unit number {string}")
    public void user_opens_the_trailer_with_unit_number(String unitNumber) {
        TrailersPage trailersPage = new TrailersPage();
        trailersPage.clickTrailerByUnitNumber(unitNumber);

        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/trailers/"));
        MyLogger.info("Opened trailer edit page for unit: " + unitNumber);
    }

    @And("user deletes the trailer from the edit page")
    public void user_deletes_the_trailer_from_the_edit_page() {
        TrailersPage trailersPage = new TrailersPage();

        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(trailersPage.deleteBtn));
        trailersPage.deleteBtn.click();
        MyLogger.info("Clicked delete button on trailer edit page");

        trailersPage.confirmDeletion();
        MyLogger.info("Confirmed trailer deletion");

        wait.until(ExpectedConditions.urlContains("/trailers"));
        MyLogger.info("Redirected back to trailers list after deletion");
    }

    @Then("user verifies the trailer with unit number {string} is no longer displayed")
    public void user_verifies_the_trailer_with_unit_number_is_no_longer_displayed(String unitNumber) throws InterruptedException {
        TrailersPage trailersPage = new TrailersPage();
        trailersPage.searchInput.sendKeys(unitNumber + Keys.ENTER);
        Thread.sleep(2000);

        for (int i = 0; i < trailersPage.trailerResultUnitNumbers.size(); i++) {
            String actualUnit = trailersPage.trailerResultUnitNumbers.get(i).getText().trim();
            Assert.assertNotEquals("Deleted trailer with unit " + unitNumber + " should not be in the list",
                    unitNumber, actualUnit);
        }
        MyLogger.info("Verified trailer with unit " + unitNumber + " is no longer displayed on UI");
    }
}
