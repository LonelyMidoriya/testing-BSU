import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TicketsHomePage;
import page.TicketsBusPage;

public class TicketsHomePageSearchFormTest {
    private WebDriver driver;
    private FirefoxOptions options = new FirefoxOptions().setHeadless(true);

    private String exeptionText = "Станции отправления и прибытия совпадают. Измените, пожалуйста, данные для успешного поиска.";

    @BeforeMethod(alwaysRun = true)
    public void setupBrowser() {
        driver = new FirefoxDriver(options);
        //driver.manage().window();
    }
    
    @Test
    public void sameDepartureAndArrivalPlaces() {
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

        Assert.assertEquals(resultsPage.getExceptionText(),exeptionText);
    }
    
    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        driver.quit();
    }
}
