package pages.HomePages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginAndRegisterPage {

    public WebDriver driver;
    public ExtentTest test;

    public LoginAndRegisterPage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
    }

    public void verifyLoginReg(){
        String actualExpect = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).getText();
        String resultExpect = "Login to your account";
        Assert.assertEquals(actualExpect, resultExpect);
    }

    //REGISTER
    public By userNameRegister(String usernameForReg){
        WebElement locator = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        locator.sendKeys(usernameForReg);
        return null;
    }

    public void emailRegister(String emailForReg){
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys(emailForReg);
    }

    public void signUpButton(){
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
    }


    //LOGIN
    public void emailLogin(String emailForLogin){
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys(emailForLogin);
    }

    public void passwordLogin(String passwordForLogin){
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(passwordForLogin);
    }

    public void loginButton(){
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }

    public void verifyInvalidLogin(){
        String expectedResult = "Your email or password is incorrect!".toLowerCase();
        String actualResult = String.valueOf(driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).getText().toLowerCase());
        Assert.assertEquals(actualResult, expectedResult);
    }


    public String toolTipsValidationUsername(){

        WebElement locator = driver.findElement(By.xpath("//input[@placeholder='Name']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", locator);

    }

    public String toolTipsValidationEmail(){
        WebElement locator = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }


    public void verifyIncorrectLogin(){
        String actualExpected = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).getText();
        String resultExpected = "Your email or password is incorrect!";

        Assert.assertEquals(actualExpected, resultExpected);
    }


    public String toolTipsValidationEmailLogin(){
        WebElement locator = driver.findElement(By.xpath("//input[@data-qa='login-email']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage",locator);
    }

    public String toolTipsValidationPasswordLogin(){
        WebElement locator = driver.findElement(By.xpath("//input[@placeholder='Password']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }

    public void verifyEmailIsReadyExist(){
        String actualResult = String.valueOf(driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']"))).toLowerCase();
        String expectedResult = "Email Address already exist!".toLowerCase();
        Assert.assertEquals(actualResult, expectedResult);
    }

    public void verifyUserNameIsReadyExist(){
        String actualResult = String.valueOf(driver.findElement(By.xpath("//p[normalize-space()='Username already exist!']"))).toLowerCase();
        String expectedResult = "Username already exist!".toLowerCase();
        Assert.assertEquals(actualResult, expectedResult);
    }

}
