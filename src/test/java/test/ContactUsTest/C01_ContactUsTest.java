package test.ContactUsTest;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ContactUsPages.ContactUsPage;
import pages.HomePages.HomePage;
import pages.HomePages.LoginAndRegisterPage;
import utils.ExcelUtils;

public class C01_ContactUsTest extends BaseTest {

    @DataProvider(name = "ContactUsData")
    public Object[][] getContactUsData(){
       return ExcelUtils.readExcel("D:\\QA\\eCommerceTEsting_automationexercise.com\\src\\testdata\\ContactUs.xlsx","Sheet1");
    }

    @Test(dataProvider = "ContactUsData", priority = 1)
    public void contactUsTest(String name, String email, String subject, String message, String uploadFile,String alert){

        if ("Accept".equals(alert)) {
            test = extent.createTest("Contact Us Positive Case: Submit form with valid data and confirm alert (OK)");
        } else if ("Cancel".equals(alert)){
            test = extent.createTest("Contact Us Positive Case: Submit form with valid data and dismiss alert (Cancel)");
        }

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
        contactUsPage.confirmAlert(alert);

        if ("Accept".equals(alert)) {
            test.pass("Submission confirmed via alert (OK)");

            contactUsPage.verifySuccessSubmit();
            test.pass("Success message is displayed");

            contactUsPage.buttonGoToHome();
            test.pass("Clicked 'Go to Home' and navigated back successfully");

        } else if ("Cancel".equals(alert)){
            test.pass("Submission cancelled via alert (Cancel)");

            contactUsPage.verifyContactUsPage();
            test.pass("Still on Contact Us Page after dismissing alert");
        }

       }
}
