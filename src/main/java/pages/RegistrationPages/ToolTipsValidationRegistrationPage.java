package pages.RegistrationPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ToolTipsValidationRegistrationPage {

    WebDriver driver;
    ExtentTest test;

    public ToolTipsValidationRegistrationPage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
    }

    public String passwordRegistrationToolTipsValidation(){
        WebElement locator = driver.findElement(By.id("password"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }

    public String firstNameRegistrationToolTipsValidation(){
        WebElement locator = driver.findElement(By.id("first_name"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }

    public String lastNameRegistrationToolTipsValidation(){
        WebElement locator = driver.findElement(By.id("last_name"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }

    public String addressRegistrationToolTipsValidation( ){
        WebElement locator = driver.findElement(By.id("address1"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }

    public String stateRegistrationToolTipsValidation( ){
        WebElement locator = driver.findElement(By.id("state"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }

    public String cityRegistrationToolTipsValidation( ){
        WebElement locator = driver.findElement(By.id("city"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }

    public String zipcodeRegistrationToolTipsValidation( ){
        WebElement locator = driver.findElement(By.id("zipcode"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }

    public String mobileNumberRegistrationToolTipsValidation( ){
        WebElement locator = driver.findElement(By.id("mobile_number"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }

}
