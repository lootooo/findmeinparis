# Java

---

### Day 1:

---

1 Execution of java program is two phase process
> Compilation \
> Execution

   * Inorder to compile a java program a machine should consist compiler that is part of JDK.
  
2 We can write a number of classes within a source.

3 A class is a template and can be created using 

```java
class className
{
    
}
```

4 Data type
   
    1. primitive.
    2. Abstract,reference,user-defined.

---

5 Java is case sensitive language while dos isn't. 
   > If we have two java class with b.java and B.java ,one of them after compilation will override other.
   
   
6 After successfully compiling a program in class file . It can be executed by java interpreter. A java class
  file is intermediate machine code. (16 bit unicode character is comprehended by JVM).
  
7 __JDK__ 
> __javac__ -> class file (byte code). This byte code can __run__ in another device too.\
> __JRE__   
          
  * java interpreter (JVM)
  * API libraries
   
      


# College

---

1.  We can call an instance method from the constructor.

```java
public class A
{
	public static void main(String args[])
	{
		B obj=new B();
		obj.B();
	}
}


class B
{
	int i;

	void B()
	{
		System.out.println("this is method B");
	}
}
```



2. We can't declare two objects with the same name but can call it.

```java

public class A
{
	public static void main(String args[])
	{
		B obj=new B();
		B obj=new B();
	}
}


class B
{
	int i;

	void B()
	{
		System.out.println("this is method B");
	}
}

A.java:6: error: variable obj is already defined in method main(String[])
                B obj=new B();
                  ^
1 error
```

> Can do this


```java
public class A
{
	public static void main(String args[])
	{
		B obj=new B();
		obj=new B();
	}
}


class B
{
	int i;

	void B()
	{
		System.out.println("this is method B");
	}
}
```

3. We can initialize variable of class through block also.

```java
public class A
{
	public static void main(String args[])
	{
		B obj=new B();
		System.out.println("The value o f i"+obj.i);

	}
}


class B
{
	int i;

	{
		i=230;
	}
}
```

> We can create a block in a class using {} ,there may be multiple blocks in a class.


4.








5. Static variable vs instance variable

```java
class Glen
{
	public static void main(String args[])
	{
		James obj=new James();
		James obj_b=new James();
		James.j=7;
		System.out.println(obj.j+"value of j using obj");
		obj.i=2;
		System.out.println(obj.i+"Value of instance variable i of obj");
		obj_b=21;
		System.out.println(obj_b.i+"value of instance variable i of obj_b");
		System.out.println("The value of j static variable using obj object"+obj.j);
		System.out.println("The value of j static variable using obj_b object"+obj_b.j);
		System.out.println("The value of j static variable using class name"+James.j);
		
		
	}
}

class James
{
	int i;
	static int j;
}
```


6.  Static variable concept

```java
class A
{
	int i;
	public static void main(String args[])
	{
		A a=new A();
		i=30;
		System.out.println(i);
		System.out.println("This is the i of the class"+a.i);
	}
}

class B
{
   int i=9;
   static int j=99;

}




```


> Another one

```java
class A
{
	int i;
	static int j=7;
	{
		System.out.println("static");
	}
	public static void main(String args[])
	{
		A a=new A();
		A obj=new A();
	}
}

class B
{

}




```

* We can create a block in a class using {}
> There may be multiple blocks in a class . A block will be copied into each constructor
  call  \
> The block is copied at time of constructor call.


```java

class B
{
    int i;
    {
        System.out.println(i);
        i=7;
    }
    
    B()
    {
        System.out.println(i);
        i=43;
    }
}

class A
{
    public static void main(String args[])
    {
        B obj=new B();
        System.out.println(obj.i);
    }
}
```


* We can initialize a variable at time of declaration it is called instance initialization.
* We can create a class variable if we are using static keyword with a variable.
* We can initialize a class variable as we are initializing instance variable.
* Difference b/w class and instance variable.
> Class variable is associated with class as well as with instance while instance 
 variable is associated with instance only.
 
---

* We cannot use instance variables or non-static things in static context.

> This is the wrong approach.
```java
class B
{
    int i=9;
    static int j=7;
    static int k=i;
}
```

> This is the correct one.
```java
class B
{
    int i=9;
    static int j=99;
    int k=j;
}
```

---

* As we are creating normal block , we can create static block too.
  Static blocks are associated with class means when a class will be loaded in memory
  its static block also be loaded but only once. Static blocks ain't copied into constructor.


---




# August 29

---

0. A class can contain no. of methods and those methods can use static or non-static variables directly.
   * A method can declare a variable and this variable is called local variable .
   * Java is strongly typed language it is vital to initialize variabel prior to use.
   * Constructor never initialize constructor ?
   > Local variable : stack\
   > class variable : heap
   * Local variable can have same name as of instance vairable. In that
   case the local variable fights the scope of instance variable.


1. We can differentiate local variable with instance variable by the help 
of "this" keyword . __this__ keyword is used to refer current object of a class.

2. This keyword can be used in three places
    > with variable\
     with class \
    with constructor overloading

3. Constructor overloading

   * If the name of class where main method exists is public then the name of the file should be similar to
    the name of the class otherwise you can name it anything(file).
constructor_overloading.java:1: error: class Area is public, should be declared in a file named Area.java
    public class Area
           ^
    1 error

4. 

```java
class A
{
	public static void main(String args[])
	{
		B b=new B();
		System.out.println(b.i);  //100
		System.out.println(b.j);  //100
	}
}

class C
{
	int i;
	C(int c)
	{
		i=c;
	}
}
class B extends C
{
	int j;
	B()
	{
		super(10);

		System.out.println("Let's see the value of j before j=i  "+j); //0 it is initialised to 0
		j=i;
	}
}


```

5 . Accessing the data members of parent in the child
    
    ```java
    
    
    class A
    {
        public static void main(String args[])
        {
            B obj=new B();
            obj.show();
        }
    }
    
    class B extends C
    {
       int j=20;
       void show()
       {
        System.out.println(j+"- is the value of (j instance variable)");  //20
        System.out.println("I want to access parent i"+i);  //10 It is accessible because B is the child class
       }
    }
    
    
    class C
    {
        int i=10;
    }    
```

6. Parent and child with the same named member function.


    ```java
    
    class A
    {
        public static void main(String args[])
        {
            B obj=new B();
            obj.show();
        }
    }
    
    class B extends C
    {
       
       void show()
       {
        System.out.println("show of B");  //show of B ,because instance method of parent need to be called by super()
    
       }
    }
    
    
    class C
    {
        void show()
        {
            System.out.println("show method of parent C");
        }
    }
    
    ```


5. A minute change in the above - calling parent show using super()

```java

class A
{
	public static void main(String args[])
	{
		B obj=new B();
		obj.show();
	}
}

class B extends C
{
   
   B()
   {
   	super.show();
   }

   void show()
   {
   	System.out.println("show of B");  //show of B ,because instance method of parent need to be called by super()

   }
}


class C
{
	void show()
	{
		System.out.println("show method of parent C");
	}
}



```



6. Constructor overloading.


```java



class A
{
	public static void main(String args[])
	{
		B obj=new B(10);
		B obj_b=new B(7,11);
		obj.area();
		obj_b.area();
	}
}

class B 
{
   int r,l,b;
   B(int x)
   {
   	r=x;
   }
   B(int x,int y)
   {
   	l=x;
   	b=y;
   }

   void area()
   {
   	if (r>0)
   	{
   		System.out.println(3.14*r*r);
   	}

   	if (l>0 && b>0)
   	{
   		System.out.println(l*b);
   	}
   }
}


```

6. Use of this keyword

```java


class A
{
	public static void main(String args[])
	{
	   B obj=new B(10);
	   obj.show();
	}
}

class B 
{
   int i,j;
   void show()
   {
   	System.out.println(i+j);
   }

   B(int x)
   {
   	  this(20,29);
   	  i=x;
   }

   B(int x,int y)
   {
   	this(1,1,2);
   	System.out.println("Seriously");
   	j=x+y;
   }
   B(int x,int y,int z)
   {
   	System.out.println("Yippie 3 argumensts");
   }

}



//Yippie 3 argumensts
//Seriously
//59
```


7.  Use of super and this simultaneously

```java


class A
{
	public static void main(String args[])
	{
       B obj=new B();
       obj.display();
	}
}


class B extends C
{
   void show()
   {
   	System.out.println("show of B ,child");
   }
   void display()
   {
   	show();
   	super.show();
   	this.show();
   }
}



class C
{
	void show()
	{
		System.out.println("show method of C ,parent");
	}
}


// show of B ,child
// show method of C ,parent
// show of B ,child


```



8. 

```java

class A
{
	public static void main(String args[])
	{
       B obj=new B(10);
       B obj_b=new B();

	}
}


class B extends C
{
  B()
  {
  	super(10);
  	System.out.println("This is th econstructor of B without any argument but calling C's cons with 1 argument using super");
  }

  B(int x)
  {
  	super(x,x);
 	System.out.println("This is th econstructor of B with one  argument but calling C's cons with 2 argument using super");

  }
}



class C
{
 
 C(int x)
 {
 	System.out.println("Constructor of Class C with one argument");
 }

 C(int x,int y)
 {
 	System.out.println("Constructor of class C with two arguments");
 }

}



// Constructor of class C with two arguments
// This is th econstructor of B with one  argument but calling C's cons with 2 argument using super
// Constructor of Class C with one argument
// This is th econstructor of B without any argument but calling C's cons with 1 argument using super

```
















# August 30

---
1. In order to achieve run time polymorphism we have to extend a class . If parent class
  have default constructor we can extend it without any super call. If a parent is not having
  default constructor we have to call it using __super__ keyword.

2. When we are extending a class successfully we are creating child parent relation, If a parent class
having method and child class also have method with same name  it is called method overriding. 
We can override a method in child class if :

> method name is same \
  method signature is same \
  return type differs



    3. Sometimes it is not required to override a method . We can prevent a method to be overridden by
     the help of final keyword.
                
   * Final keyword can be used with 

      > with variable \
        with class \
        with method

   1. final with variable : We can declare a final variable as 
   
       If a variable is final it will be initialiszed by contructor.
       It is vital to initialise a final variable explicitly but only once because its value will remain
       constant.


```java
       final int i
```

    2. final with class : If a class is final it can't be extended however can be used as usual.
       We can create final class as

   ```java
       final class C
       {

       }
   ```

    3. final with  method : If a method is final it can't be overridden but can be overloaded ,also can
       be used as usual when we are overriding __a method with same of higher access privilege can 
       be used__.

      
4. There are four access specifiers

>  Public \
>  Protected \
>  Default \
>  Private



5. Abstraction :  Sometimes it is vital to override a method in that case a method should be declared abstract

   1. Abstract method are only declared not defined means they are like function prototype in C.
   2. They are defined in those class who inherit the abstract class.
   3. If any class have any abstract method __the class must be declared abstract__ converse ain't true.
          i.e., If a class is abstract it ain't necessary that it will have abstract method too.
    
   4. We can't __instantiate__ abstract class because it may contain half implemented method i.e 
        **abstract method** and compiler knows it.
    
   5. Abstract class may contain abstract or non-abstract mehtod . In order to make a class complete it 
        should extend it.
    

```java
abstract void display()
{

}

```


---

# August 31

---

* Upcasting and downcasting are supported by java. In upcasting a parent class variable can hold...?

* When we are using upcasting we can use only that method/data that is part of parent and access 
through child.

* When we are upcasting we can only use that data which is part of parent.
* If a method is overridden the overridden method will be called but it should be part of parent.
* We cannot override static method because they participate in early binding.
* __dynamic method dispatch__  : When we are using upcasting we can use only methods of parent. In order
to use child methods we have to downcast it . Downcast may fail  


* Parent class should have display() method too.

```java
class A 
{
  public static void main(String args[])
  {
     C c=new B();  //upcasting
     c.display();
  }
}

class B extends C 
{
  void display()
  {
    System.out.println("This is the display of B - i.e child");
  }
}

class C
{
  void displayy()
  {
    System.out.println("This is display of C i.e parent");
  }
}


// A.java:6: error: cannot find symbol
//      c.display();
//       ^
//   symbol:   method display()
//   location: variable c of type C
// 1 error

```

* Above error is fixed

```java
class A 
{
  public static void main(String args[])
  {
     C c=new B();  //upcasting
     c.display();
  }
}

class B extends C 
{
  void display()
  {
    System.out.println("This is the display of B - i.e child");
  }
}

class C
{
  void display()
  {
    System.out.println("This is display of C i.e parent");
  }
}

// This is the display of B - i.e child
```

* Now to use call display of C we have to downcast.
---


* Downcast but fail because holding reference of B but casted to D.

* We can't instantiate abstract class but its reference variable can be created.
* We can treat abstract class as a super class and concept of upcasting can be used.



* Abstract class using the concept of downcasting

```java
class A 
{
  public static void main(String args[])
  {
    C c;
    c=new Circle();
    c.area();
  }
}

class Circle extends C
{
  void area()
  {
    System.out.println("The area of circle is "+3.14*10*10);
  }
}



abstract class C
{
  abstract void area();
}

// The area of circle is 314.0


```

* This won't call the display of child

```java

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

}

class C
{
  void display()
  {
    System.out.println("display o f C");
  }
}

// display o f C

```

* This will call the display of child 

```java
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

//display of B
```

* B can't be cast to D

```java
class A 
{
  public static void main(String args[])
  {
    C c=new B();  //upcasting
    c.show1();

    B b=(B)c;   //downcast
    b.show1();

    D d=(D)c;
    d.show1();
  }
}

class D extends C 
{
  void show1()
  {
    System.out.println("D");
  }
}

class B extends C 
{
  void show1()
  {
     System.out.println("B");
  }
}

class C 
{
  void show1()
  {
    System.out.println("C");
  }
}
```

* 



---



# Sept 5

1. Array is a collection of similar data type. Arrays are object in java as well as we 
can create array of obejct in java as well. We can declare array locally as well as a part of class.

> We can declare an array as well as initialize it as a variable. \
 There is strict upper bound check in java means if we are having 5 elements we can use only those
  memory locations which are already initialized . \
  We can initialize an  array later on by providing memory using new keyword.\
  int [] array; Leads to faster execution?\
  We can create 2D arrays as 1D arrays\
  
   * 2D arrays are __collection of 1D arrays__ in form of rows and columns.

```java

int a=10;
int array_a={a,a,a,a,a};
int array_b={{a,7,11,13},{a,9,8,7,6},{a},{a,12,7,6,99}}

```

# Sept 6

1. __Variable length arguments__

We can use variable length arguments passed into a method after jdk1.5

```java
 
 void show(int ...x)
 {

 }
 or 
 void show(object ...x)
 {

 }

```

* Consider the following example


```java
class Args
{
  public static void main(String[] args) {
    B b=new B();
    int a[]={7,4,46,344};
    b.show(10,a);
  }
}

class B 
{
  void show(int z,int ...x)
  {
    System.out.println(z);
    System.out.println(x);

    for(int i:x)
    {
      System.out.print(i+"  ");
    }

  }
}


// 10
// [I@368239c8
// 7  4  46  344
```




---

## An object can be final but it's underlying variables can still be changed.


2. Consider the final array. Array is final but still we can change it's elements.


```java
class Args
{
  public static void main(String[] args) {
    B b=new B();
    b.show();
    b.a[3]=999;
    System.out.println("After changing the values-----------------");
    b.show();
  }
}

class B 
{
  final int a[]={12,34,46,65,34};


  void show()
  {
    for(int i:a)
    {
      System.out.println(i);
    }
  }
}


// 12
// 34
// 46
// 65
// 34
// After changing the values-----------------
// 12
// 34
// 46
// 999
// 34 

```


3. We can create array of objects too.

















4. Passing an array to the function

```java
import java.io.*;

class Args
{
  public static void main(String[] args) {
    int a[]={};
    System.out.println(a);
    B obj=new B();
    obj.show(10,20);
  }
}

class B
{
  void show(int ...x)
  {
    System.out.println(x.length);

    for (int i : x) {
      System.out.println(i);
    }
  }
}
```

5. If we are passing an entire array to a function using ... then the array must be the last argument
while calling the function. The following void show() can't be defined as .

```java

void show(int ...x,int z)
{
    //error
}

```

```java

import java.io.*;

class Args
{
  public static void main(String[] args) {

    int array[]={1,2,3,4,5};
    B obj=new B();
    obj.show(7,array);
  }
}

class B
{
  void show(int z,int ...x)
  {

    System.out.println("Z =  "+z);

    for (int i : x) {
      System.out.print(i+"      ");
    }
  }
}

// Z =  7
// 1      2      3      4      5
```


6. The arguments passed during command line can be final

```java


class Args
{
  public static void main(final String ...args) {

    System.out.println("Arguments passed");
    System.out.println("--------");
    System.out.println(args);


  }
}



```

7. Final obj can't be assigned new memory location

```java

class Args
{
  public static void main(final String ...args) {

    final B obj=new B();
    obj=new B();


  }
}

class B
{
  final int i=3;
}
```


8. Even if the array is Final it too can't be assigned new memory

```java

class Args
{
  public static void main(final String ...args) {

    B obj=new B();


    obj.a=new int[4];


  }
}

class B
{
  final int a[]={1,2,3,4,5,6,8};
}
```


9. Even though the array is declared final we can still update it's values

```java


class Args
{
  public static void main(final String ...args) {


    B obj=new B();


      for (int i : obj.a) {
      System.out.print(i+"   ");
    }


    System.out.println("Before-------------------");

    System.out.println("After------------------------");
    obj.a[3]=7;
    for (int i : obj.a) {
      System.out.print(i+"   ");
    }

  }
}

class B
{
  final int a[]={1,2,3,4,5,6,8};
}







// 1   2   3   4   5   6   8   Before-------------------
// After------------------------
// 1   2   3   7   5   6   8


```

10. The default values assigned to an array elements are null.

```java


class Args
{
  public static void main(final String ...args) {


    B b=new B();
    B c=new B();

    B array[]=new B[2];
    System.out.println(array[0]);

    System.out.println(array[1]);


  }
}

class B
{

}





```


12. 

```java


class Args
{
  public static void main(final String ...args) {


    B b=new B();
    B c=new B();

    B array[]=new B[2];

    array[0]=b;
    array[1]=c;

    System.out.println(array[0]);

    System.out.println(array[1]);
  }
}

class B
{

}



B@4aa8f0b4
B@9e89d68



```














. Overriding the toString method of String  class.


```java
class Args
{
  public static void main(String[] args) {
    

    char array[]={'a','b','c','d','e','f'};
    String1 obj=new String1(array);
    System.out.println(obj);
}
}


class String1
{
  String1(char f[])
  {

  }

  public String toString()
  {
    return "yie";
  }
}
```


# sept 7

1. We can initialize a string object by some string literal constant also.
   String s="abc"

   * We can use several method of string to manipulate string object

```java


String s="vale";
char c=s.charAt(0);  //v
int length_s=s.length()

```



2. Comparision of two string objects can be done in the following ways-

> ==     always checks reference and returns boolean value  \
> equals() checks reference when the equals() method belongs to  object class but it checks values
of two string objects when equals() method belong to String class \
e> compareTo() returns 0 when if two values are identical otherwise first non-matching character
ascii difference. __If one string is subset of another length difference is returned__ .


```java
class A
{
  public static void main(String[] args) {
    String s1="accd";
    String s2="acc";

    System.out.println("This is ==      :      "+(s1==s2));  //false
    System.out.println("Equals method   :   "+s1.equals(s2)); //false
    System.out.println("Compareto method:   "+s1.compareTo(s2)); // 1
  }
}




class A
{
  public static void main(String[] args) {
    String s1="acc";
    String s2="acc";

    System.out.println("This is ==      :      "+(s1==s2));//true
    System.out.println("Equals method   :   "+s1.equals(s2));//true
    System.out.println("Compareto method:   "+s1.compareTo(s2));//0
  }
}

```

* Check the difference

If we are initialising a string by some string literal constant as

```java
String s1="abc";
String s2="abc"; 
```
   * Both refer to the same thing.
   * In this case memory to abc will be allocated by __JVM__ in separate __area of heap String constant pool__.



```java

class A
{
  public static void main(String[] args) {
    String s1="acc";
    String s2="acc";

    System.out.println("This is ==      :      "+(s1==s2));   //true
    System.out.println("Equals method   :   "+s1.equals(s2));//true
    System.out.println("Compareto method:   "+s1.compareTo(s2));//0
  }
}

```

   * But when memory is assigned with 
help of new keyword ,a new memory location is created always which unequivocably different from String s="hola".


```java

class A
{
  public static void main(String[] args) {
    String s1=new String("acc");
    String s2=new String("acc");

    System.out.println("This is ==      :      "+(s1==s2));   //false
    System.out.println("Equals method   :   "+s1.equals(s2));//true
    System.out.println("Compareto method:   "+s1.compareTo(s2));//0
  }
}
  
```

# 14 September

---

1. Boxing converts a primitive data type to an object. __autoboxing__ do this by
   default.
   > The Vector class in java work internally as array of objects.\
     It have various methods to perform various operations.\
      size() method tells the size of vector\
      addElement(argument)  adds element at end in the vector\
      add(argument) also adds element to vector.
      
     


```java
import java.util.*;


public class A
{
	public static void main(String args[])
	{
		Integer i=9;  //autoboxing
		Double d=11.9;
		String s="icardi";

		Vector v=new Vector();
		v.addElement(i);
		v.addElement(d);
		v.addElement(s);
		System.out.println(v);
	}
}

//D:\GEU\Semester_fifth\core-java-concepts>javac A.java
//	
//
//		D:\GEU\Semester_fifth\core-java-concepts>java A
//		[9, 11.9, icardi]

```


---



2. Fix the given error


	Note: A.java uses unchecked or unsafe operations.
	Note: Recompile with -Xlint:unchecked for details.
	
	
3. HashSet performs similar to Vector but it never store objects with same reference
 or same values aren't stored in __HashSet__.
 
 > add() appends an element at the end.\
   addElement() doesn't works here?
    
    
4. We can't add two objects of Object class or any other class. Inorder to perform
 a mathematical operation on integer or double we must __downcast them__.
 
 ```java

import java.util.*;
        
        
        public class A
        {
        	public static void main(String args[])
        	{
        
        		B obj=new B();
        		Object o=obj.show(7);
        
        		System.out.println(o+o);
        
        	}
        }
        
        
        class B
        {
        	Object show(Integer i)
        	{
        			return i;
        	}
        
        }
        
        
        A.java:12: error: bad operand types for binary operator '+'
        		System.out.println(o+o);
        		^
        		first type:  Object
        		second type: Object
        		1 error
```


> On resolving above by downcasting.


1. __Approach One__

```java

import java.util.*;


public class A
{
	public static void main(String args[])
	{

		B obj=new B();
		Integer o=obj.show(7);

		System.out.println(o+o);



	}
}


class B
{
	Integer show(Integer i)
	{
			return i;
	}

}




```


2. __Approach two__


```java

```


5. The given array of objects perform same as Vector class object. This 
implies that internally vector class uses object array.

 > Since memory was assigned with help of new keyword , the compiler always
   initialize the objects with null values.

```java

import java.util.*;


public class A
{
	public static void main(String args[])
	{

		B obj=new B();
		obj.add("a");
		obj.add("b");
		obj.add("c");
		obj.display();



	}
}


class B
{
	static int m=0;

	Object o[]=new Object[10];

	void add(Object i)
	{
		o[m++]=i;
	}

	void display()
	{
		// Since o is an array , we can iterate over it
		for (int i=0;i<o.length;i++)
		{
			System.out.println(o[i]);
		}
	}
}


	a  
	b
    c
		null
		null
		null
		null
		null
		null
		null



```

* We can now say that internally array of object is stored as we are able to 
  store Integer,Double,String in a single array.

```java
import java.util.*;


public class A
{
	public static void main(String args[])
	{

		B obj=new B();
		obj.add("a");
		obj.add(3.34);
		obj.add(4);
		obj.display();



	}
}


class B
{
	static int m=0;

	Object o[]=new Object[10];

	void add(Object i)
	{
		o[m++]=i;
	}

	void display()
	{
		// Since o is an array , we can iterate over it
		for (int i=0;i<o.length;i++)
		{
			System.out.println(o[i]);
		}
	}
}




D:\GEU\Semester_fifth\core-java-concepts>java A
		a
		3.34
		4
		null
		null
		null
		null
		null
		null
		null

		D:\GEU
		
		
```


#Questions fix me

```java
import java.util.*;


public class A
{
	public static void main(String args[])
	{


		String a="abc332k23";
		String answer[]=new String[10];

		int len=a.length();

		while(len!=0)
		{
			if (c.isDigit())
			{
				Character c = Character.parseInt(a(len));
				System.out.println(c);
			}

			len--;
		}


	}
}








//import java.util.*;
//
//
//public class A
//{
//	public static void main(String args[])
//	{
//
//		B obj=new B();
//		obj.add("a");
//		obj.add(3.34);
//		obj.add(4);
//		obj.display();
//
//
//
//	}
//}
//
//
//class B
//{
//	static int m=0;
//
//	Object o[]=new Object[10];
//
//	void add(Object i)
//	{
//		o[m++]=i;
//	}
//
//	Object addElementsAt(int i)
//	{
//
//	}
//
//	void display()
//	{
//		// Since o is an array , we can iterate over it
//		for (int i=0;i<o.length;i++)
//		{
//			System.out.println(o[i]);
//		}
//	}
//}
//
//
//
//

```