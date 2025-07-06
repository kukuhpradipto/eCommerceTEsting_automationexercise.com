package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.ExtentRaportManager;

public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReport(){
        extent = ExtentRaportManager.getReporter();
    }


    @BeforeMethod
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String URL = "https://automationexercise.com/";
        driver.get(URL);
    }


    @AfterMethod
    public void tearDownBrowser() throws InterruptedException {
      Thread.sleep(3000);
      driver.quit();
    }



    @AfterSuite
    public void flushReport(){
        extent.flush();
    }

}
