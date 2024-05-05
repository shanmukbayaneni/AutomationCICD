package Maven_Project.TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.lang.model.util.Elements;
import java.time.Duration;
import java.util.List;

public class StandAloneTest
{
    public static void main(String[] args)
    {

        String productname= "IPHONE 13 PRO";

        //WebDriver manager to invoke chrome driver
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        //hit the URL
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client/");

        //LandingPage Lp= new LandingPage(driver);

        //login details
        driver.findElement(By.id("userEmail")).sendKeys("shanmukbayaneni@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Shannu123");
        driver.findElement(By.id("login")).click();

        // storing the list of items in list
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));


        //checking condition for Iphone 13 and prod stores the product with the text "IPHONE 13 PRO"
        WebElement prod = products.stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        //finding the locator for the toast message
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

        //click on cart - Add to cart section
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        //list of cart products
        List<WebElement> cartproducts = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));

        // to match the condition
        Boolean match = cartproducts.stream().anyMatch(cartprod->cartprod.getText().equalsIgnoreCase(productname));
        Assert.assertTrue(match);

        //for checkout button
        driver.findElement(By.cssSelector(".totalRow button")).click();

        //for auto-suggestion for the country box
        Actions a =new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

       driver.findElement(By.cssSelector("a[class*='btnn']")).click();

        String confirmation=driver.findElement(By.cssSelector(".hero-primary")).getText();

        Assert.assertTrue(confirmation.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

        driver.close();
    }
}
