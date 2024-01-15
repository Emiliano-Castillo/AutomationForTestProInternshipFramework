package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

//Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    ///////////////////LOCATORS\\\\\\\\\\\\\\\\\\\\\

    private final By emailInput = By.cssSelector("input[type='email']");
    private final By passwordInput = By.cssSelector("input[type='password']");
    private final By loginBtn = By.cssSelector("button[type='submit']");
    private final By registerBtn = By.cssSelector("a[href='registration']");
    private final By registerEmailInput = By.cssSelector("input[type='email']");
    private final By registerSubBtn = By.id("button");
    private final By avatarImg = By.cssSelector("img.avatar");
    private final By registrationMessage = By.cssSelector(".login-wrapper .messages");

    //////////////////METHODS\\\\\\\\\\\\\\\\\\\\\\\\\

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
    }

    public void clickLoginBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
    }
    //This method will fill out login form and click Login
    public LoginPage userLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
        return this;
    }

    public void registrationClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerBtn)).click();
    }

    public void enterRegisterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerEmailInput)).sendKeys(email);
    }

    public void clickRegisterSubmit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerSubBtn)).click();
    }
    //This method will go fill out registration form and click submit
    public LoginPage newUserRegistration(String email) {
        registrationClick();
        enterRegisterEmail(email);
        clickRegisterSubmit();
        return this;
    }

    /////////////////ASSERTIONS\\\\\\\\\\\\\\\\\\\\\\

    public void verifyLoginSuccessful() {
        WebElement avatar = wait.until(ExpectedConditions.presenceOfElementLocated(avatarImg));
        Assert.assertTrue(avatar.isDisplayed());
    }

    public void verifyRegistrationSuccessful() {
        WebElement messageSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(registrationMessage));
        Assert.assertTrue(messageSuccess.isDisplayed());
    }
}