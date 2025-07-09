package test.TestCasepageTest;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePages.HomePage;
import pages.TestCasePages.TestCasePage;

public class TestCaseTestPage extends BaseTest {

    @Test(priority = 1)
    public void TestCaseTestPage (){
        test = extent.createTest("Positif Case Test Cases Page : Verifed Test Case Page  ");


        HomePage homePage = new HomePage(driver, test);
        homePage.goToCasePage();
        test.pass("Navigated to the Test Cases page successfully");
        TestCasePage testCasePage = new TestCasePage(driver, test);
        test.pass("Verified that Test Cases page is displayed correctly");

    }


}
