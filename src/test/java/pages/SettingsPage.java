package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtil;

import java.util.List;

public class SettingsPage {

    public SettingsPage(){
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Add Company']")
    public WebElement addCompanyBtn;

    @FindBy(xpath = "//label[.='Company Name *']/../input")
    public WebElement companyNameInput;

    @FindBy(xpath = "(//span[.='MC Number:']/../../..)//h3")
    public List<WebElement> companyNamesList;

    public void createCompany(String companyName, String dotNumber, String mcNumber, String email, String phone, String taxId){
        addCompanyBtn.click();
        companyNameInput.sendKeys(companyName);

    }


}
