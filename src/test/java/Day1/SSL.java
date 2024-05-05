package Day1;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSL
{
    public static void main(String[] args) {

        ChromeOptions op= new ChromeOptions();
        op.setAcceptInsecureCerts(true);
        Proxy proxy= new Proxy();
        proxy.setHttpProxy("ipaddress:4444");
        op.setCapability("proxy",proxy);
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Dell\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver=new ChromeDriver(op);
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
    }
}
