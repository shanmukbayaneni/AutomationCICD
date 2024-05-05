package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiAssignment
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("checkBoxOption2")).click();
        //get the text
        String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();


        WebElement dropdown= driver.findElement(By.id("dropdown-class-example"));

        Select s= new Select(dropdown);
        s.selectByVisibleText(opt);

        driver.findElement(By.id("name")).sendKeys(opt);
        driver.findElement(By.id("alertbtn")).click();
        String text=driver.switchTo().alert().getText();
        if (text.contains(opt))
        {
            System.out.println("Alert message success");
        }
        else
            System.out.println("Something wrong with execution");
    }
}
