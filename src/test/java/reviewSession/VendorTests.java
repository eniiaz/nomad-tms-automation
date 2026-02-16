package reviewSession;

import org.junit.jupiter.api.Test;
import pages.LandingPage;
import utilities.DriverUtil;

public class VendorTests {


    @Test
    public void vendorCreation(){

        DriverUtil.getDriver().get("https://nomadtms.up.railway.app/");
        LandingPage landingPage = new LandingPage();

        landingPage.login("api@gmail.com", "Tester");


    }


}
