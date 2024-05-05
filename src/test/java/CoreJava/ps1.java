package CoreJava;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ps1 extends Inheritance
{
    @Test
    public void Run()
    {
        ps2 p= new ps2(3); //parameterized constructor
        int a=3;
        doThis();
        System.out.println(p.decrement());
        System.out.println(p.increment());

        System.out.println(p.multi());
        System.out.println(p.multithree());
    }
}
