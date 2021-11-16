package page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketsHomePage {
    private WebDriver driver;
    private static final String HOMEPAGE_URL = "https://tickets.by/";

    private By navigationList = By.xpath("//button[@class='app-top-nav-activator h6 color-1 f-center-center dropdown']");

    private By buttonBusPage = By.xpath("//a[@href='https://tickets.by/bus/']");

    public TicketsHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public TicketsHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public TicketsHomePage openNavigationList() {
        findElementByLocatorAndClick(navigationList);
        return this;
    }

    public TicketsBusPage openBusPage() {
        findElementByLocatorAndClick(buttonBusPage);
        return new TicketsBusPage(driver);
    }

    public WebElement findElementByLocator(By locator) {
        return new WebDriverWait(driver, 20)
                .until(ExpectedConditions
                        .presenceOfElementLocated(locator));
    }
    
    public WebElement findElementByLocatorAndClick(By locator) {
            WebElement element = findElementByLocator(locator);
            element.click();
            return element;
    }
}
