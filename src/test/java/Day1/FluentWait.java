package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

public class FluentWait
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("[id='start'] button")).click();

        Wait<WebDriver> w= new org.openqa.selenium.support.ui.FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30000)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);


        WebElement foo = w.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {

                 if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed())
                 {
                     return driver.findElement(By.cssSelector("[id='finish'] h4"));
                 }
                 else
                     return null;
            }
        });

        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());




    }
}
