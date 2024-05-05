package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Scope
{
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        //give me the count of links on the page //a
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        System.out.println(driver.findElements(By.tagName("a")).size());

        WebElement footerdriver=driver.findElement(By.id("gf-BIG")); //limiting webdriver scope

        System.out.println(footerdriver.findElements(By.tagName("a")).size());

        //3
        WebElement column=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
        System.out.println(column.findElements(By.tagName("a")).size());

        //4- click on each link in the column and click on each link if it is working or not
        for(int i=1;i<column.findElements(By.tagName("a")).size();i++) {
            // Keyboard events
            String clickonlinks = Keys.chord(Keys.CONTROL, Keys.ENTER);
            column.findElements(By.tagName("a")).get(i).sendKeys(clickonlinks);
            Thread.sleep(5000);
        }
            Set<String> title= driver.getWindowHandles();
            Iterator it=title.iterator();


            while (it.hasNext())
            {
                driver.switchTo().window((String) it.next());
                System.out.println(driver.getTitle());
            }


    }
}
