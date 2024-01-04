package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class LoginTests extends BaseTest {

    LoginPage loginPage;

    @Test
    public void loginWithValidCreds(){
        loginPage = new LoginPage(driver);

        loginPage.enterEmail("emiliano.castillo@testpro.io")
                 .enterPassword("Et!@&eV!6K&bk6jLg@EhqQW")
                 .clickLoginBtn()
                 .verifyLoginSuccessful();
    }

}
