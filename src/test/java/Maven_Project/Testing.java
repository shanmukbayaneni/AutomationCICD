package Maven_Project;

import Maven_Project.TestComponents.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Testing extends Base
{
    String productname= "IPHONE 13 PRO";
   @Test(dataProvider="getData",groups = {"purchase order"})
    public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException {


        ProductCatalogue productCatalogue=landingpage.loginApplication(input.get("email"),input.get("password"));

        List<WebElement> products = productCatalogue.getproductList();
        productCatalogue.addProductToCart(input.get("productname"));
        CartPage cartPage=productCatalogue.goToCartPage();

        Boolean match= cartPage.VerifyProductDisplay(input.get("productname"));
        Assert.assertTrue(match);
        CheckOutPage checkoutpage= cartPage.goToCheckout();
        checkoutpage.selectCountry("india");
        //Thread.sleep(5000);
        ConfirmationPage confirmationPage= checkoutpage.submitOrder();
        String confirmationmessage=confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmationmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }


    //Extent Reports


    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest()
    {
        ProductCatalogue productCatalogue=landingpage.loginApplication("shanmukbayaneni@gmail.com","Shannu123");
        OrderPage orderPage=productCatalogue.goToOrdersPage();
        Assert.assertTrue(orderPage.VerifyOrderDisplay(productname));
    }

    @DataProvider
    public Object[][] getData() throws IOException {


        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\ShanmukPackage\\purchaseorder.json");
        return new Object[][] {{data.get(0)}, new HashMap[]{data.get(1)}};
    }

    //        HashMap<String,String> map= new HashMap<String, String>();
//        map.put("email","shanmukbayaneni@gmail.com");
//        map.put("password","Shannu123");
//        map.put("productname","IPHONE 13 PRO");
//
//        HashMap<String,String> map1= new HashMap<String, String>();
//        map1.put("email","shanbay@gmail.com");
//        map1.put("password","Shannu@msdkiller_1234");
//        map1.put("productname","ADIDAS ORIGINAL");
}

