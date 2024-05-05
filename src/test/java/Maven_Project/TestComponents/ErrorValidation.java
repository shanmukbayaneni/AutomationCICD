package Maven_Project.TestComponents;

import Maven_Project.*;
import Maven_Project.TestComponents.Testcomponents.RetryListener;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidation extends Base
{
   @Test(groups = {"ErrorHandling"},retryAnalyzer = RetryListener.class)
    public void LoginError() throws IOException, InterruptedException {

        landingpage.loginApplication("shanmukbayaneni@gmail.com","Shannu123");
        Assert.assertEquals("Incorrect email or password.",landingpage.getErrorMessage());
    }

    @Test
    public void ProductErrorValidation() throws IOException,InterruptedException
    {
        String productName="IPHONE 13 PRO";
        ProductCatalogue productCatalogue= landingpage.loginApplication("jimmu@gmail.com","Shannu123");
        List<WebElement> products=productCatalogue.getproductList();
        //List<WebElement> products=productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartPage= productCatalogue.goToCartPage();

        Boolean match=cartPage.VerifyProductDisplay(productName);
        Assert.assertFalse(match);
    }
}
