package smokeTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.LandingPage;
import pages.SettingsPage;
import pages.SideBarPage;
import utilities.ConfigUtil;
import utilities.DriverUtil;

public class NomadSmoke {

    @Test
    public void companyCreationUI() throws InterruptedException {

        DriverUtil.getDriver().get(ConfigUtil.getValue("appURL"));
        LandingPage landingPage = new LandingPage();
        landingPage.login(ConfigUtil.getValue("username"), ConfigUtil.getValue("password"));

        Thread.sleep(1500);
        SideBarPage sideBarPage = new SideBarPage();
        sideBarPage.navigateMenu("settings");

        SettingsPage settingsPage = new SettingsPage();
        settingsPage.createCompany("GG companyh", "2984298", "294789247", "eh@gmail.com", "24974924", "928429");

    }

}
