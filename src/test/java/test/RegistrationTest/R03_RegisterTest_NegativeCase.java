package test.RegistrationTest;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePages.HomePage;
import pages.HomePages.LoginAndRegisterPage;
import pages.RegistrationPages.RegistrationPage;
import pages.RegistrationPages.ToolTipsValidationRegistrationPage;
import utils.ExcelUtils;

public class R03_RegisterTest_NegativeCase extends BaseTest {

    @DataProvider(name = "NegativeCaseInputRegisterForm")
    public Object[][] getR03_RegisterTest_NegativeCase(){
        return ExcelUtils.readExcel("D:\\QA\\eCommerceTEsting_automationexercise.com\\src\\testdata\\LoginForm.xlsx","Sheet2");
    }

    @Test(dataProvider = "NegativeCaseInputRegisterForm",priority = 1)
    public void RegisterTest_NegativeCase(String usernameForReg, String emailForReg, String nameRegistration,String passwordRegistration,String dayRegistration,String monthRegistration,String yearRegistration,String fistNameReg,String lastNameReg,String companyReg, String addresReg, String secondAddresReg,String countryReg,String stateReg,String cityReg,String zipcodeReg,String mobileNumberReg){

        if(passwordRegistration.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration : Password field is blank");

        } else if (fistNameReg.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration : First field name is blank");

        }else if (lastNameReg.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration : Last name field is blank");

        }else if (addresReg.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration : Address field is blank");

        }else if (stateReg.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration : State field is blank");

        }else if (cityReg.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration : City field is blank");


        } else if (zipcodeReg.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration : Zipcode field is blank");

        } else if (mobileNumberReg.trim().isEmpty()){
            test = extent.createTest("Negative Case Registration : Mobile number field is blank");

        } else {
            test = extent.createTest("Negative Case Registration : Invalid registration data provided");

        }


        HomePage homePage = new HomePage(driver, test);
        homePage.goToLoginRegister();
        test.pass("Clicked on 'Signup / Login' button");

        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver, test);
        loginAndRegisterPage.verifyLoginReg();
        test.pass("Verified 'New User Signup!' is visible");

        loginAndRegisterPage.userNameRegister(usernameForReg);
        loginAndRegisterPage.emailRegister(emailForReg);
        test.pass("Entered name: " + usernameForReg + " and email: " + emailForReg);

        loginAndRegisterPage.signUpButton();
        test.pass("Clicked on 'Signup' button");

        RegistrationPage registrationPage = new RegistrationPage(driver, test);
        registrationPage.verifyRegistrationPage();
        test.pass("Verified that 'ENTER ACCOUNT INFORMATION' section is visible");

        registrationPage.checkBoxRegistrationTitleMR();
        registrationPage.nameRegistration(nameRegistration);
        registrationPage.emailRegistration(emailForReg);
        registrationPage.passwordRegistration(passwordRegistration);
        registrationPage.dayRegistration(dayRegistration);
        registrationPage.monthRegistration(monthRegistration);
        registrationPage.yearRegistration(yearRegistration);
        test.pass("Filled in contact details: First Name: " + fistNameReg + ", Last Name: " + lastNameReg + ", Company: " + companyReg + ", Address: " + addresReg + ", Address 2: " + secondAddresReg + ", Country: " + countryReg + ", State: " + stateReg + ", City: " + cityReg + ", Zip Code: " + zipcodeReg + ", Mobile Number: " + mobileNumberReg);

        registrationPage.checkBoxNewsletterRegistration();
        test.pass("Select checkbox 'Sign up for our newsletter!");

        registrationPage.checkBoxOptionRegistration();
        test.pass("Select checkbox 'Receive special offers from our partners!");

        registrationPage.firstNameRegistration(fistNameReg);
        registrationPage.lastNameRegistration(lastNameReg);
        registrationPage.companyRegistration(companyReg);
        registrationPage.addressRegistration(addresReg);
        registrationPage.secondAddressRegistration(secondAddresReg);
        registrationPage.countryRegistration(countryReg);
        registrationPage.stateRegistration(stateReg);
        registrationPage.cityRegistration(cityReg);
        registrationPage.zipcodeRegistration(zipcodeReg);
        registrationPage.mobileNumberRegistration(mobileNumberReg);
        test.pass("Fill details: First name "+fistNameReg+", Last name "+fistNameReg+", Company "+companyReg+", Address "+addresReg+", Address2 "+secondAddresReg+", Country "+countryReg+", State "+stateReg+", City "+cityReg+", Zipcode "+zipcodeReg+", Mobile Number "+mobileNumberReg);

        registrationPage.buttonCreateAccountRegistration();
        test.pass("Click 'Create Account button");

        ToolTipsValidationRegistrationPage toolTipsValidationRegistrationPage = new ToolTipsValidationRegistrationPage(driver,test);

        if(passwordRegistration.trim().isEmpty()){
            String passwordReg = toolTipsValidationRegistrationPage.passwordRegistrationToolTipsValidation();

            assert passwordReg.equals("Please fill in this field.");
            test.pass("Displayed tooltip message : " + passwordReg);

        } else if (fistNameReg.trim().isEmpty()){
            String fistNameRegg = toolTipsValidationRegistrationPage.firstNameRegistrationToolTipsValidation();

            assert fistNameRegg.equals("Please fill in this field.");
            test.pass("Displayed tooltip message: " + fistNameReg);

        }else if (lastNameReg.trim().isEmpty()){
            String lastNameRegg = toolTipsValidationRegistrationPage.lastNameRegistrationToolTipsValidation();

            assert lastNameRegg.equals("Please fill in this field.");
            test.pass("Displayed tooltip message: " + lastNameRegg);

        }else if (addresReg.trim().isEmpty()){
            String addresRegg = toolTipsValidationRegistrationPage.addressRegistrationToolTipsValidation();

            assert addresRegg.equals("Please fill in this field.");
            test.pass("Displayed tooltip message: " + addresRegg);

        }else if (stateReg.trim().isEmpty()){
            String stateRegg = toolTipsValidationRegistrationPage.stateRegistrationToolTipsValidation();

            assert stateRegg.equals("Please fill in this field.");
            test.pass("Displayed tooltip message: " + stateRegg);

        }else if (cityReg.trim().isEmpty()){
            String cityRegg = toolTipsValidationRegistrationPage.cityRegistrationToolTipsValidation();

            assert cityRegg.equals("Please fill in this field.");
            test.pass("Displayed tooltip message: " + cityRegg);

        } else if (zipcodeReg.trim().isEmpty()){
            String zipcodeRegg = toolTipsValidationRegistrationPage.zipcodeRegistrationToolTipsValidation();

            assert zipcodeRegg.equals("Please fill in this field.");
            test.pass("Displayed tooltip message: " + zipcodeRegg);

        } else if (mobileNumberReg.trim().isEmpty()){
            String mobileNumberRegg = toolTipsValidationRegistrationPage.mobileNumberRegistrationToolTipsValidation();

            assert mobileNumberRegg.equals("Please fill in this field.");
            test.pass("Displayed tooltip message: " + mobileNumberRegg);

        } else {
            test.pass("Negative Case Registration : Invalid input registration form");

        }

    }

}
