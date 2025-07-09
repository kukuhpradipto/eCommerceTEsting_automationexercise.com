package pages.HomePages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    WebDriver driver;
    ExtentTest test;

    public HomePage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;

    }

    public void goToLoginRegister(){
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
    }

    public void verifyHomePage(){
        String actualExpect = String.valueOf(driver.findElement(By.linkText("Home")).getText());
        String resultExpect = "Home";
        Assert.assertEquals(actualExpect,resultExpect);
    }

    public void goToCart(){
        driver.findElement(By.linkText("Cart")).click();

    }

    public void goToHome(){
        driver.findElement(By.linkText("Home")).click();

    }

    public void verifyUserCreatedLogin(String userCreatedLogin){
        driver.findElement(By.xpath("//b[normalize-space()='"+userCreatedLogin+"']"));
    }

    public void deleteAccountRegistration(){
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
    }


    public void verifyDeleteAccountRegistration(){
        String ActualDeleteAccount = String.valueOf(driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).getText().toLowerCase());
        String expectedDeleteAccount = "Account Deleted!".toLowerCase();
    }

    public void buttonToLogout (){
        driver.findElement(By.xpath("//a[normalize-space()='Logout']")).click();
    }

    public void verifyButtonToLogoutNotDisplay (){
        Assert.assertTrue(driver.findElements(By.xpath("//a[normalize-space()='Logout']")).isEmpty(),"Element should not be visible");
    }

    public void goToContactUsPage(){
        driver.findElement(By.xpath("//a[normalize-space()='Contact us']")).click();

    }


    public void goToCasePage(){
        driver.findElement(By.xpath("//a[normalize-space()='Test Cases']")).click();
    }

    public void goToProductPage(){
        driver.findElement(By.xpath("//a[@href='/products']")).click();
    }


}
