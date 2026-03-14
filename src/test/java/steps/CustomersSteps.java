package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.CustomersPage;
import pages.LandingPage;
import pages.SideBarPage;
import utilities.ConfigUtil;
import utilities.DriverUtil;
import utilities.MyLogger;

public class CustomersSteps {

    @Given("user launches the application")
    public void user_launches_the_application() {
        DriverUtil.getDriver().get(ConfigUtil.getValue("appURL"));
        // Logging saying "user is opening the website"
        MyLogger.info("User lauched the web application");
    }

    @Then("user logs in to the application using admin credentials")
    public void user_logs_in_to_the_application_using_admin_credentials() {
        LandingPage landingPage = new LandingPage();
        landingPage.login(ConfigUtil.getValue("username"), ConfigUtil.getValue("password"));
        // Log : "user is logging in using whatever username and whatever password"
        MyLogger.info("user is logging in using " + ConfigUtil.getValue("username") + " username");
    }

    @Then("user navigates to Customers page")
    public void user_navigates_to_customers_page() {
        SideBarPage sideBarPage = new SideBarPage();
        sideBarPage.navigateMenu("customers");
    }

    @Then("user searches for a keyword {string}")
    public void user_searches_for_a_keyword(String keyword) throws InterruptedException {
        // write a code following the rules of the framework that satisfies this particular step
        // Page object Model, DriverUtil utility, Config utility to use configuations properties
        CustomersPage customersPage = new CustomersPage();
        customersPage.searchInputBox.sendKeys(keyword + Keys.ENTER);
        Thread.sleep(1500);
    }

    @Then("user validates the result to have keyword {string}")
    public void user_validates_the_result_to_have_keyword(String keyword) {
        CustomersPage customersPage = new CustomersPage();

        for (WebElement customer: customersPage.customerResultNames){
            String customerName = customer.getText().replaceAll("Common", "").trim().toLowerCase();
            Assert.assertTrue("Customer search is failing for keyword: " + keyword + " for customer name: " + customerName, customerName.contains(keyword));
        }
    }

}
