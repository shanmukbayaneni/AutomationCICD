package Maven_Project.StepDefinition;

import Maven_Project.TestComponents.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class StepDefinition extends Base
{
    public LandingPage landingPage;

    public  ProductCatalogue productCatalogue;

    public CheckOutPage checkoutpage ;

    public ConfirmationPage confirmationPage;


    @Given("I landed on Ecommerce page")
    public void I_landed_on_Ecommerce_page() throws IOException
    {
        landingPage = launchapplication();
        //throw new io.cucumber.java.PendingException();
    }

    @Given("^Logged in with username (.+) and password (.+)$")
    public void Logged_in_with_username_and_password(String username , String password)
    {
        productCatalogue=landingpage.loginApplication(username, password);
    }

    @When("^I add product (.+) to cart$")
    public void I_add_product_to_cart(String productname) throws InterruptedException
    {
        List<WebElement> products = productCatalogue.getproductList();
        productCatalogue.addProductToCart(productname);
    }

    @And("^Checkout (.+) and submit the order$")
    public void Checkout_and_submit_the_order(String productname) throws InterruptedException
    {

        CartPage cartPage=productCatalogue.goToCartPage();
        Boolean match= cartPage.VerifyProductDisplay(productname);
        Assert.assertTrue(match);
        CheckOutPage checkoutpage= cartPage.goToCheckout();
        checkoutpage.selectCountry("india");
        //Thread.sleep(5000);
        confirmationPage= checkoutpage.submitOrder();
    }

    @Then("{string} message is displayed on confirmationpage")
    public void  message_is_displayed_on_confirmationpage(String string)
    {
        String confirmationmessage=confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmationmessage.equalsIgnoreCase(string));
        driver.close();
    }
}
