package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    ///////////////////SELECTORS\\\\\\\\\\\\\\\\\\\\\

    private final By emailInput = By.cssSelector("input[type='email']");
    private final By passwordInput = By.cssSelector("input[type='password']");
    private final By loginBtn = By.cssSelector("button[type='submit']");

    //////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\

    public LoginPage enterEmail (String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
        return this;
    }

    public LoginPage enterPassword (String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginBtn () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
        return this;
    }

    /////////////////ASSERTIONS\\\\\\\\\\\\\\\\\\\\\\

    public void verifyLoginSuccessful() {
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatar.isDisplayed());
    }
}
