# 6 Class
---

1.  A class is a template for an object, and an object is an instance of a class. Because an object is an instance of a class.

2. Variables defined within a class are called instance variables because each instance of the class (that is, each object of the class) contains its own copy of these variables. Thus, the data for one object is separate and unique from the data for another.

```java
class BoxDemo
{
	public static void main(String[] args) {
		Box obj=new Box();
		obj.width=10;
		obj.height=20;
		obj.length=30;
		double vol=obj.width*obj.height*obj.length;
		System.out.println("Volume"+vol);
	}
}

class Box
{
	double width;
	double height;
	double length;
}

Volume6000.0

```

3. The new operator dynamically allocates (that is, allocates at run time) memory for an object and returns a reference to it. This reference is, more or less, the address in memory of the object allocated by new. This reference is then stored in the variable. Thus, in Java, all class objects must be dynamically allocate

```java
Box mybox; // declare reference to object
mybox = new Box(); // allocate a Box object 
```

4.  obj and obj_a refer to same object but they ain't linked. obj=null will unhook obj from original
   object without affecting obj_a. __Copy of the reference ,not copy of the reference__


```java
class BoxDemo
{
	public static void main(String[] args) {
		Box obj=new Box();
		Box obj_a=obj;// means copy of the reference ,not copy of the reference

		obj.width=10;
		obj.height=20;
		obj.length=30;
		double vol=obj.width*obj.height*obj.length;
		System.out.println("Volume"+vol);
		System.out.println(obj_a.width);
		System.out.println(obj_a.length);System.out.println(obj_a.height);

		obj=null;
		System.out.println(obj_a.width);
		System.out.println(obj_a.length);System.out.println(obj_a.height);



	}
}

class Box
{
	double width;
	double height;
	double length;
}

```

5.  A parameter is a variable defined by a method that receives a value when the method is called. For example, in square(int i), i is a parameter. An argument is a value that is passed to a method when it is invoked. For example, square(100) passes 100 as an argument. Inside square( ), the parameter i receives that value. 

6. Constructor

> The implicit return type of a class’ constructor is the class type itself.It is the\
 constructor’s job to initialize the internal state of an object so that the code creating an instance \
will have a fully initialized, usable object immediately.

```java
class BoxDemo
{
	public static void main(String[] args) {
		Box obj=new Box(10,20,30);
		double vol=obj.volume();
		System.out.println(vol);
	}
}

class Box
{
	double width;
	double height;
	double length;

	Box(double width,double height,double length)
	{
		System.out.println("Hola ahi");
		this.width=width;
		this.height=height;
		this.length=length;
		System.out.println(width);
		System.out.println(height);
		System.out.println(length);
	}
	double volume()
	{
		return width*height*length;
	}
}

Hola ahi
10.0
20.0
30.0
6000.0

```

* The difference

__Instance Variable Hiding__ As you know, it is illegal in Java to declare two local variables with the same name inside the same or enclosing scopes. Interestingly, you can have local variables, including formal parameters to methods, which overlap with the names of the class’ instance variables. However, when a local variable has the same name as an instance variable, the local variable hides the instance variable. This is why width, height, and depth were not used as the names of the parameters to the Box( ) constructor inside the Box class. If they had been, then width, for example, would have referred to the formal parameter, hiding the instance variable width. While it is usually easier to simply use different names, there is another way around this situation. Because this lets you refer directly to the object, you can use it to resolve any namespace collisions that might occur between instance variables and local variables. For example, here is another version of Box( ), which uses width, height, and depth for parameter names and then uses this to access the instance variables by the same name:


```java

class BoxDemo
{
	public static void main(String[] args) {
		Box obj=new Box(10,20,30);
		double vol=obj.volume();
		System.out.println(vol);
	}
}

class Box
{
	double width;
	double height;
	double length;

	Box(double width,double height,double length)
	{
		System.out.println("Hola ahi");
		width=width;
		height=height;
		length=length;
		System.out.println(width);
		System.out.println(height);
		System.out.println(length);
	}
	double volume()
	{
		return width*height*length;
	}
}


Hola ahi
10.0
20.0
30.0
0.0
```

7. __Overloading Methods In Java__
 It is possible to define two or more methods within the same class that share the same name, as long as their parameter declarations are different. When this is the case,  the methods are said to be overloaded, and the process is referred to as method overloading.
 Method overloading is one of the ways that Java supports polymorphism.

> When an overloaded method is invoked, Java uses the type and/or number of arguments as its guide to determine which version of the overloaded method to actually call. Thus, overloaded methods must differ in the type and/or number of their parameters.\
 While overloaded methods may have different return types, __the return type alone is insufficient to distinguish two versions of a method__.\
 When Java encounters a call to an overloaded method, it simply executes the version of the method whose parameters match the arguments used in the call. \
 When an overloaded method is called, Java looks for a match between the arguments used to call the method and the method’s parameters.


```java
class Overload
{
	public static void main(String[] args) {
		OverloadDemo obj=new OverloadDemo();
		obj.test();
		obj.test(7);
		obj.test(10,11);
		obj.test(3.14);
	}
}

class OverloadDemo
{
   void test()
   {
     System.out.println("This is the test method without any argument");
   }

   void test(int i)
   {
   	System.out.println("This is the test with one argument"+i);
   }


   void test(int i,int k)
   {
   	System.out.println("This is the test with two arguments"+i+k);
   }

   double test(double i)
   {
   	System.out.println("This is the test with one argument but of double type and return type is also double"+i);
   	return i;
   }
}

// This is the test method without any argument
// This is the test with one argument7
// This is the test with two arguments1011
// This is the test with one argument but of double type and return type is also double3.14

```

> When an overloaded method is called, Java looks for a match between the arguments used to call \
the method and the method’s parameters. However, this match need not always be exact. In some \
cases, Java’s automatic type conversions can play a role in overload resolution


8.  __Constructor Overloading__


```java
class BoxDemo
{
	public static void main(String[] args) {

	Box obj=new Box();
	System.out.println("Without"+obj.volume());  //Without-1.0

	Box obj_b=new Box(10,20,30);
	System.out.println("With three arguments"+obj_b.volume()); //With three arguments6000.0

	Box obj_c=new Box(11);
	System.out.println("With single"+obj_c.volume());  //With single1331.0		
	}
}

class Box
{
	double height;
	double width;
	double length;

	Box(double height,double width,double length)
	{
		this.height=height;
		this.width=width;
		this.length=length;
	}

	Box()
	{
		height=width=length=-1;
	}

	Box(double value)
	{
		height=width=length=value;
	}

	double volume()
	{
		return height*width*length;
	}
}


```

9. __Using objects as parameters__

```java
class TestDemo
{
	public static void main(String[] args) {

		Test obj_a=new Test(10,20);
		Test obj_b=new Test(7,11);
		System.out.println(obj_a.isEqual(obj_b));  //false


		Test obj_c=new Test(10,20);
		System.out.println(obj_c.isEqual(obj_b)); //false


		System.out.println(obj_c.isEqual(obj_a));  //true

		System.out.println(obj_a.isEqual(obj_c));  //true
}

}

class Test
{
	int a;
	int b;

	Test(int j,int k)
	{
		a=j;
		b=k;
	}

	boolean isEqual(Test o)
	{
		if (a==o.a && b==o.b)
			return true;
		else
			return false;
	}
}

```

10. One object can initialize another one

```java
class BoxDemo
{
	public static void main(String[] args) {

		Box obj=new Box(10,20,30);
		obj.volume();     // the volume is 6000.0

		Box obj_b=new Box(obj);
		obj_b.volume();  // the volume is 6000.0

	}
}

class Box
{
	double width;
	double height;
	double length;

	Box(double w,double h,double l)
	{
		width=w;
		height=h;
		length=l;
	}

	Box(Box ob)
	{
		width=ob.width;
		height=ob.height;
		length=ob.length;
	}

	void volume()
	{
		System.out.println("The volume is "+width*height*length);
	}
}


```


11. Call by reference and call by value

   1. Call by value 
  
  ```java
class TestDemo
{
	public static void main(String[] args) {
      Demo obj=new Demo();

      int i=10;
      int j=11;
      System.out.println("Value of i and j before calling alter"+i+"  "+j);
      obj.alter(i,j);


      System.out.println("Value of i and j after calling alter"+i+"  "+j);
     

	}
}

class Demo
{
   void alter(int i,int j)
   {
   	i=i*2;
   	j=j+2;

   	System.out.println("This is within the function");
    System.out.println("Value of i and j after when contorl is within alter"+i+"  "+j);


   }
}

// Value of i and j before calling alter10  11
// This is within the function
// Value of i and j after when contorl is within alter20  13
// Value of i and j after calling alter10  11


  ```

   2. Call by reference

   ```java

class TestDemo
{
	public static void main(String[] args) {
      Demo obj=new Demo(10,11);

      System.out.println("Value of a and b before calling constructor"+obj.a+"  "+obj.b);
      
      obj.alter(obj);
      
      System.out.println("Value of a and b after calling alter"+obj.a+"  "+obj.b);
     

	}
}

class Demo
{
	int a,b;
   Demo (int i,int j)
   {
   		a=i;
   		b=j;

   }

   void  alter(Demo obj)
   {
   	obj.a=obj.a*2;
   	obj.b=obj.b+2;

   	System.out.println("This is within the function");
    System.out.println("Value of i and j after when contorl is within alter"+obj.a+"  "+obj.b);


   }


}

// Value of a and b before calling constructor10  11
// This is within the function
// Value of i and j after when contorl is within alter20  13
// Value of a and b after calling alter20  13


   ```


10. __Returning objects__

```java

```


11. __static__

 1. There will be times when you will want to define a class member that will be used independently of any object of that class. Normally, a class member must be accessed only  in conjunction with an object of its class. However, it is possible to create a member that can  be used by itself, without reference to a specific instance.
 2. To create such a member, precede  its declaration with the keyword static. When a member is declared static, it can be accessed before any objects of its class are created, and without reference to any object. 
 3. The most common example of a static member is main( ). main( ) is declared as static because it must be called before any objects exist. Instance variables declared as static are, essentially, global variables.
 4. When objects of  its class are declared, no copy of a static variable is made. Instead, all instances of the class share the same static variable.
 5.  Methods declared as static have several restrictions: 
    • They can only directly call other static methods.
    • They can only directly access static data. 
    • They cannot refer to this or super in any way. (The keyword super relates to inheritance and is described in the next chapter.) 
 6. If you need to do computation in order to initialize your static variables, you can declare a static block that gets executed exactly once, when the class is first loaded.


 12. Demonstrate static block,method and variable

 ```java
class StaticDemo{
	public static void main(String[] args) {
		Demo obj=new Demo();
		Demo.display();

	}
}


class Demo
{
	static int i;
	static int b;

	static 
	{
		System.out.println("We can make a static block too");
		i=7;
	}

	static void display()
	{
		System.out.println("value of i"+i);
		System.out.println(b);
	}
}
 ```

13. __final__ :
A field can be declared as final. Doing so prevents its contents from being modified, making it, essentially, a constant. This means that you must initialize a final field when  it is declared. You can do this in one of two ways
> First, you can give it a value when it is declared.\
 Second, you can assign it a value within a constructo




14. __Nested or Inner class__ : It is possible to define a class within another class; such classes are known as nested classes. The scope of a nested class is bounded by the scope of its enclosing class. Thus, if class B is defined within class A, then B does not exist independently of A.
> A nested class has access to the members, including private members, of the class in which it is nested. However, the enclosing class does not have access to the members of the nested class.\
 A nested class that is declared directly within its enclosing class scope is a member of its enclosing class. It is also possible to declare a nested class that is local to a block.\
  There are two types of nested classes: static and non-static. \
  A static nested class is one  that has the static modifier applied. Because it is static, it must access the non-static members of its enclosing class through an object. That is, it cannot refer to non-static members of its enclosing class directly. Because of this restriction, static nested classes are seldom used. \
  The most important type of nested class is the inner class. An inner class is a non-static nested class. It has access to all of the variables and methods of its outer class and may refer to them directly in the same way that other non-static members of the outer class do.\
   The following program illustrates how to define and use an inner class. The class named Outer has one instance variable named outer_x, one instance method named test( ), and defines one inner class called Inner.



```java

class InnerClassDemo{
	public static void main(String[] args) {

		OuterClass ob=new OuterClass();
		ob.test();
	}
}


class OuterClass
{


	int outer_x=11;


    void test()
	{
		Inner obj=new Inner();
		obj.display();
		System.out.println();
	}

	class Inner
	{
		void display()
		{
			System.out.println("Display of Inner class"+outer_x);
		}
	}
}
```
* In the program, an inner class named Inner is defined within the scope of class Outer. Therefore, any code in class Inner can directly access the variable outer_x.
> An instance method named display( ) is defined inside Inner. This method displays outer_x on the standard output stream. \
The main( ) method of InnerClassDemo creates an instance of class Outer and invokes its test( ) method. That method creates an instance of class Inner and the display( ) method is called.\
 It is important to realize that an instance of Inner can be created only in the context of class Outer. The Java compiler generates an error message otherwise. \
 In general, an inner class instance is often created by code within its enclosing scope, as the example does. As explained, an inner class has access to all of the members of its enclosing class, but the reverse is not true. Members of the inner class are known only within the scope of the inner class and may not be used by the outer class.



 ```java
 // This program will not compile. 
 class Outer {   

  int outer_x = 100; 

  void test() 
  {  
     Inner inner = new Inner(); 
     inner.display();   
   } 
 
  // this is an inner class 
    class Inner {


   int y = 10; // y is local to Inner 
 
    void display() 
    { 
          System.out.println("display: outer_x = " + outer_x);  
    }  
  
    } 
 
  void showy() { 
      System.out.println(y); // error, y not known here!
         } 
     } 
 
class InnerClassDemo 
{   public static void main(String args[])
 { 
     Outer outer = new Outer();   
       outer.test();
          }

  }

```


15. Inheritance

```java
class SimpleInheritance
{
	public static void main(String[] args) 
	{
		A parent=new A();
		parent.i=7;
		parent.j=11;
		parent.showij();

		B child=new B();
		child.k=10;
		child.i=20;
		child.j=90;
		child.showk();

		child.sum();
	}
}



class A
{
	int i,j;

	void showij()
	{
		System.out.println("The values of i and j in the class A"+i+"   "+j);
	}
}

class B extends A
{
	int k;
	void showk()
	{
		System.out.println("The value of k in child class"+k);
	}
	void sum()
	{
		System.out.println("The sum of i,j,k is "+(i+j+k));
	}
}


// The values of i and j in the class A7   11
// The value of k in child class10
// The sum of i,j,k is 120
```


16. A Superclass Variable Can Reference a Subclass Object A reference variable of a superclass can be assigned a reference to any subclass derived from that superclass.

It is important to understand that it is the type of the reference variable—not the type of the object that it refers to—that determines what members can be accessed. That is, when a reference to a subclass object is assigned to a superclass reference variable, you will have access only to those parts of the object defined by the superclass. This is why plainbox can’t access weight even when it refers to a BoxWeight object. If you think about it, this makes sense, because the superclass has no knowledge of what a subclass adds to it. This is why the last line of code in the preceding fragment is commented out. It is not possible for a Box reference to access the weight field, because Box does not define one. 


```java

class BoxDemo
{
	public static void main(String[] args) {
		BoxWeight weightbox=new BoxWeight(4,5,3,2);  //child
		Box plainbox=new Box(10,10,10); //parent

		double vol=weightbox.volume();
		System.out.println("Volume of weightbox obj :  "+vol);

		//Assigning parent reference to child

		plainbox=weightbox;
		vol=plainbox.volume();
		System.out.println("Volume of plainbox obj using parent reference :  "+vol);

		 /* The following statement is invalid because plainbox        does not define a weight member. */ //  System.out.println("Weight of plainbox is " + plainbox.weight); 



	}
}



class Box
{
	double width;
	double height;
	double depth;


	Box()
	{
		width=height=depth=-1;
	}

	Box(double w,double h,double d)
	{
		width=w;
		height=h;
		depth=d;
	}

	Box(Box obj)
	{
		width=obj.width;
		height=obj.height;
		depth=obj.depth;
	}
	double volume()

	{
		System.out.println("From parent --------");
		return width*height*depth;
	}
}



class BoxWeight extends Box
{
	double weight;

	BoxWeight(double w,double h,double d,double wei)
	{
		width=w;
		depth=d;
		height=h;
		weight=wei;
	}

	double volume()
	{

		System.out.println("From child --------");
		return weight*depth*height*width;
	}
}

// From child --------
// Volume of weightbox obj :  120.0
// From child --------
// Volume of plainbox obj using parent reference :  120.0s

```


17. super has two general forms. The first calls the superclass’ constructor. The second is used to access a member of the superclass that has been hidden by a member of a subclass. 


```java
class BoxDemo
{
	public static void main(String[] args) {
		BoxWeight weightbox=new BoxWeight(4,5,3,2);  //child
		Box plainbox=new Box(10,10,10); //parent

		double vol=weightbox.volume();
		System.out.println("Volume of weightbox obj :  "+vol);

		//Assigning parent reference to child

		plainbox=weightbox;
		vol=plainbox.volume();
		System.out.println("Volume of plainbox obj using parent reference :  "+vol);



	}
}



class Box
{
	double width;
	double height;
	double depth;


	Box()
	{
		width=height=depth=-1;
	}

	Box(double w,double h,double d)
	{
		width=w;
		height=h;
		depth=d;
	}

	Box(Box obj)
	{
		width=obj.width;
		height=obj.height;
		depth=obj.depth;
	}
	double volume()

	{
		System.out.println("From parent --------");
		return width*height*depth;
	}
}



class BoxWeight extends Box
{
	double weight;

	BoxWeight(double w,double h,double d,double wei)
	{
		super(w,h,d);
		weight=wei;
	}

	double volume()
	{

		System.out.println("From child --------");
		return weight*depth*height*width;
	}
}

// From child --------
// Volume of weightbox obj :  120.0
// From child --------
// Volume of plainbox obj using parent reference :  120.0

```


19. __super__ and it's uses

A. super has two general forms. The first calls the superclass’ constructor. The second is used to access a member of the superclass that has been hidden by a member of a subclass.

```java
class DemoSuper
{
	public static void main(String[] args) {
		
		BoxWeight myBox1=new BoxWeight();
		BoxWeight myBox2=new BoxWeight(10,20.23);
		BoxWeight myBox3=new BoxWeight(10,20,15,34.33);
		BoxWeight myBox4=new BoxWeight(myBox3);

		System.out.println(myBox1.volume()+"Is the volume and weight is"+myBox1.weight);
		System.out.println(myBox2.volume()+"is volume ,weight is"+myBox2.weight);
		System.out.println(myBox3.volume()+"weight is"+myBox3.weight);
		System.out.println(myBox4.volume()+"weight is"+myBox4.weight);

	}
}




class Box
{
	private double width;
	private double height;
	private double depth;

	Box()
	{
		width=height=depth=-1;   
	}

	Box(double len)
	{
		width=height=depth=len;
	}

	Box(double w,double h,double d)
	{
		width=w;
		height=h;
		depth=d;
	}

	Box(Box obj)
	{
		width=obj.width;
		height=obj.height;
		depth=obj.depth;
	}

	double volume()
	{
		return width*height*depth;
	}

}

class BoxWeight extends Box
{
	double weight;
	BoxWeight()
	{
		super();
		weight=-1;
	}

	BoxWeight(double len,double w)
	{
		super(len);
		weight=w;
	}

	BoxWeight(double w,double h,double d,double wei)
	{
		super(w,h,d);
		weight=wei;
	}

	BoxWeight(BoxWeight obj)
	{
		super(obj);
		weight=obj.weight;
	}

}


// -1.0Is the volume and weight is-1.0
// 1000.0is volume ,weight is20.23
// 3000.0weight is34.33
// 3000.0weight is34.33
```


B. The second form of super acts somewhat like this, except that it always refers to the superclass of the subclass in which it is used.
  
  * This second form of super is most applicable to situations in which member names  of a subclass hide members by the same name in the superclass.

```java
class A
{
	int i;
}

class B extends A
{
	int i;

	B(int a,int b)
	{
		super.i=a;  // i in A
		i=b;  //       i in B

	}

	void display()
	{
		System.out.println("i in the superclass"+super.i);
		System.out.println("i in the subclass  "+i);
	}
}

class UseSuper
{
	public static void main(String[] args) {
		B obj=new B(7,10);
		obj.display();
	}
}

i in the superclass7
i in the subclass  10

```





20. Multilevel Inheritance

```java
class Box
{
	double width;
	double height;
	double depth;
	Box()
	{
		width=height=depth=-1;
	}

	Box(double len)
	{
		width=height=depth=len;
	}

	Box(double w,double h,double d)
	{
		width=w;
		height=h;
		depth=d;
	}

	Box(Box obj)  //clone
	{
		width=obj.width;
		height=obj.height;
		depth=obj.depth;
	}

	double volume()
	{
		return height*width*depth;
	}
}

class BoxWeight extends Box
{
	double weight;

	BoxWeight()
	{
		super();
		weight=-1;
	}

	BoxWeight(double len,double wei)
	{
		super(len);
		weight=wei;
	}

	BoxWeight(double w,double h,double d,double wei)
	{
		super(w,h,d);
		weight=wei;
	}

	BoxWeight(BoxWeight obj)
	{
		super(obj);
		weight=obj.weight;
	}
}

class ShipMent extends BoxWeight
{
	double cost;

	ShipMent()
	{
		super();
		cost=-1;
	}

	ShipMent(double len,double wei,double c)
	{
		super(len,wei);
		cost=c;
	}

	ShipMent(double w,double h,double d,double wei,double c)
	{
		super(w,h,d,wei);
		cost=c;
	}

	ShipMent(ShipMent obj)
	{
		super(obj);
		cost=obj.cost;
	}
}



class DemoShipment
{
	public static void main(String[] args) {
		ShipMent obj=new ShipMent(10,20,15,10,3.41);
		ShipMent obj_b=new ShipMent(2,3,4,0.76,1.28);
	

		double vol=obj.volume();
		System.out.println(vol+"      "+obj.weight+"       $ "+obj.cost);

	    vol=obj_b.volume();
		System.out.println(vol+"      "+obj_b.weight+"       $ "+obj_b.cost);


	}
}

// 3000.0      10.0       $ 3.41
// 24.0      0.76       $ 1.28
```

21. The way constructors are called

```java


class callingCons
{
	public static void main(String[] args) {
		C obj=new C();
	}
}

class A
{
	A()
	{
		System.out.println("A");
	}

}

class B extends A
{
	B()
	{
		super();
		System.out.println("B");
	}
}

class C extends B
{
	C()
	{
		super();
		System.out.println("C");
	}
}

// A
// B
// C

```

22. Method Overriding

```java

class Override
{
	public static void main(String[] args) {
		B obj=new B(7,10,11);
		obj.display();
	}
}

class A
{
	int i,j;
	A(int a,int b)
	{
		i=a;
		j=b;
	}

	void display()
	{
		System.out.println(i+"    "+j);
	}
}

class B extends A
{
	int k;
	B(int a,int b,int c)
	{
		super(a,b);
		k=c;
	}

	void display()
	{

		System.out.println(k);
	}
}

//11

```
> Calling method display of parent using super .

```java
class Override
{
	public static void main(String[] args) {
		B obj=new B(7,10,11);
		obj.display();
	}
}

class A
{
	int i,j;
	A(int a,int b)
	{
		i=a;
		j=b;
	}

	void display()
	{
		System.out.println(i+"    "+j);
	}
}

class B extends A
{
	int k;
	B(int a,int b,int c)
	{
		super(a,b);
		k=c;
	}

	void display()
	{
		super.display();
		System.out.println(k);
	}
}


// 7    10
// 11
```


23. Dynamic method dispatch

> a superclass reference variable can refer to a subclass object

```java
class A
{
	void callme()
	{
		System.out.println("Inside A's callme ");
	}

}

class B extends A
{
	void callme()
	{
		System.out.println("Inside B's callme ");
	}
}

class C extends A
{
	void callme()
	{
		System.out.println("Inside C's callme :)");
	}
}

class Dispatch
{
	public static void main(String[] args) {
		A a=new A();  
		B b=new B();
		C c=new C();


		A ref;

		ref=a;
		ref.callme();

		ref=b;
		ref.callme();

		ref=c;
		ref.callme();
	}
}


// Inside A's callme
// Inside B's callme
// Inside C's callme :)


```


22. Implementation of  method overriding

> Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time, rather than compile time. Dynamic method dispatch is important because this is how Java implements run-time polymorphism.\

A superclass reference variable can refer to a subclass object. Java uses this fact to resolve calls to overridden methods at run time. Here is how. When an overridden method is called through a superclass reference, Java determines which version of that method to execute based upon the type of the object being referred to at the time the call occurs. Thus, this determination is made at run time. When different types of objects are referred to, different versions of an overridden method will be called.\
In other words, it is the type of the object being referred to (not the type of the reference variable) that determines which version of an overridden method will be executed. Therefore, if a superclass contains a method that is overridden by a subclass, then when different types of objects are referred to through a superclass reference variable, different versions of the method are executed.

```java
class Figure
{
	double dim1;
	double dim2;

	Figure(double a,double b)
	{
		dim1=a;
		dim2=b;
	}

	double area()
	{
		System.out.println("within Figure");
		return 0;
	}
}

class Rectangle extends Figure
{
	Rectangle(double a,double b)
	{
		super(a,b);
	}

	double area()
	{
		System.out.println("Within area of rectangle");
		return dim1*dim2;
	}


}

class Triangle extends Figure
{
	Triangle(double a,double b)
	{
		super(a,b);
	}


	double area()
	{
		System.out.println("Within Trianlge");
		return dim1*dim2/2;
	}
}

class FindArea
{
	public static void main(String[] args) {
		Figure fobj=new Figure(30,7);


		Rectangle robj=new Rectangle(2,5);
	

		Triangle tobj=new Triangle(10,11);

		// System.out.println(fobj.area());
		// System.out.println(tobj.area());
		// System.out.println(robj.area());

		System.out.println("---------------");
		Figure ref;
		ref=robj;
		System.out.println(ref.area());

		ref=tobj;
		System.out.println(ref.area());

	}
}

// Within area of rectangle
// 10.0
// Within Trianlge
// 55.0

```

22. Dynamic dispatch using Abstract class

```java

abstract class Figure 
{
	double dim1;
	double dim2;


	Figure(double a,double b)
	{
		dim1=a;
		dim2=b;
	}

	abstract double area();
}

class Rectangle extends Figure
{
	Rectangle(double a,double b)
	{
		super(a,b);

	}

	double area()
	{
		System.out.println("Rectanlge class");
		return dim1*dim2;
	}
}

class Triangle extends Figure
{
	Triangle(double a,double b)
	{
		super(a,b);
	}

	double area()
	{
		System.out.println("Triangle class");
		return dim1*dim2/2;
	}
}

class AbstractClass
{
	public static void main(String[] args) {
		Rectangle robj=new Rectangle(10,7);

		Triangle tobj=new Triangle(11,11);

		Figure ref;

		ref=robj;

		System.out.println(ref.area());

		ref=tobj;
		System.out.println(ref.area());
	}
}



// Rectanlge class
// 70.0
// Triangle class
// 60.5
```


23. __final__
   a. final is used to declare a constant value.
   b. prevent overriding.

   > Methods declared as final can sometimes provide a performance enhancement: The compiler is free to inline calls to them because it “knows” they will not be overridden by a subclass. When a small final method is called, often the Java compiler can copy the bytecode for the subroutine directly inline with the compiled code of the calling method, thus eliminating the costly overhead associated with a method call. Inlining is an option only with final methods.\
    Normally, Java resolves calls to methods dynamically, at run time. This is called late binding. However, since final methods cannot be overridden, a call to one can be resolved at compile time. This is called early binding.

---

# Sep 5

---


1. __Arrays__
  * One dimensional arrays   . The default value of an array type is null.
  * Two dimensional arrays    is collection of 1D arrays {{},{},{}}
  * Three dimensional arrays is collection of 2D arrays {{{}},{{}},{{}}}
  * Four dimensional arrays is collection of 3D arrays {{{{}}},{{{}}}}



```java
class JavaArrays 
{
	public static void main(String[] args) {


		int[][][][]a = {
			{{{1, 2, 3},{4, 5, 6, 9},{7}},{{7,9,10},{11}}},
			{{{5,2},{6,2}},{{1,2}}},
			{{{32,45},{45,45},{93,23}}},
		};

		System.out.println(a[2][0][2][1]);
		System.out.println(a[1][1][0][1]);
	
		for(int[][][] array3D:a)
		{
			for (int[][] array2D:array3D)
			{
				for (int[] array1D:array2D)
				{
					for (int value:array1D)
					{
						System.out.print(value+"  ");
					}
					System.out.println();
				}
			}
			System.out.println();
		}

	}
}



// a[][][][]=
// {
// 	{{{6,7},{23,45}}},
// 	{{{9,8}},{{1,2}}},
// 	{{{12,34,45}}}
// }

// 23
// 2
// 1  2  3
// 4  5  6  9
// 7
// 7  9  10
// 11

// 5  2
// 6  2
// 1  2

// 32  45
// 45  45
// 93  23

```




# Sept 19

---

#### Conversion


1. Boxing : converting primitive data type to an object

```java

class D
{
	public static void main(String[] args) {
		int value=10;  // primitive data type
		Integer valueobj=new Integer(value);

		System.out.println("Primitive               one :"+value);
		System.out.println("Objec of primitive datatype :"+valueobj);


		System.out.println("Operation of primitive      :"+value*10);
		System.out.println("Object of primitive         :"+valueobj*100);

			
	}
}

Primitive               one :10
Objec of primitive datatype :10
Operation of primitive      :100
Object of primitive         :1000



class D
{
	public static void main(String[] args) {
		int value=10;  // primitive data type
		Integer valueobj=new Integer(value);

		System.out.println("Primitive               one :"+value);
		System.out.println("Objec of primitive datatype :"+valueobj);


		System.out.println("Operation of primitive      :"+value*10);
		System.out.println("Object of primitive         :"+valueobj*100);


		int answer=valueobj.intValue();
		System.out.println("Retrieved integer primitive value from object        :"+answer);

		Double pi=new Double(3.14);
		double pie=pi.doubleValue();  
		System.out.println(pie*10);
				// Double pi=3.14;
		// double pie=pi.doubleValue();

			
	}
}




```

2. Converting object to primitive datatype

```java



```

---