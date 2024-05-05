package Maven_Project.TestComponents;

import Maven_Project.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents
{
    WebDriver driver;

    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement passwordEle;

    @FindBy(id="login")
    WebElement submit;
    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        //initialization
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    //WebElement userEmails = driver.findElement(By.id("userEmail"));
    //PageFactory



    public ProductCatalogue loginApplication(String email,String password)
    {
        this.userEmail.sendKeys(email);
        this.passwordEle.sendKeys(password);
        this.submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(this.driver);
        return productCatalogue;


    }

    public String getErrorMessage()
    {
        this.waitForWebElementToAppear((errorMessage));
        return this.errorMessage.getText();
    }
    public void goTo()

    {
        this.driver.get("https://rahulshettyacademy.com/client");
    }


}
