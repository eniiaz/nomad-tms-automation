package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SideBarPage;
import pages.TrailersPage;
import utilities.DriverUtil;
import utilities.MyLogger;

import java.time.Duration;

public class TrailersSteps {

    @Then("user navigates to Trailers page")
    public void user_navigates_to_trailers_page() {
        SideBarPage sideBarPage = new SideBarPage();
        sideBarPage.navigateMenu("trailers");
        MyLogger.info("Navigated to Trailers page");
    }

    @And("user clicks on Add Trailer button")
    public void user_clicks_on_add_trailer_button() {
        TrailersPage trailersPage = new TrailersPage();
        trailersPage.addTrailerBtn.click();
        MyLogger.info("Clicked on Add Trailer button");
    }

    @Then("user fills out trailer with {string} {string} {string} {string}")
    public void user_fills_out_trailer_with(String make, String type, String vin, String unitNumber) {
        TrailersPage trailersPage = new TrailersPage();
        trailersPage.fillTrailerDetails(make, type, vin, unitNumber);
        MyLogger.info("Filled trailer details - Make: " + make + ", Type: " + type
                + ", VIN: " + vin + ", Unit: " + unitNumber);
    }

    @And("user saves the trailer")
    public void user_saves_the_trailer() throws InterruptedException {
        TrailersPage trailersPage = new TrailersPage();
        trailersPage.saveBtn.click();

        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("/trailers"));
        Thread.sleep(2000);
        MyLogger.info("Saved the trailer and redirected to trailers list");
    }

    @Then("user validates the trailer is displayed with {string} {string} {string}")
    public void user_validates_the_trailer_is_displayed_with(String type, String vin, String unitNumber) throws InterruptedException {
        TrailersPage trailersPage = new TrailersPage();
        trailersPage.searchInput.sendKeys(unitNumber + Keys.ENTER);
        Thread.sleep(2000);

        boolean found = false;
        for (int i = 0; i < trailersPage.trailerResultUnitNumbers.size(); i++) {
            String actualUnit = trailersPage.trailerResultUnitNumbers.get(i).getText().trim();
            if (actualUnit.equals(unitNumber)) {
                String actualType = trailersPage.trailerResultTypes.get(i).getText().trim();
                String actualVin = trailersPage.trailerResultVins.get(i).getText().trim();
                Assert.assertEquals("Type mismatch for trailer " + unitNumber, type, actualType);
                Assert.assertEquals("VIN mismatch for trailer " + unitNumber, vin, actualVin);
                found = true;
                MyLogger.info("Trailer validated - Unit: " + actualUnit
                        + ", Type: " + actualType + ", VIN: " + actualVin);
                break;
            }
        }
        Assert.assertTrue("Created trailer with unit number " + unitNumber + " was not found in the list", found);
    }
}
