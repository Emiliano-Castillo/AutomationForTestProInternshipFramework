package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import utils.DataProviders;

public class SearchTests extends BaseTest{

    LoginPage loginPage;
    SearchPage searchPage;

    @Test(priority = 1, description = "JIRA Case- 80979. Test url search page is displayed", dataProvider = "searchData", dataProviderClass = DataProviders.class)
    public void searchForAnyExistingSongSearchPageShouldBeDisplayed (String email, String password, String songName){
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);

        loginPage.userLogin(email, password)
                .verifyLoginSuccessful();
        searchPage.searchSongPluto(songName)
                .verifySearchPageIsDisplayed();
    }

    @Test(priority = 2, description = "JIRA Case- 80981. Test for Searching song 'pluto'.", dataProvider = "searchData", dataProviderClass = DataProviders.class)
    public void searchForSongPluto (String email, String password, String songName) {
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);

        loginPage.userLogin(email, password)
                .verifyLoginSuccessful();
        searchPage.searchSongPluto(songName);
        searchPage.verifyPlutoResultsMatchesSongSectionOnResultsPage();
    }

    @Test(priority = 3, description = "JIRA Case- 80982. Test for Searching artist 'Grav'.", dataProvider = "searchArtistData", dataProviderClass = DataProviders.class)
    public void searchForArtistGrav (String email, String password, String artist){
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);

        loginPage.userLogin(email, password)
                .verifyLoginSuccessful();
        searchPage.searchArtistGrav(artist)
                .verifyGravResultsMatchesArtistSectionOnResultsPage();
    }

    @Test(priority = 4, description = "JIRA Case- 80984. Test for Searching song/artist/album that doesn't exist.", dataProvider = "searchNonExistingSongNameData", dataProviderClass = DataProviders.class)
    public void searchNonExistingSong (String email, String password, String Song) {
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);

        loginPage.userLogin(email, password)
                .verifyLoginSuccessful();
        searchPage.searchNonExistingSong(Song)
                .verifyResultIsAnEmptyList();
    }

    @Test(priority = 5, description = "JIRA Case- 80985 and 80986. Test for Search should ignore trailing  white spaces.", dataProvider = "searchWhiteSpacesData", dataProviderClass = DataProviders.class)
    public void searchIgnoresWhiteSpaces (String email, String password, String Song){
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);

        loginPage.userLogin(email, password)
                .verifyLoginSuccessful();
        searchPage.searchSongPluto(Song)
                .verifyPlutoResultsMatchesSongSectionOnResultsPage();
    }

    @Test(priority = 6, description = "JIRA Case- 80987. Test for Search should be case sensitive", dataProvider = "searchCaseSensitiveData", dataProviderClass = DataProviders.class)
    public void searchShouldBeCaseSensitive (String email, String password, String Song) {
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);

        loginPage.userLogin(email, password)
                .verifyLoginSuccessful();
        searchPage.searchSongPluto(Song)
                .verifyWhenEnteringCaseSensitiveDataShouldNotBeValid();
    }

    @Test(priority = 7, description = "JIRA Case- 80988. Test User can clear the search query with keyboard esc key and 'x' button", dataProvider = "searchPressingESCKeyData", dataProviderClass = DataProviders.class)
    public void searchClearingSearchBar (String email, String password, String Song) throws InterruptedException {
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);

        loginPage.userLogin(email, password)
                .verifyLoginSuccessful();
        searchPage.searchSongPluto(Song);
        searchPage.verifyPlutoResultsMatchesSongSectionOnResultsPage();
        Thread.sleep(1000);                   //Needed to put Thread.sleep or page wouldn't load fast enough to verify element is visible
        searchPage.clearSearchBarPressingEscKey();
        Thread.sleep(1000);
        searchPage.verifySongCardShouldBeEmpty();
    }
}