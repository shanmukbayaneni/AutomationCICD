package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class WebTable
{
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        //click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();

        //capture all the web elements in list
        List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));

        //capture text of all web elements using getText() into new(original) list
        List<String> originallist = list.stream().map(s -> s.getText()).collect(Collectors.toList());

        //sort on the original list for step 3 -> sorted list
        List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());

        //compare original list vs sorted list
        Assert.assertTrue(originallist.equals(sortedlist));
        List<String> price;
        //scan the vegatable row and with the getText() -> Beans -> print the price of the vegatable
        do {
            List<WebElement> list1 = driver.findElements(By.xpath("//tr/td[1]"));
        price = list1.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s)).collect(Collectors.toList());
        price.forEach(a-> System.out.println(a));
        if(price.size()<1)
        {
            driver.findElement(By.cssSelector("[aria-label='Next']")).click();
        }
    }while (price.size()<1);
    }

    private static String getPriceVeggie(WebElement s)
        {
           String pricevalue= s.findElement(By.xpath("following-sibling::td[1]")).getText();
            return pricevalue;
        }
    }
