package test.RegistrationTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePages.HomePage;
import pages.HomePages.LoginAndRegisterPage;
import utils.ExcelUtils;
import utils.ValidationEmail;

public class R02_RegisterTest_NegativeCase extends BaseTest {

    @DataProvider(name = "invalidRegisterData")
    public Object[][] getInvalidRegisterData(){
        return ExcelUtils.readExcel("D:\\QA\\eCommerceTEsting_automationexercise.com\\src\\testdata\\LoginRegister.xlsx","Sheet1");
    }

    @DataProvider(name = "invalidEmailRegisterData")
    public Object[][] getInvalidEmailRegisterData(){
        return ExcelUtils.readExcel("D:\\QA\\eCommerceTEsting_automationexercise.com\\src\\testdata\\LoginRegister.xlsx","Sheet2");
    }




    @Test(dataProvider = "invalidRegisterData",priority = 1)
    public void registerTest_NegativeCase (String usernameForReg, String emailForReg){

        if(!usernameForReg.trim().isEmpty() && !emailForReg.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration : input username and email already exist ");

        } else if(usernameForReg.trim().isEmpty() && emailForReg.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration: Username and email fields are blank");

        } else if(usernameForReg.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration: Username is blank and email is valid");

        } else if (emailForReg.trim().isEmpty()) {
            test = extent.createTest("Negative Case Registration: Username is valid and email is blank");

        }

        HomePage homePage = new HomePage(driver, test);
        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver, test);

        homePage.goToLoginRegister();
        test.pass("Browser launched successfully");

        loginAndRegisterPage.userNameRegister(usernameForReg);
        test.pass("Entered registration username: " + usernameForReg);

        loginAndRegisterPage.emailRegister(emailForReg);
        test.pass("Enter name: "+usernameForReg+" and email address: "+emailForReg+"");

        loginAndRegisterPage.signUpButton();
        test.pass("Clicked button Sign in");

        String toolTipMessageUsername = loginAndRegisterPage.toolTipsValidationUsername();
        String toolTipMessageEmail = loginAndRegisterPage.toolTipsValidationEmail();

        if(usernameForReg.trim().isEmpty()){
            assert toolTipMessageUsername.equals("Please fill in this field.");
            test.pass("Displayed tooltip message: " + toolTipMessageUsername);

        } else if (emailForReg.trim().isEmpty()) {
            assert toolTipMessageEmail.equals("Please fill in this field.");
            test.pass("Displayed tooltip message: " + toolTipMessageUsername);

        }
        else if(!usernameForReg.trim().isEmpty() && !emailForReg.trim().isEmpty()) {
            loginAndRegisterPage.verifyEmailIsReadyExist();
            test.pass("Displayed message: 'Email Address already exists!'");

        }
        else {
            test.fail("Message validation failed or did not appear as expected");
        }
    }

    @Test(dataProvider = "invalidEmailRegisterData",priority = 2)
    public void InvalidEmailRegisterData(String userNameForReg, String emailForReg ){

        test = extent.createTest("Negative Case Registration : input valid username and invalid email");

        ValidationEmail validationEmail = new ValidationEmail();

        HomePage homePage = new HomePage(driver, test);
        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver, test);

        homePage.goToLoginRegister();

        try{
                loginAndRegisterPage.userNameRegister(userNameForReg);
                test.pass("Login with input username : " +userNameForReg);

                loginAndRegisterPage.emailRegister(emailForReg);
                test.pass("Login with input email : " +emailForReg);

                loginAndRegisterPage.signUpButton();
                test.pass("Click button Sign in");

            String message = loginAndRegisterPage.toolTipsValidationEmail();
                System.out.println("Validation: " + message);

                if (emailForReg.trim().isEmpty()) {
                    Assert.assertEquals(message, "Please fill in this field.");
                    test.pass("Displayed tooltip message: "+message);

                } else if (!emailForReg.contains("@")) {
                    Assert.assertEquals(message, "Please include an '@' in the email address. '"+emailForReg+"' is missing an '@'.");
                    test.pass("Displayed tooltip message: "+message);

                } else if(emailForReg.endsWith(".")){
                    Assert.assertEquals(message, "'.' is used at a wrong position in '"+emailForReg.substring(emailForReg.indexOf("@")+1)+"'.");
                    test.pass("Displayed tooltip message: "+message);

                }else if (!emailForReg.startsWith("@")) {
                     Assert.assertEquals(message, "Please enter a part followed by '@'. '"+emailForReg+"' is incomplete.");
                    test.pass("Displayed tooltip message: "+message);

                }  else if(!ValidationEmail.validationEmail(emailForReg)){
                    Assert.assertEquals(message, "Please enter a part followed by '@'. '"+emailForReg+"' is incomplete.");
                    test.pass("Displayed tooltip message: "+message);
                }

        } catch (org.openqa.selenium.NoSuchElementException e){
            test.fail("Tooltip message validation failed or did not appear as expected");
        }
    }
}
