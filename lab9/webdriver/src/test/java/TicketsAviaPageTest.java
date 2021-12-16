import model.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.TicketsAviaPage;
import page.TicketsAviaResultsPage;
import page.TicketsHomePage;
import service.LocationsCreator;
import util.CommonConditions;

public class TicketsAviaPageTest extends CommonConditions {
    private String errorText = "Максимум 9 пассажиров";
    private static final String LOCATIONFROM = "Москва";
    private static final String LOCATIONTO = "Кливленд";
    @Test
    public void findAviaTest(){
        TicketsHomePage homePage = new TicketsHomePage(driver);
        Location testLocations = LocationsCreator.locationsFromProperty();
        TicketsAviaPage aviaPage = homePage.openHomePage()
                .openNavigationList()
                .openAviaPage();

        TicketsAviaResultsPage resultsPage = aviaPage.openFromField()
                .enterPlaceFrom(testLocations.getFromLocation())
                .openToField()
                .enterPlaceTo(testLocations.getToLocation()).clickTopSpace()
                .openDatePicker()
                .selectDate()
                .clickButtonOneWay()
                .clickButtonSearch();
        Assert.assertTrue(resultsPage.isInitialized());
    }

    @Test
    public void findComplexAviaTest(){
        TicketsHomePage homePage = new TicketsHomePage(driver);
        Location testLocations = LocationsCreator.locationsFromProperty();
        TicketsAviaPage aviaPage = homePage.openHomePage()
                .openNavigationList()
                .openAviaPage();

        TicketsAviaResultsPage resultsPage = aviaPage.openFromField()
                .enterPlaceFrom(testLocations.getFromLocation())
                .openToField()
                .enterPlaceTo(testLocations.getToLocation()).clickTopSpace()
                .openDatePicker()
                .selectDate()
                .clickButtonComplexFlight()
                .openComplexFromField()
                .enterComplexPlaceFrom(testLocations.getToLocation())
                .openComplexToField()
                .enterComplexPlaceTo(testLocations.getFromLocation())
                .clickTopSpace()
                .openComplexDatePicker()
                .selectComplexDate()
                .clickButtonSearch();
        Assert.assertTrue(resultsPage.isInitialized());
    }

    @Test
    public void addMaxPassengerTest(){
        TicketsHomePage homePage = new TicketsHomePage(driver);

        TicketsAviaPage aviaPage = homePage.openHomePage()
                .openNavigationList()
                .openAviaPage();

        aviaPage.openPassengerField()
                .addMaxNumberOfPassenger();
        Assert.assertEquals(aviaPage.getPassengerErrorText(),errorText);
    }

    @Test
    public void buttonSwapTest(){
        TicketsHomePage homePage = new TicketsHomePage(driver);
        Location testLocations = LocationsCreator.locationsFromProperty();
        TicketsAviaPage aviaPage = homePage.openHomePage()
                .openNavigationList()
                .openAviaPage();

        aviaPage.openFromField().enterPlaceFrom(testLocations.getFromLocation())
                .openToField().enterPlaceTo(testLocations.getToLocation());

        String[] placesBeforeSwap = {aviaPage.openFromField().getPlaceFromText(), aviaPage.openToField().getPlaceToText()};

        aviaPage.clickTopSpace().clickButtonSwap();

        Assert.assertTrue(placesBeforeSwap[0].equals(aviaPage.openToField().getPlaceToText())
                && placesBeforeSwap[1].equals(aviaPage.openFromField().getPlaceFromText()));
    }
}