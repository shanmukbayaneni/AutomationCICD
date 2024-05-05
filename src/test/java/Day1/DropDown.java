package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDown
{
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // //a[@value='BLR'] - xpath for form
        // (//a[@value='HYD'])[2] - xpath for to

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        Thread.sleep(200);
        //driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']  //a[@value='HYD']")).click();  //div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR'] - created xpath using parent to child from

        //   //div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']  //a[@value='HYD'] - created xpath using parent to child To


        driver. findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();

    }
}
