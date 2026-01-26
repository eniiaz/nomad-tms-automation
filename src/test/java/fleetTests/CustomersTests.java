package fleetTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class CustomersTests {

    WebDriver driver;

    @BeforeEach
    public void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        // Whenever you can't find an element, please don't throw error/exception. Instead wait up to 12 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        System.out.println("Opening the App");
        driver.get("https://nomadtms.up.railway.app/");
    }

    @AfterEach
    public void cleanUp(){
        driver.quit();
    }

    @Test
    public void customerMcNumberVerifications() throws InterruptedException {
        login();
        WebElement businessMenu = driver.findElement(By.xpath("//button[.='Business']"));
        businessMenu.click();
        WebElement customersMenu = driver.findElement(By.xpath("//button[.='Customers']"));
        customersMenu.click();

        List<WebElement> customersMcNumbers = driver.findElements(By.xpath("//main//table/tbody/tr/td[3]"));

        System.out.println(customersMcNumbers.size());

        for (int i = 0; i < customersMcNumbers.size(); i++){
            String eachMc = customersMcNumbers.get(i).getText();
            System.out.println(i + "-MC: " + customersMcNumbers.get(i).getText());
            Assertions.assertFalse(eachMc.isEmpty() || eachMc.trim().equals("N/A") || eachMc.trim().equals("NULL"));
        }

    }


    public void login() throws InterruptedException {
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();
        WebElement emailInputBox = driver.findElement(By.id("signin-email"));
        WebElement passwordInputBox = driver.findElement(By.id("signin-password"));
        WebElement signInButton = driver.findElement(By.xpath("//form//button[text()='Sign In']"));

        Thread.sleep(1000);
        emailInputBox.sendKeys("sdet@gmail.com");
//        emailInputBox.clear();
        Thread.sleep(1000);
        passwordInputBox.sendKeys("Tester");
        Thread.sleep(1000);
        signInButton.click();
        Thread.sleep(1500);

        System.out.println("URL: " + driver.getCurrentUrl());

        if(driver.getCurrentUrl().equals("https://nomadtms.up.railway.app/dashboard")){
            System.out.println("Login Test passed");
        }else{
            System.out.println("Login Test Failed");
        }
    }

}
