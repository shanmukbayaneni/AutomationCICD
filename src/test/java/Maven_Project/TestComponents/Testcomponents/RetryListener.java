package Maven_Project.TestComponents.Testcomponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer
{
    int count=0, maxtry=1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(count<maxtry)
        {
            count++;
            return true;
        }
        return false;
    }
}
