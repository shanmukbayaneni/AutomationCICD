package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Autocart
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        String[] items= {"Cucumber", "Brocolli", "Beetroot"};

        additems(driver,items);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));

        driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector(".promoBtn")).click();
        //explicit wait
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }

    public static void additems(WebDriver driver, String[] items)
    {
        int j=0;
        List<WebElement> products =  driver.findElements(By.cssSelector("h4.product-name"));

        for (int i=0;i< products.size();i++)
        {
            String[] name=products.get(i).getText().split("-");
            String formattedname= name[0].trim();
            //format it to get actual name
            //check whether the name you extracted is present in array or not-
            //convert array into arraylist for easy search

            List al= Arrays.asList(items);


            if(al.contains(formattedname))
            {
                j++;

                //click on add to cart
                driver.findElements(By.xpath("  //div[@class='product-action']/button")).get(i).click();

                if(j== items.length)
                    break;
            }
        }
    }
}
