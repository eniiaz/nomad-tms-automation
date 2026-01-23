package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NomadTMSLogin {


    public static void main(String[] args) throws InterruptedException {

        // Goal is to login to the app
        WebDriver driver = new ChromeDriver();

        driver.get("https://nomadtms.up.railway.app/");
        System.out.println("URL: " + driver.getCurrentUrl());

        driver.manage().window().maximize();

        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));

        System.out.println(loginButton.getText());

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
        Thread.sleep(1000);
        WebElement systemMenu = driver.findElement(By.xpath("//button[.='System']"));
        systemMenu.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[.='Settings']")).click();
        Thread.sleep(1000);

        WebElement newCompanyBtn = driver.findElement(By.xpath("//button[.='Add Company']"));
        newCompanyBtn.click();
        Thread.sleep(1000);

        WebElement newCompanyNameInput = driver.findElement(By.id("newCompanyName"));
        WebElement mcNumberInput = driver.findElement(By.id("newMcNumber"));
        WebElement newDotNumberInput = driver.findElement(By.id("newDotNumber"));
        WebElement newTaxidInput = driver.findElement(By.id("newTaxId"));
        WebElement emailInput = driver.findElement(By.id("newEmail"));
        WebElement newPhoneInput = driver.findElement(By.id("newPhone"));
        WebElement newAddressInput = driver.findElement(By.id("newAddress"));
        WebElement newCityInput = driver.findElement(By.id("newCity"));
        WebElement newStateInput = driver.findElement(By.id("newState"));
        WebElement newZipInput = driver.findElement(By.id("newZip"));

        WebElement createNewCompanyButton = driver.findElement(By.xpath("//button[.='Create Company']"));

        newCompanyNameInput.sendKeys("Automated Load Carriers");
        mcNumberInput.sendKeys("MC-23928942");
        newDotNumberInput.sendKeys("D-2389242");
        newTaxidInput.sendKeys("T02084242");
        emailInput.sendKeys("auto@gmail.com");
        newPhoneInput.sendKeys("29482098478");
        newAddressInput.sendKeys("123 main street");
        newCityInput.sendKeys("Chicago");
        newStateInput.sendKeys("IL");
        newZipInput.sendKeys("65045");

        Thread.sleep(1000);

        createNewCompanyButton.click();
        Thread.sleep(1000);
        WebElement successMessage = driver.findElement(By.xpath("//div[.='Company created successfully!']"));

        if (successMessage.isDisplayed()){
            System.out.println("Company creation TEST PASSED");
        }else{
            System.out.println("Company creation TEST FAILED");
        }


        //driver.quit();
    }

}
