package test.HomeTest;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePages.HomePage;

public class H01_HomeTest extends BaseTest {
    @Test(priority = 1)
    public void homePageTest (){
        test = extent.createTest("Positive Case : Home Page");
        test.pass("Launch browser");

        HomePage homePage = new HomePage(driver, test);

        test.pass("Navigate to url 'http://automationexercise.com'");
        homePage.verifyHomePage();
        test.pass("Verify that home page is visible successfully");

    }
}
