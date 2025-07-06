package test.LoginTest;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePages.HomePage;
import pages.HomePages.LoginAndRegisterPage;
import utils.ExcelUtils;

public class L01_LoginTest extends BaseTest {

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData(){
        return ExcelUtils.readExcel("D:\\QA\\eCommerceTEsting_automationexercise.com\\src\\testdata\\LoginForm.xlsx","Sheet1");
    }

    @Test(dataProvider = "LoginData",priority = 1)
    public void LoginTesting(String emailLogin, String passwordLogin, String userName){
        test = extent.createTest("Positive Case Login : Input valid email and valid password");

        HomePage homePage = new HomePage(driver, test);
        homePage.goToLoginRegister();
        test.pass("Click on 'Signup / Login' button");

        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver, test);
        loginAndRegisterPage.verifyLoginReg();
        test.pass("Verify 'Login to your account' is visible");


        try {
            loginAndRegisterPage.emailLogin(emailLogin);
            loginAndRegisterPage.passwordLogin(passwordLogin);
            test.pass("Login User with correct email : " + emailLogin + " and password : " + passwordLogin + "");

            loginAndRegisterPage.loginButton();
            test.pass("Click 'login' button");

            homePage.verifyUserCreatedLogin(userName);
            test.pass("Verify that 'Logged in as "+userName+"' is visible");
        } catch (AssertionError e) {
           test.fail("Unable to locate element");
       }
    }

}
