package pages.RegistrationPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistrationPage {
    public WebDriver driver;
    public ExtentTest test;


    public RegistrationPage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
    }


    public void verifyRegistrationPage(){
        String resultExpect = driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).getText();
        String actualExpect = "ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(actualExpect, resultExpect);

    }

    public void checkBoxRegistrationTitleMR(){
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
    }

    public void checkBoxRegistrationTitleMRS(){
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
    }

    public void nameRegistration(String nameRegistration){
    WebElement nameReg =  driver.findElement(By.id("name"));
    nameReg.clear();
    nameReg.sendKeys(nameRegistration);
    }

    public void emailRegistration(String emailForReg){
        String emailReg = driver.findElement(By.id("email")).getAttribute("value");
        Assert.assertEquals(emailReg, emailForReg);
    }

    public void passwordRegistration(String passwordRegistration){
    driver.findElement(By.id("password")).sendKeys(passwordRegistration);
    }

    public void dayRegistration(String dayRegistration){
        Select dayReg = new Select(driver.findElement(By.id("days")));
        dayReg.selectByVisibleText(dayRegistration);
    }

    public void monthRegistration(String monthRegistration){
        Select monthReg = new Select(driver.findElement(By.id("months")));
        monthReg.selectByVisibleText(monthRegistration);
    }

    public void yearRegistration(String yearRegistration){
        Select yearReg = new Select(driver.findElement(By.id("years")));
        yearReg.selectByVisibleText(yearRegistration);
    }

    public void checkBoxNewsletterRegistration(){
        driver.findElement(By.id("newsletter")).click();
    }

    public void checkBoxOptionRegistration(){
        driver.findElement(By.id("optin")).click();
    }

    public void firstNameRegistration(String fistNameReg){
        driver.findElement(By.id("first_name")).sendKeys(fistNameReg);
    }

    public void lastNameRegistration(String lastNameReg){
        driver.findElement(By.id("last_name")).sendKeys(lastNameReg);
    }

    public void companyRegistration(String companyReg){
        driver.findElement(By.id("company")).sendKeys(companyReg);
    }

    public void addressRegistration(String addresReg){
        driver.findElement(By.id("address1")).sendKeys(addresReg);
    }

    public void secondAddressRegistration(String secondAddresReg){
        driver.findElement(By.id("address2")).sendKeys(secondAddresReg);
    }

    public void countryRegistration(String countryReg){
        Select countryRegg = new Select(driver.findElement(By.id("country")));
        countryRegg.selectByVisibleText(countryReg);
    }

    public void stateRegistration(String stateReg){
        driver.findElement(By.id("state")).sendKeys(stateReg);
    }

    public void cityRegistration(String cityReg){
        driver.findElement(By.id("city")).sendKeys(cityReg);
    }

    public void zipcodeRegistration(String zipcodeReg){
        driver.findElement(By.id("zipcode")).sendKeys(zipcodeReg);
    }

    public void mobileNumberRegistration(String mobileNumberReg){
        driver.findElement(By.id("mobile_number")).sendKeys(mobileNumberReg);

    }

    public void buttonCreateAccountRegistration(){
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
    }

    public void verifyCreate(){
        String actualVerifyCreated = String.valueOf(driver.findElement(By.xpath("//b[normalize-space()='Account Created!']")).getText().toLowerCase());
        String expectedVerifyCreated = "account created!";
    }

    public void buttonContinueRegistration(){
        driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
    }





}
