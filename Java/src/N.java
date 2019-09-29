class N
{
	public static void main(String args[])
	{
		C c=new B();
		c.display();
	}
}

class B extends C
{
	void display()
	{
		System.out.println("display of B");
	}
}

class C
{
	void display()
	{
		System.out.println("display o f C");
	}
}