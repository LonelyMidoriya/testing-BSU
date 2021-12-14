package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsHomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final String HOMEPAGE_URL = "https://tickets.by/";

    private By navigationList = By.xpath("//button[@class='app-top-nav-activator h6 color-1 f-center-center dropdown']");

    private By buttonBusPage = By.xpath("//a[@href='https://tickets.by/bus/']");
    private By buttonAviaPage = By.xpath("//a[@href='https://tickets.by/avia/']");
    private By buttonGdPage = By.xpath("//a[@href='https://tickets.by/gd/']");

    public TicketsHomePage(WebDriver driver) {
        super(driver);
    }

    public TicketsHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        LOGGER.log(Level.INFO, "Home page was opened");
        return this;
    }

    public TicketsHomePage openNavigationList() {
        findElementByLocatorAndClick(navigationList);
        LOGGER.log(Level.INFO, "Navigation List was opened");
        return this;
    }

    public TicketsBusPage openBusPage() {
        findElementByLocatorAndClick(buttonBusPage);
        LOGGER.log(Level.INFO, "Bus page was opened");
        return new TicketsBusPage(driver);
    }

    public TicketsAviaPage openAviaPage() {
        findElementByLocatorAndClick(buttonAviaPage);
        LOGGER.log(Level.INFO, "Avia page was opened");
        return new TicketsAviaPage(driver);
    }

    public TicketsGdPage openGdPage() {
        findElementByLocatorAndClick(buttonGdPage);
        LOGGER.log(Level.INFO, "Gd page was opened");
        return new TicketsGdPage(driver);
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
