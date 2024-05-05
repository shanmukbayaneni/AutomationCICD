package CoreJava;

public class ps2 extends ps3
{
    int a;

    public ps2(int a2)
    {
        super(a2); //parent class constructor is invoked
        this.a=a2; //this keyword
    }

    public int increment()
    {
        a=a+1;
        return a;
    }

    public int decrement()
    {
        a=a-1;
        return a;
    }
}
