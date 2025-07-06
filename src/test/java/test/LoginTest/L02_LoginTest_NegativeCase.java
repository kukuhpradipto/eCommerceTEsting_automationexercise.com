package test.LoginTest;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePages.HomePage;
import pages.HomePages.LoginAndRegisterPage;
import utils.ExcelUtils;

public class L02_LoginTest_NegativeCase extends BaseTest {

    @DataProvider(name = "invalidLogin")
    public Object[][] getLoginTest_NegativeCase (){
        return ExcelUtils.readExcel("D:\\QA\\eCommerceTEsting_automationexercise.com\\src\\testdata\\LoginForm.xlsx", "Sheet2");
    }

    @Test(dataProvider = "invalidLogin",priority = 1)
    public void loginTest_NegativeCase(String emailLogin, String passwordLogin){

        if (emailLogin.trim().isEmpty() && passwordLogin.trim().isEmpty()){
            test = extent.createTest("Negative Case Login: Both email and password fields are blank");
        } else if (emailLogin.trim().isEmpty()){
            test = extent.createTest("Negative Case Login : Email is blank and password");
        } else if(passwordLogin.trim().isEmpty()){
            test = extent.createTest("Negative Case Login : Email and password is blank");
        } else {
            test = extent.createTest("Negative Case Login : Invalid Email and Invalid password");
        }

        HomePage homePage = new HomePage(driver, test);
        homePage.goToLoginRegister();

        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver, test);
        loginAndRegisterPage.emailLogin(emailLogin);
        loginAndRegisterPage.passwordLogin(passwordLogin);
        test.pass("Attempt to login using Email: " + emailLogin + " and Password: " + passwordLogin);

        loginAndRegisterPage.loginButton();
        test.pass("Click button Login");

        String toolTipsValidationEmailLogin = loginAndRegisterPage.toolTipsValidationEmailLogin();
        String toolTipsValidationPasswordLogin = loginAndRegisterPage.toolTipsValidationPasswordLogin();

        if(emailLogin.trim().isEmpty()){
            assert toolTipsValidationEmailLogin.equals("Please fill in this field.");
            test.pass("Tooltip validation message displayed : "+toolTipsValidationEmailLogin);

        } else if (passwordLogin.trim().isEmpty()){
            assert toolTipsValidationPasswordLogin.equals("Please fill in this field.");
            test.pass("Tooltip validation message displayed : "+toolTipsValidationPasswordLogin);
        } else if (!passwordLogin.trim().isEmpty() && !emailLogin.trim().isEmpty()){
            loginAndRegisterPage.verifyIncorrectLogin();
            test.pass("Information message displayed : Your email or password is incorrect!");
        } else {
            test.fail("Locator is not defined");

        }

    }

}
