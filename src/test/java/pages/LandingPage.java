package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.DriverUtil;

public class LandingPage {

    public LandingPage(){
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginBtn;

    @FindBy(id = "signin-email")
    public WebElement signInEmailInputBox;

    @FindBy(id = "signin-password")
    public WebElement signInPasswordInputBox;

    @FindBy(xpath = "//form//button[text()='Sign In']")
    public WebElement signInButton;


    public void login(String email, String password){
        loginBtn.click();
        signInEmailInputBox.sendKeys(email);
        signInPasswordInputBox.sendKeys(password);
        signInButton.click();
    }





}
