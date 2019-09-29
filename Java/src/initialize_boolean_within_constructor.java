public class initialize_boolean_within_constructor {
    public static void main(String args[])
    {

        Z obj=new Z();

    }
}

class Z
{
    boolean light;
    Z()
    {
        System.out.println("Default value"+light);
    }
}
