package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsBusPage {
    private WebDriver driver;

    private By accommodationListLocator = By.xpath("//h1[@class='search-title']");

    private By buttonMinsk = By.xpath("//a[text()='Минск' and @class='ipc_city '] ");

    private By buttonSwap = By.xpath("//a[@class='swap'] ");

    private By datePicker = By.xpath("//img[@class='ui-datepicker-trigger'] ");

    private By currentDate = By.xpath("//a[@class='ui-state-default'] ");

    private By buttonSearch = By.xpath("//div[@class='form-group__btn-search'] ");

    private By errortext = By.xpath("//p[@class='popup-info__text'] ");


    public TicketsBusPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorText() {
        return findElementByLocator(errortext).getText();
    }

    public TicketsBusPage clickButtonMinsk() {
        findElementByLocatorAndClick(buttonMinsk);
        return this;
    }

    public TicketsBusPage clickButtonSwap() {
        findElementByLocatorAndClick(buttonSwap);
        return this;
    }

    public TicketsBusPage openDatePicker() {
        findElementByLocatorAndClick(datePicker);
        return this;
    }

    public TicketsBusPage selectDate() {
        findElementByLocatorAndClick(currentDate);
        return this;
    }

    public TicketsBusPage clickButtonSearch() {
        findElementByLocatorAndClick(buttonSearch);
        return this;
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }



    public WebElement findElementByLocatorAndClick(By locator) {
            WebElement element = findElementByLocator(locator);
            element.click();
            return element;
    }
}
