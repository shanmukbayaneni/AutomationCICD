package Day1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class MultiWindows
{
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        //switching window
        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles=driver.getWindowHandles();
        Iterator<String> it=handles.iterator();
        String parentwindowid = it.next();
        String childwindowid = it.next();
        driver.switchTo().window(childwindowid);
        driver.get("https://courses.rahulshettyacademy.com/courses/");
        String coursename = driver.findElements(By.cssSelector("[class*='course-listing-title']")).get(1).getText();
        driver.switchTo().window(parentwindowid);
        WebElement name=driver.findElement(By.cssSelector("[name='name']"));
        name.sendKeys(coursename);
        File ss=name.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(ss,new File("logo.png"));
        //driver.quit();

        //get height and width

        System.out.println(name.getRect().getDimension().getHeight());
        System.out.println(name.getRect().getDimension().getWidth());
    }
}
