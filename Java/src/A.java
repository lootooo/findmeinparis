class A
{
  public static void main(String args[])
  {
    C c;
    c=new D();
    c.show();
    c=new B();
    c.show();
    
  }
}

class C
{
  void show()
  {
    System.out.println("show of C");
  }
}

class B extends C
{
  void show()
  {
    System.out.println("show of B");
  }
}

class D extends C
{
  void show()
  {
    System.out.println("show of D");
  }
}