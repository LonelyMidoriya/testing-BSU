import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import util.CommonConditions;

public class TicketsGdPageTest extends CommonConditions {
    private String errorText = "Это поле необходимо заполнить";

    private String errorPlace = "Вы не указали маршрут";

    private static final String LOCATIONFROM = "Москва";
    private static final String LOCATIONTO = "Минск";

    @Test
    public void findGdTest(){
        TicketsHomePage homePage = new TicketsHomePage(driver);

        TicketsGdPage GdPage = homePage.openHomePage()
                .openNavigationList()
                .openGdPage();

        TicketsGdResultsPage resultsPage = GdPage.openFromField()
                .enterPlaceFrom(LOCATIONFROM)
                .openToField()
                .enterPlaceTo(LOCATIONTO)
                .openDatePicker()
                .selectDate()
                .clickButtonSearch();
        Assert.assertTrue(resultsPage.isInitialized());
    }

    @Test
    public void emptyDateTest(){
        TicketsHomePage homePage = new TicketsHomePage(driver);

        TicketsGdPage GdPage = homePage.openHomePage()
                .openNavigationList()
                .openGdPage();

        GdPage.openFromField()
                .enterPlaceFrom(LOCATIONFROM)
                .openToField()
                .enterPlaceTo(LOCATIONTO)
                .clickButtonSearch();
        Assert.assertTrue(GdPage.getDateErrorText().equals(errorText));
    }

    @Test
    public void onlyDateEnteredTest(){
        TicketsHomePage homePage = new TicketsHomePage(driver);

        TicketsGdPage GdPage = homePage.openHomePage()
                .openNavigationList()
                .openGdPage();

        GdPage.openDatePickerDefault();
        Assert.assertTrue(GdPage.getPlaceFromAndPlaceToErrorText().equals(errorPlace));
    }
}
