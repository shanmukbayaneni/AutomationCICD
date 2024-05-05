package Maven_Project.AbstractComponents;

import Maven_Project.TestComponents.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Final extends Base {
    String productname = "IPHONE 13 PRO";

    @Test
    public void submitOrder() throws IOException, InterruptedException {

        ProductCatalogue productCatalogue = landingpage.loginApplication("shanmukbayaneni@gmail.com", "Shannu123");

        List<WebElement> products = productCatalogue.getproductList();
        productCatalogue.addProductToCart(productname);
        CartPage cartPage = productCatalogue.goToCartPage();

        Boolean match = cartPage.VerifyProductDisplay(productname);
        Assert.assertTrue(match);
        CheckOutPage checkoutpage = cartPage.goToCheckout();
        checkoutpage.selectCountry("india");
        //Thread.sleep(5000);
        ConfirmationPage confirmationPage = checkoutpage.submitOrder();
        String confirmationmessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmationmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }
}
