package Maven_Project.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public abstract class Base
{
    public WebDriver driver;
    public LandingPage landingpage;
        public WebDriver initializeDriver() throws IOException
        {

            Properties prop= new Properties();
            FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Resuorces\\GlobalData.properties");
            prop.load(fis);
            String browsername=System.getProperty("browser")!=null ? System.getProperty("browser"): prop.getProperty("browser");
            if(browsername.contains("chrome"))
            {

                ChromeOptions chromeOptions= new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                if(browsername.contains("headless"))
                {
                    chromeOptions.addArguments("headless");
                }
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().setSize(new Dimension(1440,900)); //help you to run in full screen
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            return driver;
        }

    public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
        //read json to String
        String jsoncontent = FileUtils.readFileToString(new File(filepath),
                StandardCharsets.UTF_8);

        //String to HashMap Jackson DataBind

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String,String>> data= mapper.readValue(jsoncontent, new TypeReference<List<HashMap<String, String>>>() {
        });

        return data;
        //{map, map1}
    }

    public String getScreenShot(String testcaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts= (TakesScreenshot)driver;
        File source= ts.getScreenshotAs(OutputType.FILE);
        File file= new File(System.getProperty("user.dir")+ "//reports//" + testcaseName + ".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir")+ "//reports//" + testcaseName + ".png";

    }


    @BeforeMethod(alwaysRun = true)
        public LandingPage launchapplication() throws IOException
        {
            driver=initializeDriver();
            landingpage= new LandingPage(driver);
            landingpage.goTo();
            return landingpage;
        }

        @AfterMethod(alwaysRun = true)
        public void tearDown()
        {
            driver.close();
        }

}
