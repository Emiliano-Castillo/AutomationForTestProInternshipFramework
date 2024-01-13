package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.security.Key;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    ///////////////////LOCATORS\\\\\\\\\\\\\\\\\\\\\

    private final By searchField = By.cssSelector("input[type='Search']");
    private final By resultsPageForSongPluto = By.xpath("//strong[contains(text(),'Pluto')]");
    private final By resultsPageForArtistGrav = By.xpath("//strong[contains(text(),'Grav')]");
    private final By resultDisplayedForSongsSection = By.cssSelector("section[class='songs'] article[data-test='song-card']");
    private final By resultDisplayedForArtistSection = By.cssSelector("section[class='artists'] article[data-test='artist-card']");
    private final By resultDisplayedForAlbumsSection = By.cssSelector("section[class='albums'] article[data-test='album-card']");
    private final By xBtn = By.cssSelector(".dirty");


    //////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\

    public SearchPage searchSongPluto (String songName) {
        WebElement pluto = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        pluto.clear();
        pluto.sendKeys(songName);
        return this;
    }

    public SearchPage searchArtistGrav (String artistName) {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        search.clear();
        search.sendKeys(artistName);
        return this;
    }

    public SearchPage searchNonExistingSong (String songName) {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        search.clear();
        search.sendKeys(songName);
        return this;
    }

    public SearchPage clearSearchBarPressingEscKey () {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        search.click();
        actions.sendKeys(Keys.ESCAPE).perform();
        return this;
    }

    public SearchPage clearSearchBarClickingX () {
        WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        search.click();
        return this;
    }

    /////////////////ASSERTIONS\\\\\\\\\\\\\\\\\\\\\\

    public void verifySearchPageIsDisplayed() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa.koel.app/#!/search","URL does not match expected");
    }

    public void verifyPlutoResultsMatchesSongSectionOnResultsPage() {
        WebElement textSong = wait.until(ExpectedConditions.presenceOfElementLocated(resultsPageForSongPluto));
        Assert.assertTrue(textSong.isDisplayed(), "Results for Song 'Pluto' is not displayed");
    }

    public void verifyGravResultsMatchesArtistSectionOnResultsPage() {
        WebElement artistCard = wait.until(ExpectedConditions.presenceOfElementLocated(resultDisplayedForArtistSection));
        Assert.assertTrue(artistCard.isDisplayed(), "Results for Song 'Grav' is not displayed");
    }

    public void verifyResultIsAnEmptyList() {

        boolean songCard = wait.until(ExpectedConditions.invisibilityOfElementLocated(resultDisplayedForSongsSection));
        Assert.assertTrue(songCard);
        boolean artistCard = wait.until(ExpectedConditions.invisibilityOfElementLocated(resultDisplayedForArtistSection));
        Assert.assertTrue(artistCard);
        boolean albumCard = wait.until(ExpectedConditions.invisibilityOfElementLocated(resultDisplayedForAlbumsSection));
        Assert.assertTrue(albumCard);
    }

    public void verifyWhenEnteringCaseSensitiveDataShouldNotBeValid() {
        WebElement songCard = wait.until(ExpectedConditions.visibilityOfElementLocated(resultDisplayedForSongsSection));
        Assert.assertFalse(songCard.isDisplayed());
    }

    public void verifySongCardShouldBeEmpty(){
        boolean songCard = wait.until(ExpectedConditions.invisibilityOfElementLocated(resultDisplayedForSongsSection));
        Assert.assertTrue(songCard);
    }
}