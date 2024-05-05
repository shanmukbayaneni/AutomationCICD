package TestNg;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class day2
{
    @Test(groups={"Smoke"})
    public void weblogincar()
    {
        System.out.println("weblogincar");
    }
@Parameters({"URL","APIKey/username"})
    @Test
    public void Mobilelogincarloan(String name,String key)
    {
        System.out.println("mobilelogincar");
        System.out.println(name);
        System.out.println(key);
    }
    @Test
    public void Mobilesignin()
    {
        System.out.println("mobilelogincar");
    }
    @Test
    public void Mobilesignout()
    {
        System.out.println("mobilelogincar");
    }
    @Test
    public void LoginApicarloan()
    {
        System.out.println("apilogincar");
    }
}
