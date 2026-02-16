package reviewSession;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LandingPage;
import utilities.DriverUtil;

public class Accounting {


    // JUnit: Framework for unit testing

    @Test
    public void createInvoice(){

        DriverUtil.getDriver().get("https://nomadtms.up.railway.app");

        LandingPage landingPage = new LandingPage();
        landingPage.login("sdet@gmail.com", "Tester");

        WebElement button = DriverUtil.getDriver().findElement(By.xpath("//button[.='Create Batch']"));

        // Hardcoded:
        // Violation of the Framework Rules. Rule in our framework is to follow Page Objecdt Model Design pattern.

    }


    @Test
    public void deleteInvoice(){

    }

    @Test
    public void editInvoice(){

    }


}
