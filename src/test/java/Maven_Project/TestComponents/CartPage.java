package Maven_Project.TestComponents;

import Maven_Project.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents
{
    WebDriver driver;

    @FindBy(css = ".totalRow button")
    WebElement checkoutEle;

    @FindBy(css = ".cartSection h3")
    private List<WebElement> cartProducts;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public Boolean VerifyProductDisplay(String productName) {
        Boolean match = this.cartProducts.stream().anyMatch(product ->
        {return product.getText().equalsIgnoreCase(productName);});
        return match;

    }

    public CheckOutPage goToCheckout() throws InterruptedException {
        Thread.sleep(5000);
        this.checkoutEle.click();
        return new CheckOutPage(this.driver);


    }

}
