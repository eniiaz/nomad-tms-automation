package fleetTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import utilities.DriverUtil;

import java.util.List;

public class ActionsPractice {

    @Test
    public void elements() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

//        driver.get("https://the-internet.herokuapp.com/hovers");
//
//        List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']/img"));
//
//        Actions actions = new Actions(driver);
//
//        Thread.sleep(3000);
//
//        // For EAch method
//        for(WebElement image: images){
//            actions.moveToElement(image).perform();
//            Thread.sleep(3000);
//        }
//
//        driver.navigate().to("https://the-internet.herokuapp.com/drag_and_drop");
//        Thread.sleep(3000);
//        WebElement boxA = driver.findElement(By.id("column-a"));
//        WebElement boxB = driver.findElement(By.id("column-b"));
//
//        actions.dragAndDrop(boxA, boxB).perform();
//
//        driver.navigate().to("https://the-internet.herokuapp.com/upload");
//
//        WebElement uploadFile = driver.findElement(By.id("file-upload"));
//        String filepath = "/Users/esenniiazov/Downloads/test.txt";
//
//        uploadFile.sendKeys(filepath);
//        Thread.sleep(2000);
//
//        driver.findElement(By.id("file-submit")).click();

        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@role='alert']//button")).click();

        WebElement contentIframe = driver.findElement(By.id("mce_0_ifr"));

        driver.switchTo().frame(contentIframe);

        WebElement paragpath = driver.findElement(By.xpath("//p"));
        System.out.println(paragpath.getText());


    }

}
