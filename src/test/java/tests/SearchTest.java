package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

import static data.AssertionData.*;

public class SearchTest extends TestBase {

    @Test
    public void UserCanSearch() {
        HomePage homePage = new HomePage(getDriver());
        SearchResultsPage searchResultsPage = new SearchResultsPage(getDriver());
        Assert.assertTrue(getDriver().getCurrentUrl().contains(ASSERTING_URL_TEXT));
        homePage.UserSearch(SEARCH_KEY_WORD);
        Assert.assertTrue(searchResultsPage.logoVisible());
        searchResultsPage.clickNextPage();
        int secondPage = searchResultsPage.countResultsPage();
        Assert.assertTrue(searchResultsPage.pageNumber.getText().contains(PAGE_TWO));
        searchResultsPage.clickNextPage();
        int thirdPage = searchResultsPage.countResultsPage();
        Assert.assertTrue(searchResultsPage.pageNumber.getText().contains(PAGE_THREE));
        Assert.assertEquals(secondPage, thirdPage);
    }
}