package pages.ProductDetailPages;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {
    WebDriver driver;
    ExtentTest test;

    public ProductDetailPage(WebDriver driver, ExtentTest test){
        this.driver = driver;
        this.test = test;
    }

    public void verifyProductDetailPage(){
        driver.findElement(By.xpath("//h2[normalize-space()='All Products']")).isDisplayed();
    }

    public void verifyProductList(){
        driver.findElement(By.xpath("//div[@class='features_items']")).isDisplayed();
    }

    public void clickDetail(String nameProduct){
        WebElement locator =  driver.findElement(By.xpath("//p[text()='"+nameProduct+"']/ancestor::div[@class='product-image-wrapper']//a[contains(text(),'View Product')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", locator);
        locator.click();
    }


    public void nameProducts(String nameProduct){
        driver.findElement(By.xpath("//h2[normalize-space()='"+nameProduct+"']"));
    }

    public void categoryProducts(String categoryProduct){
        driver.findElement(By.xpath("//p[normalize-space()='Category: "+categoryProduct+"']")).isDisplayed();
    }

    public void availableDetailProduct(){
        driver.findElement(By.xpath("//div[@class='product-details']//p[1]")).isDisplayed();

    }

    public void conditionDetailProduct(){
        driver.findElement(By.xpath("//b[normalize-space()='Condition:']")).isDisplayed();
    }

    public void brandDetailProduct(){
        driver.findElement(By.xpath("//b[normalize-space()='Brand:']")).isDisplayed();

    }

    public void priceDetailProducts(String priceDetailProduct){
        driver.findElement(By.xpath("//span[normalize-space()='Rs. "+priceDetailProduct+"']")).click();
    }


}
