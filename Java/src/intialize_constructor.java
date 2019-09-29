public class intialize_constructor {
    public static void main(String args[])
    {
        K obj=new K();// This withConstructor() is calling of constructor
    }
}

class K
{
  int a=10;
  K(){
      display();
  }
  void display()
  {
      System.out.println("I am within display method ");

  }

}


/*
This is calling println function from the constructor
The value of a is10
 */