package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsGdPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By fromField = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[1]/div/button/div");

    private By toField = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[2]/div/button/div");

    private By placeFromText = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[1]/menu/div/li/div/input");

    private By placeToText = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[2]/menu/div/li/div/input");

    private By placeFrom = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[1]/menu/div/ul/li[1]/section/a ");

    private By placeTo = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[2]/menu/div/ul/li[2]/section/a");

    private By datePicker = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[3]/div/div/button");

    private By datePickerDefault = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[3]/button");


    private By currentDate = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[3]/div/menu/div/div/div[1]/div/div[2]/div[3]/div[4]/button");

    private By buttonSearch = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[2]/button");

    private By dateError = By.xpath("//div[@class='t-date-picker__error-message'] ");

    private By placeFromAndPlaceToError = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[3]/section/p/strong");

    public TicketsGdPage(WebDriver driver) {
        super(driver);
    }

    public TicketsGdPage openFromField() {
        LOGGER.log(Level.INFO, "From field was opened");
        findElementByLocatorAndClick(fromField);
        return this;
    }

    public TicketsGdPage openToField() {
        LOGGER.log(Level.INFO, "To field was opened");
        findElementByLocatorAndClick(toField);
        return this;
    }

    public TicketsGdPage enterPlaceFrom(String place) {
        LOGGER.log(Level.INFO, "Data was entered");
        findElementByLocatorAndClick(placeFromText).sendKeys(place);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElementByLocatorAndClick(placeFrom);
        return this;
    }

    public TicketsGdPage enterPlaceTo(String place) {
        LOGGER.log(Level.INFO, "Data was entered");
        findElementByLocatorAndClick(placeToText).sendKeys(place);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        findElementByLocatorAndClick(placeTo);
        return this;
    }

    public TicketsGdPage openDatePicker() {
        LOGGER.log(Level.INFO, "Datepicker was opened");
        findElementByLocatorAndClick(datePicker);
        return this;
    }

    public TicketsGdPage openDatePickerDefault() {
        LOGGER.log(Level.INFO, "Datepicker was opened");
        findElementByLocatorAndClick(datePickerDefault);
        return this;
    }

    public TicketsGdPage selectDate() {
        LOGGER.log(Level.INFO, "The date has been selected");
        findElementByLocatorAndClick(currentDate);
        return this;
    }

    public TicketsGdResultsPage clickButtonSearch() {
        LOGGER.log(Level.INFO, "The button search was clicked");
        findElementByLocatorAndClick(buttonSearch);
        return new TicketsGdResultsPage(driver);
    }

    public boolean isErrorTextVisiable() {
        LOGGER.log(Level.INFO, " Checking error");
        return findElementByLocator(dateError).isDisplayed();
    }

    public boolean isPlaceFromAndPlaceToErrorTextVisiable() {
        LOGGER.log(Level.INFO, " Checking error");
        return findElementByLocator(placeFromAndPlaceToError).isDisplayed();
    }
}
