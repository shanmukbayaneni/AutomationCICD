package Maven_Project.TestComponents;

import Maven_Project.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ProductCatalogue extends AbstractComponents
{
    WebDriver driver;

    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By productsby = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");
    public ProductCatalogue(WebDriver driver)
    {
        super(driver);
        // initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public List<WebElement> getproductList() throws InterruptedException {

        waitForElementToAppear(productsby);
        Thread.sleep(5000);
        return products;
    }

    public WebElement getProductByName(String productName) throws InterruptedException {
        WebElement prod =(WebElement)getproductList().stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse( null);
        return prod;
    }


    public void addProductToCart(String productName) throws InterruptedException
    {
        WebElement prod =getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        waitForElementToDisappear(spinner);


    }

}
