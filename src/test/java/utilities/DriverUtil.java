package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class DriverUtil {

    // 1. I want this utility to create an object from ChromeDriver and share the same object reference everytime it is called

    // 2. I want this utility to kill/quit the driver object when user wants
    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            // Whenever you can't find an element, please don't throw error/exception. Instead wait up to 12 seconds
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

}
