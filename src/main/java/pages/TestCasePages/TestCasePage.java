package pages.TestCasePages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage {
    WebDriver driver;
    ExtentTest test;

    public TestCasePage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
    }


    public void verifyTestCasePage(){
        driver.findElement(By.xpath("//b[normalize-space()='Test Cases']")).isDisplayed();
    }


}
