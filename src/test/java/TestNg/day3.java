package TestNg;

import org.testng.annotations.*;

public class day3
{
    @BeforeClass
    public void beforeclas()
    {
        System.out.println("before executing any method in the class");
    }

    @AfterClass
    public void afterclas()
    {
        System.out.println("after executing all the methods in the class");
    }
    @Test(enabled=false)
    public void webloginhomeloan()
    {
        System.out.println("webloginhomeloan");
    }

    @Test(groups={"Smoke"})
    public void Mobilelogincarhomeloan()
    {
        System.out.println("mobileloginhomeloan");
    }
    @Parameters({"URL"})
    @Test
    public void beforeevery(String urlname)
    {
        System.out.println("before every test method in day 3 class");
        System.out.println(urlname);
    }
    @BeforeSuite
    public void unknown()
    {
        System.out.println("bye-bye");
    }
    @Test(dependsOnMethods = {"Mobilelogincarhomeloan"})
    public void LoginApicarhomeloan()
    {
        System.out.println("apiloginhomeloan");
    }

    @Test(dataProvider = "getdata")
    public void prerequesite(String username,String password)
    {
        System.out.println("i will execute first");
        System.out.println(username);
        System.out.println(password);
    }

    @DataProvider
    public Object[][] getdata()
    {
        //1st combination - username pswd - good credit history
        //2nd - username pswd - o credit history
        //3rd - fraudlent credit history

        Object[][] data= new Object[3][2];
        data[0][0] = "firstsetusername";
        data[0][1]= "pswd";
        //colums in the row nothing but values for the particular combination(row)

        //2nd set
        data[1][0]= "secondsetusername";
        data[1][1]= "second pswd";

        //3rd set

        data[2][0]="thirdsetusername";
        data[2][1] ="third pswd";
        return data;
    }
}
