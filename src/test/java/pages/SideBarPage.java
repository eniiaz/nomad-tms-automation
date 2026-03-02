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

    @FindBy(xpath = "//button[.='Trailers']")
    public WebElement trailersMenu;

    @FindBy(xpath = "//button[.='Accounting']")
    public WebElement accountingMenu;

    @FindBy(xpath = "//button[.='Invoices']")
    public WebElement invoicesMenu;

    @FindBy(xpath = "//button[.='System']")
    public WebElement systemMenu;

    @FindBy(xpath = "//button[.='Settings']")
    public WebElement settingsMenu;


    public void navigateMenu(String menuOption){

        if (menuOption.trim().equalsIgnoreCase("trucks")){
            fleetManagementMenu.click();
            trucksMenu.click();
        }else if(menuOption.trim().equalsIgnoreCase("trailers")){
            fleetManagementMenu.click();
            trailersMenu.click();
        }else if(menuOption.trim().equalsIgnoreCase("settings")){
            systemMenu.click();
            settingsMenu.click();
        }else if(menuOption.trim().equalsIgnoreCase("customers")){
            businessMenu.click();
            customersMenu.click();
        }

    }


}
