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
}