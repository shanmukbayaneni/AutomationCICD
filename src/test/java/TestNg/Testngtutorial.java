package TestNg;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Testngtutorial
{
    @Test
    public void Demo()
    {
        System.out.println("hi");
    }

    @Test(groups={"Smoke"})
    public void Second()
    {
        System.out.println("bye");
    }

    @AfterSuite
    public void exeecute()
    {
        System.out.println("kingdon");
    }
}
