package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LandingPage;
import pages.SideBarPage;
import utilities.ConfigUtil;
import utilities.DriverUtil;

public class CustomersSteps {

    @Given("user launches the application")
    public void user_launches_the_application() {
        DriverUtil.getDriver().get(ConfigUtil.getValue("appURL"));
    }

    @Then("user logs in to the application using admin credentials")
    public void user_logs_in_to_the_application_using_admin_credentials() {
        LandingPage landingPage = new LandingPage();
        landingPage.login(ConfigUtil.getValue("username"), ConfigUtil.getValue("password"));
    }

    @Then("user navigates to Customers page")
    public void user_navigates_to_customers_page() {
        SideBarPage sideBarPage = new SideBarPage();
        sideBarPage.navigateMenu("customers");
    }

    @Then("user searches for a keyword {string}")
    public void user_searches_for_a_keyword(String keyword) {
        System.out.println("User is searching for customer keyword: " + keyword);
        Assert.fail("failing the test on purpose");
    }

    @Then("user validates the result to have keyword {string}")
    public void user_validates_the_result_to_have_keyword(String keyword) {
        System.out.println("User validated results with: " + keyword);
    }

}
