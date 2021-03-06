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

    private By fromField = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[1]/div/button/div[1]");

    private By toField = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[2]/div/button/div[1]");

    private By complexFromField = By.xpath("/html/body/header/div/div[3]/div/form/div[2]/div/div[1]/div[1]/div/button/div[1]");

    private By complexToField = By.xpath("/html/body/header/div/div[3]/div/form/div[2]/div/div[1]/div[2]/div/button/div[1]");

    private By placeFrom = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[1]/menu/div/li/div/input");

    private By placeTo = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[2]/menu/div/li/div/input");

    private By complexPlaceFrom = By.xpath("/html/body/header/div/div[3]/div/form/div[2]/div/div[1]/div[1]/menu/div/li/div/input");

    private By complexPlaceTo = By.xpath("/html/body/header/div/div[3]/div/form/div[2]/div/div[1]/div[2]/menu/div/li/div/input");

    private By placeFromText = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[1]/menu/div/li/div/input ");

    private By placeToText = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[2]/menu/div/li/div/input");

    private By denyButton = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[1]/menu/div/li/div/button");

    private By datePicker = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[2]/div[1]/div/button[1]/div");

    private By currentDate = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[2]/div[1]/menu/div/div/div[1]/div/div[2]/div[3]/div[4]/button");

    private By complexDatePicker = By.xpath("/html/body/header/div/div[3]/div/form/div[2]/div/div[2]/div[1]/div/button");

    private By complexCurrentDate = By.xpath("/html/body/header/div/div[3]/div/form/div[2]/div/div[2]/div[1]/menu/div/div/div/div/div[2]/div[5]/div[5]/button");

    private By oneWay = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[2]/div[1]/menu/div/div/div[2]/div/div[2]/button");

    private By buttonSwap = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/button");

    private By buttonSearch = By.xpath("/html/body/header/div/div[3]/div/form/div/div[2]/button");

    private By passengerField = By.xpath("//button[@class='t-search-form-activator pl-1 pr-1 rel cursor-pointer theme-default search-form-avia-passengers-select-v2-activator'] ");

    private By passengerError = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[2]/div[2]/div/menu/div/div/div[1]/div/div[1]/div/div[1]/div[1]/div[2]/div/div");

    private By buttonAddPassenger = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[2]/div[2]/div/menu/div/div/div[1]/div/div[1]/div/div[2]/button[2]");

    private By topSpaceBetween = By.xpath("//h1[@class='app-header-title'] ");

    private By divPlaceTo = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[2]/menu/div/ul/li[1]/div/div[1]/div");

    private By divPlaceFrom = By.xpath("/html/body/header/div/div[3]/div/form/div/div[1]/div/div[1]/div[1]/menu/div/ul/li[1]/div/div[1]/div");

    private By divComplexPlaceTo = By.xpath("/html/body/header/div/div[3]/div/form/div[2]/div/div[1]/div[2]/menu/div/ul/li[1]/div/div[1]/div");

    private By divComplexPlaceFrom = By.xpath("/html/body/header/div/div[3]/div/form/div[2]/div/div[1]/div[1]/menu/div/ul/li/div/div[1]/div");

    private By comlexFlight = By.xpath("/html/body/header/div/div[3]/div/div/div/div/button/span ");

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

    public TicketsAviaPage openComplexToField() {
        LOGGER.log(Level.INFO, "Complex To field was opened");
        findElementByLocatorAndClick(complexToField);
        return this;
    }

    public TicketsAviaPage openComplexFromField() {
        LOGGER.log(Level.INFO, "Complex from field was opened");
        findElementByLocatorAndClick(complexFromField);
        return this;
    }

    public TicketsAviaPage enterPlaceFrom(String place) {
        LOGGER.log(Level.INFO, "Data was entered");
        findElementByLocatorAndClick(denyButton);
        findElementByLocatorAndClick(placeFrom).sendKeys(place);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElementByLocatorAndClick(divPlaceFrom);
        return this;
    }

    public TicketsAviaPage enterComplexPlaceFrom(String place) {
        LOGGER.log(Level.INFO, "Data was entered");
        findElementByLocatorAndClick(complexPlaceFrom).sendKeys(place);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElementByLocatorAndClick(divComplexPlaceFrom);
        return this;
    }

    public TicketsAviaPage enterComplexPlaceTo(String place) {
        LOGGER.log(Level.INFO, "Data was entered");
        findElementByLocatorAndClick(complexPlaceTo).sendKeys(place);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElementByLocatorAndClick(divComplexPlaceTo);
        return this;
    }

    public TicketsAviaPage enterPlaceTo(String place) {
        LOGGER.log(Level.INFO, "Data was entered");
        findElementByLocatorAndClick(placeTo).sendKeys(place);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElementByLocatorAndClick(divPlaceTo);
        return this;
    }

    public TicketsAviaPage openDatePicker() {
        LOGGER.log(Level.INFO, "Datepicker was opened");
        findElementByLocatorAndClick(datePicker);
        return this;
    }

    public TicketsAviaPage openComplexDatePicker() {
        LOGGER.log(Level.INFO, "Datepicker was opened");
        findElementByLocatorAndClick(complexDatePicker);
        return this;
    }

    public TicketsAviaPage selectDate() {
        LOGGER.log(Level.INFO, "The date has been selected");
        findElementByLocatorAndClick(currentDate);
        return this;
    }

    public TicketsAviaPage selectComplexDate() {
        LOGGER.log(Level.INFO, "The date has been selected");
        findElementByLocatorAndClick(complexCurrentDate);
        return this;
    }

    public TicketsAviaPage clickButtonOneWay() {
        LOGGER.log(Level.INFO, "The button one way was clicked");
        findElementByLocatorAndClick(oneWay);
        return this;
    }

    public TicketsAviaPage clickButtonComplexFlight() {
        LOGGER.log(Level.INFO, "The button one way was clicked");
        findElementByLocatorAndClick(comlexFlight);
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
