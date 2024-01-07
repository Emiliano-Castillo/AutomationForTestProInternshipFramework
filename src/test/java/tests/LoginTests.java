package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTests extends BaseTest {

    LoginPage loginPage;

    @DataProvider(name = "validLoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"emiliano.castillo@testpro.io","Et!@&eV!6K&bk6jLg@EhqQW"}
        };
    }

    @Test(description = "This test is for valid Login", dataProvider = "validLoginData")
    public void loginWithValidCredentials(String email, String password) {
        loginPage = new LoginPage(driver);

        loginPage.userLogin(email, password)
                 .verifyLoginSuccessful();
    }

    @DataProvider(name = "registrationData")
    public Object[][] registerData() {
        return new Object[][] {
                {"emiliano.castillo+1234@testpro.io"}
        };
    }

    @Test(description = "This test registering new user", dataProvider = "registrationData")
    public void registerNewUser (String email) {
        loginPage = new LoginPage(driver);

        loginPage.newUserRegistration(email)
                 .verifyRegistrationSuccessful();
    }
}