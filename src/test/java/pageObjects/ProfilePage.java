package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    ///////////////////LOCATORS\\\\\\\\\\\\\\\\\\\\\

    private final By avatarBtn = By.cssSelector("img.avatar");
    private final By currentPassInput = By.id("inputProfileCurrentPassword");
    private final By name = By.id("inputProfileName");
    private final By emailInput = By.id("inputProfileEmail");
    private final By newPassInput = By.id("inputProfileNewPassword");
    private final By saveBtn = By.cssSelector(".btn-submit");
    private final By updateProfileMessage = By.cssSelector(".alertify-logs .success");

    //////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\

    public ProfilePage clickAvatar (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(avatarBtn)).click();
        return this;
    }

    public ProfilePage enterCurrentPass (String password) {
        WebElement curr = wait.until(ExpectedConditions.visibilityOfElementLocated(currentPassInput));
        curr.clear();
        curr.sendKeys(password);
        return this;
    }

    public ProfilePage enterName (String email) {
        WebElement nameEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(name));
        nameEmail.clear();
        nameEmail.sendKeys(email);
        return this;
    }

    public ProfilePage enterEmail (String email) {
        WebElement emailEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        emailEmail.clear();
        emailEmail.sendKeys(email);
        return this;
    }

    public ProfilePage enterNewPass (String newPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(newPassInput)).sendKeys(newPassword);
        return this;
    }

    public ProfilePage clickSaveBtn () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn)).click();
        return this;
    }
//    public ProfilePage updatePassword (String password) {
//        enterCurrentPass(password);
//        enterNewPass();
//        clickSaveBtn();
//        return this;
//    }

    /////////////////ASSERTIONS\\\\\\\\\\\\\\\\\\\\\\

    public void verifySuccessfulMessageUpdate () {
        WebElement greenMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(updateProfileMessage));
        Assert.assertTrue(greenMessage.isDisplayed());
    }

    /////////////////DATA PROVIDERS\\\\\\\\\\\\\\\\\\\\

//    @DataProvider(name = "updatePasswordSuccessfully")
//    public static Object[][] profileData() {
//        return new Object[][] {
//                {"Emz1234!!!!","Emz1234!!!!1",}
//        };
//    }
}