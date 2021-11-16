import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TicketsHomePage;
import page.TicketsBusPage;

public class TicketsBusPageTest {
    private WebDriver driver;
    private FirefoxOptions options = new FirefoxOptions().setHeadless(true);

    private String errorText = "Станции отправления и прибытия совпадают. Измените, пожалуйста, данные для успешного поиска.";

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        driver = new FirefoxDriver(options);
    }
    
    @Test
    public void enterSameDepartureAndArrivalPlaces() {
        TicketsHomePage homePage = new TicketsHomePage(driver);
        
        TicketsBusPage resultsPage = homePage.openHomePage()
                                                 .openNavigationList()
                                                 .openBusPage();

        resultsPage.clickButtonMinsk()
                    .clickButtonSwap()
                    .clickButtonMinsk()
                    .openDatePicker()
                    .selectDate()
                    .clickButtonSearch();

        Assert.assertEquals(resultsPage.getErrorText(), errorText);
    }
    
    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver.quit();
    }
}
