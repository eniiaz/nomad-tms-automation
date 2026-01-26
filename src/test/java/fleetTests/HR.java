package fleetTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.DriversPage;
import pages.LandingPage;
import pages.SideBarPage;
import utilities.DriverUtil;

import java.security.Key;

public class HR {

    @Test
    public void createDriverTest() throws InterruptedException {
        DriverUtil.getDriver().get("https://nomadtms.up.railway.app/");

        LandingPage landingPage = new LandingPage();
        landingPage.login("sdet@gmail.com", "Tester");

        Thread.sleep(2000);

        SideBarPage sideBarPage = new SideBarPage();

        sideBarPage.driversMenu.click();
        Thread.sleep(2000);
        DriversPage driversPage = new DriversPage();

        driversPage.addDriverButton.click();
        driversPage.addDriver();
        DriverUtil.quitDriver();
    }

}
