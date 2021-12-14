package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsBusPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By buttonMinsk = By.xpath("//a[text()='Минск' and @class='ipc_city '] ");

    private By buttonVitebsk = By.xpath("//a[text()='Витебск' and @class='ipc_city seatch_helper_to'] ");

    private By buttonSwap = By.xpath("//a[@class='swap'] ");

    private By datePicker = By.xpath("//img[@class='ui-datepicker-trigger'] ");

    private By currentDate = By.xpath("//a[@class='ui-state-default'] ");

    private By buttonSearch = By.xpath("//div[@class='form-group__btn-search'] ");

    private By errortext = By.xpath("//p[@class='popup-info__text'] ");

    private By errorArrivalplacetext = By.xpath("//samp[@class='error'] ");


    public TicketsBusPage(WebDriver driver) {
        super(driver);
    }

    public String getErrorText() {
        LOGGER.log(Level.INFO, "Getting error text");
        return findElementByLocator(errortext).getText();
    }

    public String getErrorArrivalPlaceText() {
        LOGGER.log(Level.INFO, "Getting error text");
        return findElementByLocator(errorArrivalplacetext).getText();
    }

    public TicketsBusPage clickButtonMinsk() {
        LOGGER.log(Level.INFO, "Button Minsk was clicked");
        findElementByLocatorAndClick(buttonMinsk);
        return this;
    }

    public TicketsBusPage clickButtonVitebsk() {
        LOGGER.log(Level.INFO, "Button Vitebsk was clicked");
        findElementByLocatorAndClick(buttonVitebsk);
        return this;
    }

    public TicketsBusPage clickButtonSwap() {
        LOGGER.log(Level.INFO, "Button swap was clicked");
        findElementByLocatorAndClick(buttonSwap);
        return this;
    }

    public TicketsBusPage openDatePicker() {
        LOGGER.log(Level.INFO, "Datepicker was opened");
        findElementByLocatorAndClick(datePicker);
        return this;
    }

    public TicketsBusPage selectDate() {
        LOGGER.log(Level.INFO, "The date has been selected");
        findElementByLocatorAndClick(currentDate);
        return this;
    }

    public TicketsBusResultsPage clickButtonSearch() {
        LOGGER.log(Level.INFO, "Button search was clicked");
        findElementByLocatorAndClick(buttonSearch);
        return new TicketsBusResultsPage(driver);
    }

    @Override
    protected WebElement defaultFindElementByLocator(By locator) {
        return super.defaultFindElementByLocator(locator);
    }

    @Override
    protected WebElement findElementByLocator(By locator) {
        return super.findElementByLocator(locator);
    }

    @Override
    protected WebElement findElementByLocatorAndClick(By locator) {
        return super.findElementByLocatorAndClick(locator);
    }

    @Override
    protected String findElementByLocatorAndGetText(By locator) {
        return super.findElementByLocatorAndGetText(locator);
    }
}
