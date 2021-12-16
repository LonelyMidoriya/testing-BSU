package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TicketsGdResultsPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private By locator = By.xpath("//img[@src='https://static.tickets.by/img/v3/login_logo.svg?706212bdd9']");

    protected TicketsGdResultsPage(WebDriver driver) {
        super(driver);
    }
    public boolean isInitialized() {
        return findElementByLocator(locator).isDisplayed();
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