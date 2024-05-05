package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        /*driver.findElement(By.id("checkBoxOption1")).click();


        Assert.assertTrue(driver.findElement(By.cssSelector("input[type='checkbox']")).isSelected());
        driver.findElement(By.cssSelector("input[type='checkbox']")).click();

        //count no of check boxes
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());*/

        driver.findElement(By.name("name")).sendKeys("shanmukbayaneni");

        driver.findElement(By.name("email")).sendKeys("shanmukbayaneni@Gmail.com");

        driver.findElement(By.id("exampleInputPassword1")).sendKeys("shannu123");

        driver.findElement(By.id("exampleCheck1")).click();

        WebElement element = driver.findElement(By.id("exampleFormControlSelect1"));

        Select dropdown = new Select(element);


        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Male");

        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("Female");

        driver.findElement(By.id("inlineRadio1")).click();

        driver.findElement(By.name("bday")).sendKeys("25-08-1998");

        driver.findElement(By.cssSelector(".btn-success")).click();

        System.out.println(driver.findElement(By.cssSelector(".alert-success")).getText());

    }
}
