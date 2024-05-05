package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrookenLink
{
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        //broken Link
        //Step-1 - Is to get alll urls tied up to the link using selenium
        //java methods will call urls and gets you to the status code
        //if status code >400 then it si not working-> link which tied to url is broken
        //a[href*=\"SoapUI\"]

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links=driver.findElements(By.cssSelector("li[class=\"gf-li\"] a"));
                                                                //li[class="gf-li"] a

        SoftAssert a = new SoftAssert();
        for (WebElement link: links)
        {
            link.getAttribute("href");
            String url=link.getAttribute("href");

            HttpURLConnection conn =(HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int res=conn.getResponseCode();
            System.out.println(res);
            a.assertTrue(res>400,"The link with text" +link.getText()+"is broken with code"+res);

        }

        a.assertAll();

    }
}
