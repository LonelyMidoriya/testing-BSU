package page;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
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
        return findElementByLocatorException(errortext).getText();
    }

    public TicketsBusPage clickButtonMinsk() {
        findElementByLocatorAndClickException(buttonMinsk);
        return this;
    }

    public TicketsBusPage clickButtonSwap() {
        findElementByLocatorAndClickException(buttonSwap);
        return this;
    }

    public TicketsBusPage openDatePicker() {
        findElementByLocatorAndClickException(datePicker);
        return this;
    }

    public TicketsBusPage selectDate() {
        findElementByLocatorAndClickException(currentDate);
        return this;
    }

    public TicketsBusPage clickButtonSearch() {
        findElementByLocatorAndClickException(buttonSearch);
        return this;
    }

    private WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 60)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }

    private WebElement findElementByLocatorException(By locator) {
        try {
            return findElementByLocator(locator);
        } catch (StaleElementReferenceException e) {
            return findElementByLocator(locator);
        }
    }

    public WebElement findElementByLocatorAndClickException(By locator) {
        try {
            WebElement element = findElementByLocator(locator);

            element.click();
            return element;
        } catch (StaleElementReferenceException e) {
            WebElement element = findElementByLocator(locator);
            element.click();
            return element;
        }
    }
}
