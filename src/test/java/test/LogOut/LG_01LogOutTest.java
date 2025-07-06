package test.LogOut;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePages.HomePage;
import pages.HomePages.LoginAndRegisterPage;

public class LG_01LogOutTest extends BaseTest {


    @DataProvider(name = "LogOutData")
    public Object[][] getLogOutData(){
        return new Object[][]{
                {"kukuhpradipto1@gmail.com","Password123","Kukuh1"},
                {"kukuhpradipto2@gmail.com","Password123","Kukuh2"}
        };
    }

    @Test(dataProvider = "LogOutData", priority = 1)
    public void LogOutTest_01(String email, String password, String userName){
        test = extent.createTest("Positive Case Log Out : logs out successfully after being logged");

        HomePage homePage = new HomePage(driver, test);

        homePage.goToLoginRegister();

            LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver, test);
            loginAndRegisterPage.emailLogin(email);
            loginAndRegisterPage.passwordLogin(password);
            test.pass("Login User with correct email : " + email + " and password : " + password + "");

            loginAndRegisterPage.loginButton();
            test.pass("Click 'login' button");

            homePage.verifyUserCreatedLogin(userName);
            test.pass("Verify that 'Logged in as username' is visible");

            homePage.buttonToLogout();
            test.pass("Click button logout");

            try{
                homePage.verifyButtonToLogoutNotDisplay();
                test.pass("Button Logout is not Displayed");
            } catch (AssertionError e){
                test.fail("Element should not be visible");
            }


    }

}
