package tests;

import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import utils.DataProviders;


public class ProfileTests extends BaseTest{

    LoginPage loginPage;
    ProfilePage profilePage;

    @Test(enabled = false, description = "Sprint1 INTERNSHIP-79697", dataProvider = "profileData", dataProviderClass = DataProviders.class)
    public void userShouldBeAbleToUpdatePasswordFromProfilePage(String email, String password, String newPassword) {

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        loginPage.userLogin(email, password)
                 .verifyLoginSuccessful();
        profilePage.clickAvatar()
                   .updatePassword(password, newPassword);
        System.out.println("New Password: " + newPassword);
        profilePage.clickSaveBtn()
                   .verifySuccessfulMessageUpdate();
    }

    @Test(enabled = true, description = "Sprint1 JIRA-79699, Testing Login with NewPassword is successful", dataProvider = "loginData", dataProviderClass = DataProviders.class)
    public void userShouldBeAbleToLoginWithNewPassword(String email, String newPassword){

        loginPage = new LoginPage(driver);

        loginPage.userLogin(email, newPassword)
                 .verifyLoginSuccessful();
    }

    @Test(enabled = true, description = "Sprint1 JIRA-79700, Testing Old password should not work anymore", dataProvider = "oldPasswordLoginData", dataProviderClass = DataProviders.class)
    public void verifyThatOldPasswordShouldNotWork (String email, String oldPassword) {

        loginPage = new LoginPage(driver);

        loginPage.userLogin(email, oldPassword);
        loginPage.verifyLoginUrlIsVisible();
  }

  @Test(enabled = true, description = "Sprint1 JIRA-79706, Verify Password boundaries", dataProvider = "", dataProviderClass = DataProviders.class)
    public void verifyNewPasswordBoandaryTesting(String email, String password, String currPassword, String newPassword) {

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);

        loginPage.userLogin(email, password)
                .verifyLoginSuccessful();
        profilePage.clickAvatar()
                .updatePassword(currPassword, newPassword);

  }
}