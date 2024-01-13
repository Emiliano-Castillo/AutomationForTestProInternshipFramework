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

    ///////////////////LOCATORS\\\\\\\\\\\\\\\\\\\\\

    private final By emailInput = By.cssSelector("input[type='email']");
    private final By passwordInput = By.cssSelector("input[type='password']");
    private final By loginBtn = By.cssSelector("button[type='submit']");
    private final By registerBtn = By.cssSelector("a[href='registration']");
    private final By registerEmailInput = By.cssSelector("input[type='email']");
    private final By registerSubBtn = By.id("button");

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

    public LoginPage userLogin(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginBtn();
        return this;
    }

    public void registration() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerBtn)).click();
    }

    public void enterRegisterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerEmailInput)).sendKeys(email);
    }

    public void clickRegisterSubmit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerSubBtn)).click();
    }

    public LoginPage newUserRegistration(String email) {
        registration();
        enterRegisterEmail(email);
        clickRegisterSubmit();
        return this;
    }

    /////////////////ASSERTIONS\\\\\\\\\\\\\\\\\\\\\\

    public void verifyLoginSuccessful() {
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
        Assert.assertTrue(avatar.isDisplayed());
    }

    public void verifyRegistrationSuccessful() {
        WebElement messageSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".login-wrapper .messages")));
        Assert.assertTrue(messageSuccess.isDisplayed());
    }
//        String testName= it.getName();
//
//        if(testName.equals("LonginTests")) {
//            return loginData;
//        }else if(testName.equals("UpdatePassword")){
//            return updatePasswordData;
//        }else
//            return new Object[][] {{"No test data present"}, {"No test Data present"}};

        ///////////////////////
//        String methodName= method.getName();
//        if(methodName.equals("loginWithValidCredentials")) {
//            return loginData;
//        }else if (methodName.equals("userShouldBeAbleToUpdatePasswordFromProfilePage")) {
//            return updatePasswordData;
//        }else {
//            return new Object[][] {{"No test data present"}, {"No test Data present"}};
        //////////////////////////
}