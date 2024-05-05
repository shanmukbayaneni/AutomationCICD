package Maven_Project.TestComponents;

import Maven_Project.AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponents
{
    WebDriver driver;

    @FindBy(css = ".hero-primary")
    WebElement confirmationMessage;

    public ConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }

    public String getConfirmationMessage()
    {
        new CheckOutPage(this.driver);
        return this.confirmationMessage.getText();
    }


}
