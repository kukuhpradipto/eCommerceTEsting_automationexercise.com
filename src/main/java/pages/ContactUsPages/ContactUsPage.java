package pages.ContactUsPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.*;

import java.util.Objects;

public class ContactUsPage {
    WebDriver driver;
    ExtentTest test;

    public ContactUsPage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
    }

    public void verifyContactUsPage(){
        driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']")).isDisplayed();
    }

    public void buttonGoToHome(){
        driver.findElement(By.xpath("//a[@class='btn btn-success']")).click();
    }

    public void verifySuccessSubmit(){
        driver.findElement(By.xpath("//div[@class='status alert alert-success']")).isDisplayed();
    }

    public void emailField(String inputEmail){
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(inputEmail);
    }

    public void subjectField(String subjectInput){
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(subjectInput);
    }

    public void messageField(String messageInput){
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(messageInput);
    }

    public void uploadFileField(String fileUploaded){
        WebElement uploadFile = driver.findElement(By.xpath("//input[@name='upload_file']"));
        uploadFile.sendKeys(fileUploaded);
    }

    public void buttonSubmit(){
        driver.findElement(By.xpath("//input[@name='submit']")).click();
    }


    public void confirmAlert(String confirmation){
        Alert alert = driver.switchTo().alert();
        if(Objects.equals(confirmation, "Accept")){
            alert.accept();
        } else if (Objects.equals(confirmation, "Cancel")) {
            alert.dismiss();
        }

    }


      public String emailToolTipValidationContactUs(){
        WebElement locator =  driver.findElement(By.xpath("//input[@placeholder='Email']"));

          JavascriptExecutor js = (JavascriptExecutor) driver;
          return (String) js.executeScript("return arguments[0].validationMessage",locator);


      }

    public String subjectToolTipValidation(){
       WebElement locator =  driver.findElement(By.xpath("//input[@placeholder='Subject']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);

    }

    public String messageToolTipValidation(){

        WebElement locator =  driver.findElement(By.xpath("//textarea[@id='message']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage", locator);
    }





}
