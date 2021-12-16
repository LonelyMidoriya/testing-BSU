package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TicketsBusPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By buttonMinsk = By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[1]/div[1]/div[2]/a[1] ");

    private By buttonVitebsk = By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[1]/div[2]/div[2]/a[2] ");

    private By buttonSwap = By.xpath("//a[@class='swap'] ");

    private By datePicker = By.xpath("//img[@class='ui-datepicker-trigger'] ");

    private By currentDate = By.xpath("//a[@class='ui-state-default'] ");

    private By buttonSearch = By.xpath("//div[@class='form-group__btn-search'] ");

    private By errortext = By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/p");

    private By errorArrivalPlaceText = By.xpath("/html/body/div[1]/div[1]/div/div/div/form/div[1]/div[2]/div[1]/samp[2]");


    public TicketsBusPage(WebDriver driver) {
        super(driver);
    }

    public boolean isErrorTextVisiable() {
        LOGGER.log(Level.INFO, " Checking error");
        return findElementByLocator(errortext).isDisplayed();
    }

    public boolean isErrorArrivalPlaceTextVisiable() {
        LOGGER.log(Level.INFO, " Checking error");
        return findElementByLocator(errorArrivalPlaceText).isDisplayed();
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
