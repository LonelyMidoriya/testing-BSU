package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsAviaPage extends AbstractPage{
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By fromField = By.xpath("//div[text()='Откуда ' and @class='t-select__placeholder'] ");

    private By toField = By.xpath("//div[text()='Куда ' and @class='t-select__placeholder'] ");

    private By placeFrom = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[1]/menu/div/li/div/input");

    private By placeFromText = By.xpath("//input[@class='t-autocomplete-v2__input theme-default'] ");

    private By placeToText = By.xpath("//input[@class='t-autocomplete-v2__input theme-default'] ");

    private By denyButton = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[1]/menu/div/li/div/button");

    private By placeTo = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[2]/menu/div/li/div/input ");

    private By datePicker = By.xpath("//button[@class='t-date-picker__activator ltr bg-1 theme-default multiple departure'] ");

    private By currentDate = By.xpath("//div[@class='t-calendar__month__week__day ltr theme-default'] ");

    private By oneWay = By.xpath("//button[@class='t-btn theme-default _bordered'] ");

    private By buttonSwap = By.xpath("//button[@class='double-autocomplete__swap theme-default ltr bg-1'] ");

    private By buttonSearch = By.xpath("//button[@class='t-btn _size-xl theme-default main-search-inner-form__submit'] ");

    private By passengerField = By.xpath("//button[@class='t-search-form-activator pl-1 pr-1 rel cursor-pointer theme-default search-form-avia-passengers-select-v2-activator'] ");

    private By passengerError = By.xpath("//div[text()='Максимум 9 пассажиров' and @class='t-counter__error ltr'] ");

    private By buttonAddPassenger = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[2]/div[2]/div/menu/div/div/div[1]/div/div[1]/div/div[2]/button[2]");

    private By topSpaceBetween = By.xpath("//h1[@class='app-header-title'] ");

    private By divPlaceTo = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[2]/menu/div/ul/li[1]/div/div[1]/div");

    private By divPlaceFrom = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[1]/menu/div/ul/li/div/div[1]/div");

    public TicketsAviaPage(WebDriver driver) {
        super(driver);
    }

    public TicketsAviaPage openFromField() {
        LOGGER.log(Level.INFO, "From field was opened");
        findElementByLocatorAndClick(fromField);
        return this;
    }

    public TicketsAviaPage openPassengerField() {
        LOGGER.log(Level.INFO, "Passenger field was opened");
        findElementByLocatorAndClick(passengerField);
        return this;
    }

    public TicketsAviaPage openToField() {
        LOGGER.log(Level.INFO, "To field was opened");
        findElementByLocatorAndClick(toField);
        return this;
    }

    public TicketsAviaPage enterPlaceFrom(String place) {
        LOGGER.log(Level.INFO, "Data was entered");
        findElementByLocatorAndClick(denyButton);
        findElementByLocatorAndClick(placeFrom).sendKeys(place);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions
                .elementToBeClickable(divPlaceFrom));
        findElementByLocatorAndClick(divPlaceFrom);
        return this;
    }

    public TicketsAviaPage enterPlaceTo(String place) {
        LOGGER.log(Level.INFO, "Data was entered");
        findElementByLocatorAndClick(placeTo).sendKeys(place);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions
                .elementToBeClickable(divPlaceTo));
        findElementByLocatorAndClick(divPlaceTo);
        return this;
    }

    public TicketsAviaPage openDatePicker() {
        LOGGER.log(Level.INFO, "Datepicker was opened");
        findElementByLocatorAndClick(datePicker);
        return this;
    }

    public TicketsAviaPage selectDate() {
        LOGGER.log(Level.INFO, "The date has been selected");
        findElementByLocatorAndClick(currentDate);
        return this;
    }

    public TicketsAviaPage clickButtonOneWay() {
        LOGGER.log(Level.INFO, "The button one way was clicked");
        findElementByLocatorAndClick(oneWay);
        return this;
    }

    public TicketsAviaResultsPage clickButtonSearch() {
        LOGGER.log(Level.INFO, "The button search was clicked");
        findElementByLocatorAndClick(buttonSearch);
        return new TicketsAviaResultsPage(driver);
    }

    public TicketsAviaPage clickButtonSwap() {
        LOGGER.log(Level.INFO, "The button swap was clicked");
        findElementByLocatorAndClick(buttonSwap);
        return this;
    }

    public TicketsAviaPage clickTopSpace() {
        LOGGER.log(Level.INFO, "The button swap was clicked");
        findElementByLocatorAndClick(topSpaceBetween);
        return this;
    }

    public TicketsAviaPage addMaxNumberOfPassenger() {
        try{WebDriverWait webDriverWait = new WebDriverWait(driver, 1);
            while (null != webDriverWait.until(ExpectedConditions
                    .elementToBeClickable(buttonAddPassenger))) {
                findElementByLocatorAndClick(buttonAddPassenger);
                LOGGER.log(Level.INFO, "Adding passengers...");
            }}
        catch (org.openqa.selenium.TimeoutException ignored){

        }
        return this;
    }

    public String getPassengerErrorText() {
        LOGGER.log(Level.INFO, "Getting error text");
        return findElementByLocator(passengerError).getText();
    }

    public String getPlaceFromText() {
        LOGGER.log(Level.INFO, "Getting place from text");
        return findElementByLocator(placeFromText).getText();
    }

    public String getPlaceToText() {
        LOGGER.log(Level.INFO, "Getting place from text");
        return findElementByLocator(placeToText).getText();
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
