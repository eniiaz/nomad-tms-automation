package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtil;

public class SideBarPage {

    public SideBarPage(){
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Customers']")
    public WebElement customersMenu;

    @FindBy(xpath = "//button[.='Business']")
    public WebElement businessMenu;

    @FindBy(xpath = "//button[.='Fleet Management']")
    public WebElement fleetManagementMenu;

    @FindBy(xpath = "//button[.='Trucks']")
    public WebElement trucksMenu;

    @FindBy(xpath = "//button[.='HR']")
    public WebElement hrMenu;

    @FindBy(xpath = "//button[.='Drivers']")
    public WebElement driversMenu;

    @FindBy(xpath = "//button[.='Accounting']")
    public WebElement accountingMenu;

    @FindBy(xpath = "//button[.='Invoices']")
    public WebElement invoicesMenu;



}
