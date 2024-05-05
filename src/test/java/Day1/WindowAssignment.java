package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowAssignment
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.cssSelector("a[href$='/windows/new']")).click();
        Set<String> wind=driver.getWindowHandles();
        Iterator<String> it= wind.iterator();
        String parentid= it.next();
        String childid= it.next();
        driver.switchTo().window(childid);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
        driver.switchTo().window(parentid);
        System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());

    }
}
