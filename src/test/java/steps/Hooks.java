package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.DriverUtil;
import utilities.MyLogger;

public class Hooks {

    @Before
    public void setup(){
        MyLogger.info("New Scenario is started");
    }

    @After
    public void cleanUp(Scenario scenario){

        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot)DriverUtil.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            MyLogger.error(scenario.getName() + " failed please check reports for screenshot");
        }
        DriverUtil.quitDriver();
        MyLogger.info(scenario.getName() + " is completed");
    }
}
