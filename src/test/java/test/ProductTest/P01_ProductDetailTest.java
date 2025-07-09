package test.ProductTest;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePages.HomePage;
import pages.ProductDetailPages.ProductDetailPage;

public class P01_ProductDetailTest extends BaseTest {

    @DataProvider(name = "productDetailData")
    public Object[][] getProductDetailData(){
        return new Object[][] {
                {"Blue Top","Women > Tops","500"}
        };
    }

    @Test(dataProvider = "productDetailData",priority = 1)
    public void ProductDetailTest(String nameProduct, String categoryProduct, String price){

        test = extent.createTest("Positive Case Product Detail: Verify product details are displayed correctly");

        HomePage homePage = new HomePage(driver, test);
        homePage.goToProductPage();
        test.pass("Clicked on 'Products' button");

        ProductDetailPage productDetailPage = new ProductDetailPage(driver, test);
        productDetailPage.verifyProductDetailPage();
        test.pass("User is navigated to the 'ALL PRODUCTS' page successfully");

        productDetailPage.verifyProductList();
        test.pass("Product list is visible on the page");

        productDetailPage.clickDetail(nameProduct);
        test.pass("Clicked on 'View Product' for the selected product: " + nameProduct);

        productDetailPage.nameProducts(nameProduct);
        test.pass("Verified product name: " + nameProduct);

        productDetailPage.categoryProducts(categoryProduct);
        test.pass("Verified product category: " + categoryProduct);

        productDetailPage.priceDetailProducts(price);
        test.pass("Verified product price: " + price);

        productDetailPage.availableDetailProduct();
        test.pass("Verified product availability status");

        productDetailPage.conditionDetailProduct();
        test.pass("Verified product condition");

        productDetailPage.brandDetailProduct();
        test.pass("Verified product brand");

    }

}
