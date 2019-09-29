public class initialize_through_block {
    public static void main(String args[])
    {
        U obj=new U();
        System.out.println(obj.age);
    }
}


class U
{
  int age;

    {
        age=7;
    }
}