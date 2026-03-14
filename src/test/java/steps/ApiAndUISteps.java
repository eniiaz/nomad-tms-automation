package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SettingsPage;
import pages.SideBarPage;
import utilities.APIUtils;

public class ApiAndUISteps {

    @Given("user makes an API call to get companies list at {string}")
    public void user_makes_an_api_call_to_get_companies_list_at(String endpoint) {

        APIUtils.GET(endpoint);

    }

    @Then("user navigates to settings page")
    public void user_navigates_to_settings_page() {
        SideBarPage sideBarPage = new SideBarPage();
        sideBarPage.navigateMenu("settings");
    }

    @Then("user validates all the companies with companies list from API request")
    public void user_validates_all_the_companies_with_companies_list_from_api_request() throws InterruptedException {

        Thread.sleep(2000);
        // I should here have the list from API request
        // Also I should get the list of companies from UI
        System.out.println("Companies size on API: " + APIUtils.getGenericResponseList().length);

        SettingsPage settingsPage = new SettingsPage();
        System.out.println("Companies size on UI: " + settingsPage.companyNamesList.size());

        Assert.assertEquals("Company sizes are failing", APIUtils.getGenericResponseList().length, settingsPage.companyNamesList.size());

    }

}
