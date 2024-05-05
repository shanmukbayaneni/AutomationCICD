package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandling
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

        driver.findElement(By.cssSelector("a.blinkingText")).click();

        Set<String> windows=driver.getWindowHandles(); //[parent ID, Child ID]
        Iterator<String>it = windows.iterator();
        String parentid = it.next();
        String childid= it.next();
        driver.switchTo().window(childid);
        System.out.println(driver.findElement(By.cssSelector("p.im-para.red")).getText());
        String emailid=driver.findElement(By.cssSelector("p.im-para.red")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(parentid);
        driver.findElement(By.id("username")).sendKeys(emailid);
    }
}
