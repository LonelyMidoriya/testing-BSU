package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketsGdPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By fromField = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[1]/div/button/div");

    private By toField = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[2]/div/button/div ");

    private By placeFrom = By.xpath("//a[@class='search-form-railway-autocomplete-item__item'] ");

    private By placeTo = By.xpath("/html/body/header/div/div[3]/section/div/form/div/div[1]/div[2]/menu/div/ul/li[2]/section/a");

    private By datePicker = By.xpath("//button[@class='t-date-picker__activator ltr bg-1 theme-default'] ");

    private By datePickerDefault = By.xpath("//button[@class='t-btn theme-default _flat search-form-railway__button-calendar'] ");


    private By currentDate = By.xpath("//div[@class='t-price color21 theme-default search-form-railway__calendar-price'] ");

    private By buttonSearch = By.xpath("//button[@class='t-btn _size-xl theme-default main-search-inner-form__submit'] ");

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

    public TicketsGdPage enterPlaceFrom() {
        LOGGER.log(Level.INFO, "Data was entered");
        findElementByLocatorAndClick(placeFrom);
        return this;
    }

    public TicketsGdPage enterPlaceTo() {
        LOGGER.log(Level.INFO, "Data was entered");
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

    public String getDateErrorText() {
        LOGGER.log(Level.INFO, "Getting error text");
        return findElementByLocator(dateError).getText();
    }

    public String getPlaceFromAndPlaceToErrorText() {
        LOGGER.log(Level.INFO, "Getting error text");
        return findElementByLocator(placeFromAndPlaceToError).getText();
    }
}
