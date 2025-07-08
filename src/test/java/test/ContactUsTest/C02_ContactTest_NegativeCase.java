package test.ContactUsTest;

import base.BaseTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactUsPages.ContactUsPage;
import pages.HomePages.HomePage;
import pages.HomePages.LoginAndRegisterPage;
import utils.ExcelUtils;
import utils.ValidationEmail;

public class C02_ContactTest_NegativeCase extends BaseTest {

    @DataProvider(name = "NegativeCaseData")
    public Object[][] getContactTest_NegativeCase(){
        return ExcelUtils.readExcel("D:\\QA\\eCommerceTEsting_automationexercise.com\\src\\testdata\\ContactUs.xlsx","Sheet2");
    }

    @Test(dataProvider = "NegativeCaseData", priority = 1)
    public void C02_ContactTest_NegativeCase(String name, String email, String subject, String message, String uploadFile, String confirmAlert) {

        if (name.trim().isEmpty()) {
            test = extent.createTest("Contact Us Negative Case: Name fields are blank");
        } else if (email.trim().isEmpty()) {
            test = extent.createTest("Contact Us Negative Case: Email fields are blank");
        } else if (message.trim().isEmpty()) {
            test = extent.createTest("Contact Us Negative Case: Email fields are blank");
        }    else if (uploadFile.trim().isEmpty()) {
            test = extent.createTest("Contact Us Negative Case: Email fields are blank");

        }


        try{

            ContactUsPage contactUsPage = new ContactUsPage(driver, test);
            HomePage homePage = new HomePage(driver, test);
            homePage.verifyHomePage();
            test.pass("Successfully landed on the Home Page");

            homePage.goToContactUsPage();
            test.pass("Navigated to the Contact Us Page");

            contactUsPage.verifyContactUsPage();
            test.pass("Contact Us Page is displayed correctly");

            LoginAndRegisterPage loginAndRegisterPage = new LoginAndRegisterPage(driver, test);
            loginAndRegisterPage.userNameRegister(name);
            test.pass("Entered name into the Name field");

            contactUsPage.emailField(email);
            test.pass("Entered email into the Email field");

            contactUsPage.subjectField(subject);
            test.pass("Entered subject into the Subject field");

            contactUsPage.messageField(message);
            test.pass("Entered message into the Message field");

            contactUsPage.uploadFileField(uploadFile);
            test.pass("Uploaded file successfully");

            contactUsPage.buttonSubmit();
            test.pass("Clicked the Submit button");


            if(!email.trim().isEmpty()){
                contactUsPage.confirmAlert(confirmAlert);
            }

            String nameMessage = loginAndRegisterPage.toolTipsValidationUsername();
            String emailMessage = contactUsPage.emailToolTipValidationContactUs();
            String subjectMessage = contactUsPage.subjectToolTipValidation();
            String messageMessage = contactUsPage.messageToolTipValidation();

                if (email.trim().isEmpty()) {
                    Assert.assertEquals(emailMessage, "Please fill in this field.");
                    test.pass("Displayed tooltip message: "+emailMessage);

                } else if (!email.contains("@")) {
                    Assert.assertEquals(emailMessage, "Please include an '@' in the email address. '"+email+"' is missing an '@'.");
                    test.pass("Displayed tooltip message: "+emailMessage);

                } else if(email.endsWith(".")){
                    Assert.assertEquals(emailMessage, "'.' is used at a wrong position in '"+email.substring(email.indexOf("@")+1)+"'.");
                    test.pass("Displayed tooltip message: "+emailMessage);

                }else if (!email.startsWith("@")) {
                    Assert.assertEquals(emailMessage, "Please enter a part followed by '@'. '"+email+"' is incomplete.");
                    test.pass("Displayed tooltip message: "+emailMessage);

                }  else if(!ValidationEmail.validationEmail(email)){
                    Assert.assertEquals(message, "Please enter a part followed by '@'. '"+email+"' is incomplete.");
                    test.pass("Displayed tooltip message: "+emailMessage);
                } else if (name.trim().isEmpty()){
                    Assert.assertEquals(nameMessage, "Please fill in this field.");
                    test.pass("Displayed tooltip message: "+ nameMessage);

                } else if(subject.trim().isEmpty()){
                    Assert.assertEquals(subjectMessage, "Please fill in this field.");
                    test.pass("Displayed tooltip message: "+subjectMessage);

                } else if (message.trim().isEmpty()) {
                    Assert.assertEquals(messageMessage, "Please fill in this field.");
                    test.pass("Displayed tooltip message: "+messageMessage);

                }


        } catch (NoSuchElementException e) {
            test.fail("Element not found: " + e.getMessage());
            throw e;
        } catch (AssertionError e) {
            test.fail("Validation failed: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            test.fail("Unexpected error: " + e.getMessage());
            throw new RuntimeException(e);
        }


    }}



