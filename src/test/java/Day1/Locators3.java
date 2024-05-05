package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators3
{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        //sibling - child to parent traverse

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println(driver. findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

    }
}
