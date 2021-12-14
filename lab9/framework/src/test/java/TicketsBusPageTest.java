import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.TicketsBusPage;
import page.TicketsBusResultsPage;
import page.TicketsHomePage;
import util.CommonConditions;

public class TicketsBusPageTest extends CommonConditions {
    private String errorText = "Станции отправления и прибытия совпадают. Измените, пожалуйста, данные для успешного поиска.";

    private String errorArrivalPlaceText = "Это поле необходимо заполнить";

    
    @Test
    public void enterSameDepartureAndArrivalPlacesTest() {
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

    @Test
    public void findBusesTest(){
        TicketsHomePage homePage = new TicketsHomePage(driver);

        TicketsBusPage busPage = homePage.openHomePage()
                .openNavigationList()
                .openBusPage();

        TicketsBusResultsPage resultsPage = busPage.clickButtonVitebsk()
                .clickButtonMinsk()
                .openDatePicker()
                .selectDate()
                .clickButtonSearch();
        Assert.assertTrue(resultsPage.isInitialized());
    }

    @Test
    public void emptyArrivalPlaceTest(){
        TicketsHomePage homePage = new TicketsHomePage(driver);

        TicketsBusPage busPage = homePage.openHomePage()
                .openNavigationList()
                .openBusPage();

        busPage.clickButtonMinsk()
                .openDatePicker()
                .selectDate()
                .clickButtonSearch();

        Assert.assertEquals(busPage.getErrorArrivalPlaceText(), errorArrivalPlaceText);
    }

}
