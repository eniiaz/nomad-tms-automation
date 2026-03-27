package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtil;

import java.util.List;

public class CustomersPage {

    public CustomersPage(){
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//input")
    public WebElement searchInputBox;

    @FindBy(xpath = "//table/tbody//tr/td[1]/div/div[1]")
    public List<WebElement> customerResultNames;

    


}
