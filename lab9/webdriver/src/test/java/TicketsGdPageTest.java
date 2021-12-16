import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;
import util.CommonConditions;

public class TicketsGdPageTest extends CommonConditions {
    private String errorText = "Это поле необходимо заполнить";

    private String errorPlace = "Вы не указали маршрут";
    @Test
    public void findGdTest(){
        TicketsHomePage homePage = new TicketsHomePage(driver);

        TicketsGdPage GdPage = homePage.openHomePage()
                .openNavigationList()
                .openGdPage();

        TicketsGdResultsPage resultsPage = GdPage.openFromField()
                .enterPlaceFrom()
                .openToField()
                .enterPlaceTo()
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
                .enterPlaceFrom()
                .openToField()
                .enterPlaceTo()
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
