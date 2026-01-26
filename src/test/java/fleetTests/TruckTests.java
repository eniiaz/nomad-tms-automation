package fleetTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class TruckTests {

    // How to run some piece of code that runs for each test separetly.
    ChromeDriver driver;

    @BeforeEach
    public void openBrowser(){
        driver = new ChromeDriver();
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
    public void truckCreation() throws InterruptedException {
        login();
        // rest of the automation code to craetion trucks
        WebElement fleetMenu = driver.findElement(By.xpath("//button[.='Fleet Management']"));
        fleetMenu.click();
        driver.findElement(By.xpath("//button[.='Trucks']")).click();
        WebElement newTruckBtn = driver.findElement(By.xpath("//button[.='Add Truck']"));
        newTruckBtn.click();

        WebElement truckName = driver.findElement(By.id("name"));
        WebElement unitNumber = driver.findElement(By.id("unit_number"));

        String truckNameData = "MyVolvo";
        String unitNumberData = "GGt2";
        truckName.sendKeys(truckNameData);
        unitNumber.sendKeys(unitNumberData);
        driver.findElement(By.xpath("//button[.='Save']")).click();
        Thread.sleep(4000);
        String readyXpath = "//td[.='" + unitNumberData + "']";
        WebElement createdUnitNumber = driver.findElement(By.xpath(readyXpath));
        Assertions.assertTrue(createdUnitNumber.isDisplayed());

        Select typeDropdown = new Select(createdUnitNumber);
        typeDropdown.selectByVisibleText("T872");
   }

    @Test
    public void truckDeletion() throws InterruptedException {
        login();
        System.out.println("going to the app");
        System.out.println("going to the trucks");
        System.out.println("Delete etc\n");
        String result = "SDET";
        Assertions.assertEquals("James", result);
    }

    @Test
    public void truckDriverAssignment() throws InterruptedException {
        login();
        // do the assignment
        System.out.println("going to the app");
        System.out.println("going to the trucks");
        System.out.println("Assign driver etc\n");
        Assertions.fail("On purpose");
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
