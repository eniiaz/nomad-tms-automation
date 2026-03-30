package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverUtil;
import utilities.FlowController;

import java.time.Duration;
import java.util.List;

public class TrailersPage {

    public TrailersPage() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Add Trailer']")
    public WebElement addTrailerBtn;

    @FindBy(xpath = "//input[@placeholder='e.g., Great Dane']")
    public WebElement makeInput;

    @FindBy(xpath = "//input[@placeholder='1GRAA0621123456789']")
    public WebElement vinInput;

    @FindBy(xpath = "//input[@placeholder='TR001']")
    public WebElement unitNumberInput;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveBtn;

    @FindBy(xpath = "//input[@placeholder='Search trailers...']")
    public WebElement searchInput;

    @FindBy(xpath = "//label[@for='type']/following-sibling::button[@role='combobox']")
    public WebElement typeDropdown;

    // Table cells for validation
    @FindBy(xpath = "//table/tbody/tr/td[1]")
    public List<WebElement> trailerResultUnitNumbers;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> trailerResultTypes;

    @FindBy(xpath = "//table/tbody/tr/td[5]")
    public List<WebElement> trailerResultVins;

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> trailerRows;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    public WebElement deleteBtn;

    public void clickTrailerByUnitNumber(String unitNumber) {
        for (int i = 0; i < trailerResultUnitNumbers.size(); i++) {
            if (trailerResultUnitNumbers.get(i).getText().trim().equals(unitNumber)) {
                trailerResultUnitNumbers.get(i).click();
                return;
            }
        }
        throw new RuntimeException("Trailer with unit number " + unitNumber + " not found in the table");
    }

    public void confirmDeletion() {
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(5));
        WebElement confirmBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='alertdialog']//button[normalize-space()='Continue' or normalize-space()='Delete' or normalize-space()='Confirm']")));
        confirmBtn.click();
    }

    public void selectType(String type) {
        typeDropdown.click();
        WebDriverWait wait = new WebDriverWait(DriverUtil.getDriver(), Duration.ofSeconds(5));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='option'][.//span[text()='" + type + "']]")));
        option.click();
    }

    public void fillTrailerDetails(String make, String type, String vin, String unitNumber) {
        makeInput.sendKeys(make);
        FlowController.pause(600);
        selectType(type);
        vinInput.sendKeys(vin);
        unitNumberInput.sendKeys(unitNumber);
    }
}
