package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utils.DataProviders;

public class LoginTests extends BaseTest {

    LoginPage loginPage;

    @Test(description = "This test is for valid Login", dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void loginWithValidCredentials(String email, String password) {
        loginPage = new LoginPage(driver);
        try {
            loginPage.userLogin(email, password)
                    .verifyLoginSuccessful();
        } catch (Exception e){
            System.out.print("Exceptions caught" + e.getMessage());
        }
    }

    @Test(description = "This test registering new user", dataProvider = "registrationData", dataProviderClass = DataProviders.class)
    public void registerNewUser (String email) {
        loginPage = new LoginPage(driver);

        loginPage.newUserRegistration(email)
                 .verifyRegistrationSuccessful();
    }
}