package Maven_Project.TestComponents;

import Maven_Project.AbstractComponents.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends AbstractComponents
{
    WebDriver driver;

    @FindBy(css = ".action__submit")
    private WebElement placeorder;


    @FindBy(css = "[placeholder='Select Country']")
    private WebElement country;

    @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
    private WebElement selectCountry;

    private By results = By.cssSelector(".ta-results");
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void selectCountry(String countryName) {
        Actions a = new Actions(driver);
        a.sendKeys(country,new CharSequence[]{countryName}).build().perform();
        waitForElementToAppear(By.cssSelector(".ta-results"));
        selectCountry.click();
    }


//    public ConfirmationPage submitOrder() throws InterruptedException {
//        Thread.sleep(5000);
//        placeorder.click();
//        return new ConfirmationPage(driver);
//
//
//    }

    public ConfirmationPage submitOrder()

    {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", placeorder);



        return new ConfirmationPage(driver);

    }

}
