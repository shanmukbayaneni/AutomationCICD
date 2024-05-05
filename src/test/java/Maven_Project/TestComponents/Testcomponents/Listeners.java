package Maven_Project.TestComponents.Testcomponents;

import Maven_Project.TestComponents.Base;
import Resuorces.ExtentReporterNG;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends Base implements ITestNGListener
{
    ExtentTest test;
    ExtentReports extentReports= ExtentReporterNG.getReportObject();

    ThreadLocal<ExtentTest> extentTest= new ThreadLocal<>(); //thread safe

    public void onTestStart(ITestResult result)

    {
        test = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test); //unique thread ID(ErrorValidationTest)->test
    }


    public void onTestSuccess(ITestResult result) throws NoSuchFieldException, IllegalAccessException, IOException {
        test.log(Status.PASS,"Test passed");
//        test.pass(result.getThrowable());
//        String filepath=null;
//        driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
//        filepath = getScreenShot(result.getMethod().getMethodName(), driver);
//        test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
    }


    public void onTestFailure(ITestResult result) throws IOException, NoSuchFieldException, IllegalAccessException {
        extentTest.get().fail(result.getThrowable()); //
        String filepath=null;
       driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        filepath = getScreenShot(result.getMethod().getMethodName(), driver);
        test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
       //create screenshot and attach it to report


    }

    public void onFinish(ITestResult result)
    {
        extentReports.flush();
    }

}
