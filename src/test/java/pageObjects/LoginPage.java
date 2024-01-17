package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
        findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginBtn() {
        click(loginBtn);
    }
    //This method will fill out login form and click Login
    public LoginPage userLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
        return this;
    }

    public void registrationClick() {
        click(registerBtn);
    }

    public void enterRegisterEmail(String email) {
        findElement(registerEmailInput).sendKeys(email);
    }

    public void clickRegisterSubmit() {
        click(registerSubBtn);
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
        WebElement avatar = findElement(avatarImg);
        Assert.assertTrue(avatar.isDisplayed());
    }

    public void verifyRegistrationSuccessful() {
        WebElement messageSuccess = findElement(registrationMessage);
        Assert.assertTrue(messageSuccess.isDisplayed());
    }
}