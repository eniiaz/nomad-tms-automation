package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtil;

public class DriversPage {

    public DriversPage(){
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Add Driver']")
    public WebElement addDriverButton;


    public void addDriver(){

    }
}
