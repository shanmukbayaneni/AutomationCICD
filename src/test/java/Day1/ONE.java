package Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ONE
{
    public static void main(String[] args)
    {

        //chrome
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        //Gecko
        //System.setProperty("webdriver.Gecko.driver","C:\\Users\\Dell\\Downloads\\geckodriver-v0.34.0-win-aarch64\\geckodriver.exe");
        //WebDriver driver=new FirefoxDriver();

        //EdgeDriver
        System.setProperty("webdriver.edge.driver","C:\\Users\\Dell\\Downloads\\edgedriver_win64\\msedgedriver.exe");
        WebDriver driver=new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.facebook.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.quit();

    }
}
