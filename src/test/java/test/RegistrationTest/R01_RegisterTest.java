package test.RegistrationTest;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePages.HomePage;
import pages.HomePages.LoginAndRegisterPage;
import pages.RegistrationPages.RegistrationPage;
import utils.ExcelUtils;


public class R01_RegisterTest extends BaseTest {

    @DataProvider(name = "loginRegister")
    public Object[][] getLoginRegister() {
        return ExcelUtils.readExcel("D:\\QA\\e-commerceTesting\\src\\testdataD:\\QA\\eCommerceTEsting_automationexercise.com\\src\\testdata\\RegisterForm.xlsx","Sheet1");
    }


    @Test(dataProvider = "loginRegister",priority = 1)
    public void RegisterTest(String usernameForReg, String emailForReg, String nameRegistration,String passwordRegistration,String dayRegistration,String monthRegistration,String yearRegistration,String fistNameReg,String lastNameReg,String companyReg, String addresReg, String secondAddresReg,String countryReg,String stateReg,String cityReg,String zipcodeReg,String mobileNumberReg){
    test = extent.createTest("Positive Case Registration: Successfully registered user with valid input data");

        HomePage homePage = new HomePage(driver, test);
        homePage.goToLoginRegister();
        test.pass("Clicked on 'Signup / Login' button");


        LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver, test);
        loginAndRegisterPage.verifyLoginReg();
        test.pass("Verified that 'New User Signup!' is visible");

        loginAndRegisterPage.userNameRegister(usernameForReg);
        loginAndRegisterPage.emailRegister(emailForReg);
        test.pass("Entered username: "+usernameForReg+" and email address: " + emailForReg);

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
        test.pass("Filled account details: Title, Name: " + nameRegistration + ", Email: " + emailForReg + ", Password: " + passwordRegistration + ", DOB: " + dayRegistration + "/" + monthRegistration + "/" + yearRegistration);

        registrationPage.checkBoxNewsletterRegistration();
        test.pass("Selected checkbox 'Sign up for our newsletter!'");

        registrationPage.checkBoxOptionRegistration();
        test.pass("Selected checkbox 'Receive special offers from our partners!'");

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
        test.pass("Filled address details: First Name: " + fistNameReg + ", Last Name: " + lastNameReg + ", Company: " + companyReg + ", Address: " + addresReg + ", Address 2: " + secondAddresReg + ", Country: " + countryReg + ", State: " + stateReg + ", City: " + cityReg + ", Zipcode: " + zipcodeReg + ", Mobile: " + mobileNumberReg);

        registrationPage.buttonCreateAccountRegistration();
        test.pass("Clicked on 'Create Account' button");

        registrationPage.verifyCreate();
        test.pass("Verified that 'ACCOUNT CREATED!' is visible");

        registrationPage.buttonContinueRegistration();
        test.pass("Clicked 'Continue' button");

        homePage.verifyUserCreatedLogin(nameRegistration);
        test.pass("Verified that 'Logged in as "+nameRegistration+"'is visible");

    }

}
