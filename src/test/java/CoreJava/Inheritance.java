package CoreJava;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Inheritance
{
    @BeforeMethod
    public void beforerun()
    {
        System.out.println("run me first");
    }
    public void doThis()
    {
        System.out.println("hello");
    }
@AfterMethod
    public void afterrun()
    {
        System.out.println("run me last");
    }
}
