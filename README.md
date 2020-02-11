# DDA




# Breshnam

```C
#include<stdio.h>
#include<conio.h>
#include<math.h>
#include<graphics.h>


int main(){

   int gd=DETECT,gm;

   int p;
   int x1,x2,y1,y2,dx,dy,xstart,ystart,xend,yend;
   int k=200,h=300;
	clrscr();
   initgraph(&gd,&gm,"C:\\TC\\BGI");

   printf("Enter the coordinates    x1,y1   and x2,y2 respectively\n");
   scanf("%d%d%d%d",&x1,&y1,&x2,&y2);


   if(x1<x2){
     xstart=x1;
     ystart=y1;
     xend=x2;


   }
   else{

     xstart=x2;
     ystart=y2;
     xend=x1;
   }

   dx=abs(x2-x1);
   dy=abs(y2-y1);
   putpixel(xstart,ystart,3);

   p=2*dx-dy;

   line(h,k,640,k);
   line(h,k,h,10);




   while(xstart<xend){
     if(p<0){
       p=p+2*dy;
       xstart+=1;
     }
     else{
      p=p+2*dy-2*dx;
      xstart+=1;
      ystart+=1;
     }

     putpixel(h+xstart,k-ystart,3);

   }

   getch();


 return 0;

}


```


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











# sept 12 

---

GitHub supports emoji! :+1: :sparkles: :camel: :tada: :rocket: :metal: :octocat: 


1. __Wrapper Class__ : We can convert one type to another by the help of *Wrapper Class* . Each *primitive 
data type* corresponds to a *Wrapper class*. 

Primitive data type | Wrapper class
 ------------ | ------------
 bytes 8  | Byte
 short 16 | Short
 int   32 | Integer
 long 64  | Long
 float 32 | Float
 double 64| Double
 char 16  | Character
 boolean 1| Boolean

   * We can use these classes to convert one type to another. We can convert primitive integer into corresponding object by the help of *Integer* wrapper class.

2. __Boxing__   :octocat:  Boxing is converting primitive data type to object.

```java
int i=7;
Integer iobj=new Integer(i);        //Boxing

```
> The object can further be converted to string  using, further we can reverse it using StringBuffer.

```java
String s=iobj.toString();
```
\

 Before JDK 1.5 we can't convert wrapper class object directly as 
```java
Integer i=new Integer(5);
int x=i.intValue();
```
\

This is to mention the use of parseInt as well as StringBuffer
```java
class A
{
	public static void main(String[] args) {



		Integer tag=new Integer(4);
		int k=tag.intValue();              //unboxing
		System.out.println(k*10);


		int initialvalue=123456789;
		Integer valueobj=new Integer(initialvalue);

		String s=valueobj.toString();
		System.out.println(s);
		StringBuffer obj=new StringBuffer(s);
		obj.reverse();
		System.out.println("This is the value of StringBuffer object :"+obj);
		System.out.println("This is the value of s                   :"+s);

		String m=obj.toString();
		System.out.println(m);
		int ui=Integer.parseInt(m);	
		System.out.println(ui-1);
	}
}
```


3. **Unboxing** : is converting object to a primitive data type.

> wrapperclassobj.datatypeValue();

```java
		Integer tag=new Integer(4);
		int k=tag.intValue();
		System.out.println(k*10);
```


4. **Autoboxing** and **Autounboxing** : In autoboxing we can assign a primitive directly to object and vice versa for the latter.

```java
	Integer i=new Integer(5);  //boxing
	Integer i=7;               // auto boxing

	int k=i;    			   // auto unboxing
	int k=i.intValue();        // unboxing         

```

5. We can use wrapper class object to call its method. Wrapper class may contain some static methods.

```java

Integer i=7;   // Auto boxing
String s=Integer.toString(7);

```

```java
class A
{
	public static void main(String[] args) {
		Integer value=7654;  //autoboxing
		System.out.println(value*100);


		//  Each wrapper class have a static method toString().

		String s=value.toString();
		System.out.println(s);
		StringBuffer sobj=new StringBuffer(s);
		sobj.reverse();

		String m=sobj.toString();
		System.out.println("This is the string m"+m);
		value=Integer.parseInt(m);
		System.out.println(value*100);


			Integer I=7;
		String answer=I.toString();
		// String ui=Integer.valueOf(I);
		System.out.println(answer);
		System.out.println("");

		String binary=Integer.toBinaryString(7);
		System.out.println(binary);
	
	


	}
}


```

6. Character wrapper class functions

```java
class A
{
	public static void main(String[] args) {


    	Character grade='u';
  	   System.out.println(Character.isDigit(grade));
  	   System.out.println(Character.isLetter(grade));


  	   Character c='*';
  	   System.out.println(Character.isDigit(c));
  	   System.out.println(Character.isLetter(c));

  	   if (Character.isLowerCase(grade))
  	   {
  	   	System.out.println("yeah");
  	   }
  	   else
  	   {
  	   	System.out.println("nope");
  	   }
  	   System.out.println(Character.toUpperCase(grade));
  	   String m="kajdfsk";
  	   System.out.println(m.toUpperCase());

  	   StringBuffer obj=new StringBuffer("Check this one OUT");  // Convert this to uppercase ?

	}
}


```

> **This output is weird** 

```java

class A
{
	public static void main(String[] args) {

		Character grade='A';
		char c='A';
		System.out.println(grade+c);      // 130
		System.out.println(c);				// A
		System.out.println(grade);			// A

	}
}


```

Guess the output\

```java
class A
{
	public static void main(String[] args) {

		Character grade='A';
		char c='A';
		System.out.println(grade+c);      // 130
		System.out.println(c);				// A
		System.out.println(grade);			// A

		String result="";
		result+=c;
		System.out.println(result);
		result+=grade;
		System.out.println(result);

	}
}


```
:camel:      :tada:       :metal:

> If we want to print the values as it is use "" **prior** to adding (c+d) otherwise ready for addition
of the characters ascii value.

```java
class A
{
	public static void main(String[] args) {


			char c='A';
			char d='B';
			System.out.println(c+d);
			System.out.println(" "+c+d);

	}
}

```

This is the another one \

```java

class A
{
	public static void main(String[] args) {


			char c='1';
			char d='1';
			System.out.println(c+d);          //98
			System.out.println(" "+c+d);      //11

	}
}


```
This one is __weird__

```java

			char ui='(';          //'*','$'
			int uk=Character.getNumericValue(ui);
			System.out.println(uk);   // -1

```


7. char cannot be __dereferenced__         :rocket:

```java
class A
{
	public static void main(String[] args) {

		Character grade='u';


		String s=grade.toString();
		System.out.println(s);

		char c='i';
		String m=c.toString();         //char cannot be dereferenced
		System.out.println(m);

	}
}

```

---





:camel:      :rocket:    :+1:       :+2:    :tada: 

:sparkles:


---


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


# Sept 16


---

1. Create a one dimensional String array of size 3 from args CLI.

```java

class A
{
    public static void main(String[] args) {

        String answer[]=args;

        String another[]=new String[3];

        System.out.println("This is the length of another"+another.length);
        another=args;
        System.out.println("This is the length of another"+another.length);

        for (String s:answer) {
            System.out.print("  "+s);
        }

        for (String s: another) {
            System.out.print("  "+s);
        }

        System.out.println("***************************");

        for (int i = 0; i < another.length; i++) {
            System.out.print("  "+another[i]);
        }

        System.out.println("Finally   "+another.length);

    }
}


java A james hola extrems unil idn
        ot want somebody like you i only want you
        This is the length of another3
        This is the length of another13
        james  hola  extrems  unil  idnot  want  somebody  like  you  i  only  want  you  james  hola  extrems  unil  idnot
        want  somebody  like  you  i  only  want  you***************************
        james  hola  extrems  unil  idnot  want  somebody  like  you  i  only  want  youFinally   13



```



2. Store numeric value of given string into another string . No duplicates should be there.

```java

class A
{
    public static void main(String[] args) {


       String s="abc345kjs34587091383fdk9876345";
       int len=s.length();
       System.out.println(len);
       String answer="";

       int k=0;

       while(k<len)
       {
           if(Character.isDigit(s.charAt(k)))
           {
               char c=s.charAt(k);
               if (answer.contains(""+c))     // (answer.contains(c)) char cannot be converted to CharSequence
               {
                   k++;
                   continue;
               }
               else
               {

                   answer+=s.charAt(k);
                   k++;
               }


           }
           k++;
       }


       System.out.println(answer);

    }
}




```

3. StringBuffer create references

```java

class A
{
    public static void main(String[] args) {

        String as=args[0];

        StringBuffer obj=new StringBuffer(as);
        obj.reverse();
        System.out.println(obj.toString());
    
    }
}




```

#### I said perfect answer   :)

```java
class A
{
    public static void main(String[] args) {

        System.out.println(new StringBuffer(args[0]).reverse());

    }
}


```



4. __StringBuffer__

>StringBuffer is a sequences of character but mutable in nature, i.e., we can change value
of a StringBuffer obj dynamically after creation.\
We can create StringBuffer by the help its constructor by passing string.

---


5. String and StringBuffer

```java

class A
{
    public static void main(String[] args) {

        String s="yipieeeeeeeeeeeeee";
        s.concat("holaa");
        System.out.println(s.concat("hoiiiiiiiiiiiiiiiiiiii"));


        // Convert String to StringBuffer object and vice versa

        StringBuffer obj=new StringBuffer(s);
        String answer="";
        obj.reverse();
        answer=obj.toString();

        System.out.println(answer);


        // initialize 1D string array of size from CLI

        String wow[]=args;
        System.out.println("*****************");

        for (String a: wow) {
            System.out.print(" "+a);
        }

        System.out.println("*****************");

        String again[]=new String[5];
        again=args;
        for (String o: again) {
            System.out.print("  "+o);
        }


        System.out.println("*****************");


    }
}





```



6. __StringBuffer__ is mutable i.e., its value can be changed while String never changes.
StringBuffer creates a reference. In String every time new memory is assigned.
  We can join two strings using __+__ or __concat__ .
  In case of StringBuffer we can append a string to it. No new memory is created .


```java

class A
{
    public static void main(String[] args) {

        String s1=new String("abc");
        String s2=new String("abc");




        System.out.println("Using equals methods:"+s1.equals(s2));
        System.out.println("Using  double ==   : "+(s1==s2));
        System.out.println("*****************************");


        String t1="boss";
        String t2="boss";

        System.out.println("*****************************");

        System.out.println("Using equals methods:"+t1.equals(t2));
        System.out.println("oUsing  double ==   : "+(t1==t2));



        StringBuffer obj_a=new StringBuffer("hola");

        StringBuffer obj_b=new StringBuffer("hola");

        System.out.println("*****************************");

        System.out.println("Using equals methods:"+obj_a.equals(obj_b));
        System.out.println("oUsing  double ==   : "+(obj_a==obj_b));


        System.out.println("obj_a and obj_b are objects inorder to compare their values convert them to String");

        obj_a.reverse();
        obj_b.reverse();
        String sobj_a=obj_a.toString();
        String sobj_b=obj_b.toString();


        System.out.println(sobj_a);
        System.out.println(sobj_b);

        System.out.println("*****************************");
        System.out.println("Using equals methods:"+sobj_a.equals(sobj_b));
        System.out.println("oUsing  double ==   : "+(sobj_a==sobj_b));





    }
}







```






7.  A minute difference

```java
class A
{
    public static void main(String[] args) {
        B obj_a=new B("hola");
        B obj_b=new B("hola");
        System.out.println(obj_a.equals(obj_b));  // equals of Object class is called rather than of String class
        System.out.println("******************");
        System.out.println(obj_a==obj_b);   // this always checks the reference

    }
}

class B
{
    B(String x)
    {

    }
}









```


8. __reverse__ a string

```java

class A
{
    public static void main(String[] args) {

        B obj=new B();

        System.out.println(obj.reverse("malayalam"));
    }
}



class B
{

    String reverse(String m)
    {
        String answer="";
        int len=m.length()-1;
        while(len>=0)
        {
            System.out.println(len);
            answer+=m.charAt(len);
            len--;
        }
        return answer;
    }

}





```

9. Fix the error

```java
class A
{
    public static void main(String[] args) {

        String reverse(String "hi")
        {
            String answer="";
            int len=m.length()-1;
            while(len>=0)
            {
                System.out.println(len);
                answer+=m.charAt(len);
                len--;
            }
            return answer;
        }

    }
}



```


10. Addition of numeric values from a string

```java
class A
{
    public static void main(String[] args) {

        StringBuffer stringBuffer=new StringBuffer("Object 12345Oriented OOPs");
        int sum=0;
        String obviate="";
        System.out.println("The string is"+stringBuffer+" Its length is  "+stringBuffer.length());
        String answer="";

        for (int i = 0; i < stringBuffer.length(); i++) {
            if(Character.isDigit(stringBuffer.charAt(i)))
            {
                answer+=stringBuffer.charAt(i);
                obviate=""+stringBuffer.charAt(i);
                int k=Integer.parseInt(obviate);
                sum+=k;

            }
        }

        System.out.println(answer);
        System.out.println(sum);
    }
}
```

11. Vector

```java

import java.util.*;

class A
{
    public static void main(String[] args) {
        Vector list=new Vector();
        int len=args.length;

        for (int i = 0; i < len; i++) {
            list.addElement(args[i]);
        }

        System.out.println(list);


        list.insertElementAt("MERN",2);
        int size=list.size();





        String listArray[]=new String[size];
        list.copyInto(listArray);         // Copies all elements of list into Array

        for (String a:listArray) {
            System.out.println(a);
        }
    }
}


```


---

# Wrapper classes


1. Creating Object of primitive data type and vice-versa

---
   
   *  __Converting primitive to object__


```java

           Integer integer=new Integer(7);
           Float afloat=new Float(3.4F);
           Double adouble=new Double(43.43);
           Long along=new Long(2333433432323343l);
   
   
           System.out.println(integer);
           System.out.println(adouble);
           System.out.println(afloat);
           System.out.println(along);

```   
   * __Converting object to primitive__
    
```java

        // Converting to object

        int i=integer.intValue();
        float pi=afloat.floatValue();
        long lo=along.longValue();
        double big=adouble.doubleValue();


        System.out.println(i);
        System.out.println(pi);
        System.out.println(lo);
        System.out.println(big);

```


---

  * __Converting primitive to string using  toString()__
  
```java


        
        a=Integer.toString(i);
        b=Float.toString(pi);
        c=Long.toString(lo);
        d=Double.toString(big);

```
  
  * Converting string objects to primitive values using __static method valueof()__
  
```java
       intvalue=Integer.valueof(str)
       floatvalue=Float.valueof(str)
```
---


  *  __Converting Numeric Strings to primitive data types using parsing methods__

  
```java

        // Converting Numeric Strings to primitive data types using parsing methods
        
        String str="12";
        int ii=Integer.parseInt(str);
        long jj=Long.parseLong(str);

        System.out.println("********************");
        System.out.println(ii);
        System.out.println(jj);

```

```java

import java.util.*;

class A
{
    public static void main(String[] args) {

        // Converting primitive to object

        Integer integer=new Integer(7);
        Float afloat=new Float(3.4F);
        Double adouble=new Double(43.43);
        Long along=new Long(2333433432323343l);


        System.out.println(integer);
        System.out.println(adouble);
        System.out.println(afloat);
        System.out.println(along);


        // Converting to object

        int i=integer.intValue();
        float pi=afloat.floatValue();
        long lo=along.longValue();
        double big=adouble.doubleValue();


        System.out.println(i);
        System.out.println(pi);
        System.out.println(lo);
        System.out.println(big);

        String a=Integer.toString(i);
        String b=Float.toString(pi);
        String c=Long.toString(lo);
        String d=Double.toString(big);



        int primitiveIntFromString=Integer.valueOf(a);
        System.out.println("********************");
        System.out.println(primitiveIntFromString);
        
        
        
        // Converting Numeric Strings to primitive data types using parsing methods
        
        String str="12";
        int ii=Integer.parseInt(str);
        long jj=Long.parseLong(str);

        System.out.println("********************");
        System.out.println(ii);
        System.out.println(jj);

    }
}

```




---





# sept 18  :+3:

---
1. A package is a separation of classes

 by convention all package name must be small. If we are not creating user defined package in that case
 all the classes will be part of default package representing current :+4: ?.

 > One **class can use another class of same package** with any import statement.\
 We can create our own package by using package creation as package followed by __package name__.\
 :+8: Package creation should be the first statement of java program as package followed by package name.\
 The package creation statement is placed even before import statement.\
 We can create a package folder by the help of conditional compilation.\
 A package can have n number of of classes. A class in same compilation unit can use another class. :+2:
 

---


# sept 19 :rocket:

---

1. We can place number of classes within a package and one class can access another class directly without
any import . In order to use one package class by another package class we have to import a class successfully. __default means accesssible only within package__. :+1: 

2. If class is public its method are not by default public and we know the meaning of default is only accessible within package.

  Access specifier | public | protected | default | private 
  ------------ | ------------ | ------------ | ------------ | ------------
 |same class same package|yes|yes|yes|yes|
 |diff class same package|yes|yes|yes|no|
 |subclass same package|yes|yes|yes|no|
 |diff class diff package|:+1:|:+1:|:+1:|:+1:|
 |sub class diff package|:+1:|:+1:|:+1:|:+1:|
 ||||||||



1. __same class same package__

 ```java

 class A
{
	public static void main(String[] args) {
		zero();
		first();
		second();
		third();
		}

		static void zero()
		{
			System.out.println("within default method  |same class | same package");
		}
		public static void first()
		{
			System.out.println("within public method first  |same class | same package|");
		}
		protected  static void second()
		{
			System.out.println("within protected method second |same class |same packge");
		}
		private static  void third()
		{
			System.out.println("within private method third |same class |same package");
		}

	
}



within default method  |same class | same package
within public method first  |same class | same package|
within protected method second |same class |same packge
within private method third |same class |same package

```

2. different class same package

 	
	*this is with an error, :-1: error because private method is not accessible within different class
	even if the package is same*

```java
class A
{
	public static void main(String[] args) {
		
		B obj=new B();

		obj.zero();
		obj.first();
		obj.second();
		obj.third();
	
}

}

class B
{

		static void zero()
		{
			System.out.println("within default method  |same class | same package");
		}
		public static void first()
		{
			System.out.println("within public method first  |same class | same package|");
		}
		protected  static void second()
		{
			System.out.println("within protected method second |same class |same packge");
		}
		private static  void third()
		{
			System.out.println("within private method third |same class |same package");
		}

}


// A.java:10: error: third() has private access in B
//                 obj.third();
//                    ^
// 1 error

```

	* this is without an error :+1: , Here rest three public,protected,default are available.*


```java
class A
{
	public static void main(String[] args) {
		
		B obj=new B();

		obj.zero();
		obj.first();
		obj.second();
	
	
}

}

class B
{

		static void zero()
		{
			System.out.println("within default method  |different | same package");
		}
		public static void first()
		{
			System.out.println("within public method first  |different class | same package|");
		}
		protected  static void second()
		{
			System.out.println("within protected method second |different class |same package");
		}
		

}


D:\GEU\Semester_fifth\core-java-concepts\lecture>java A
within default method  |different class | same package
within public method first  |different class | same package|
within protected method second |different class |same package
```



3. subclass same package

 **private method is not available for the subclass**

```java
class A
{
	public static void main(String[] args) {
		
	
	C obj=new C();
}

}

class B 
{

		static void zero()
		{
			System.out.println("within default method  |sub class | same package");
		}
		public static void first()
		{
			System.out.println("within public method first  |sub class | same package|");
		}
		protected  static void second()
		{
			System.out.println("within protected method second |sub class |same packge");
		}
		private static void third()
		{
			System.out.println("within private method third | sub class |same package");
		}
		

}
class C extends B
{
	{
		zero();
		first();
		second();
		third();
	}
}



A.java:39: error: cannot find symbol
                third();
                ^
  symbol:   method third()
  location: class C
1 error

```
  **This is valid**

```java
class A
{
	public static void main(String[] args) {
		
	
	C obj=new C();
}

}

class B 
{

		static void zero()
		{
			System.out.println("within default method  |sub class | same package");
		}
		public static void first()
		{
			System.out.println("within public method first  |sub class | same package|");
		}
		protected  static void second()
		{
			System.out.println("within protected method second |sub class |same packge");
		}

		

}
class C extends B
{
	{
		zero();
		first();
		second();

	}
}



within default method  |sub class | same package
within public method first  |sub class | same package|
within protected method second |sub class |same packge

```

4. Different class different package

  *class English within package languageA*

```java

package languageA;

public class English
{
	public static void main(String[] args) {


	}

		static void zero()
		{
			System.out.println("within default method  |different class | different package");
		}
		public static void first()
		{
			System.out.println("within public method first  |different class | different package|");
		}
		protected  static void second()
		{
			System.out.println("within protected method second |different class |different packge");
		}
		private static void third()
		{
			System.out.println("within private method third  | different class | different package");
		}

}



```
	


5. **subclass different package**


	* class Spanish within package languageB*

> In different class diffferent package only public method is available.

```java
package languageB;
import languageA.*;
public class Spanish
{
	public static void main(String[] args) {
		English obj=new English();

		obj.zero();
		obj.first();
		obj.second();
		obj.third();
	}
}



Spanish.java:8: error: zero() is not public in English; cannot be accessed from outside package
                obj.zero();
                   ^
Spanish.java:10: error: second() has protected access in English
                obj.second();
                   ^
Spanish.java:11: error: third() has private access in English
                obj.third();
                   ^
3 errors

```

	*If we extend English in spanish then public and protected methods are accessible*

```java
package languageB;
import languageA.*;
public class Spanish extends English
{
	public static void main(String[] args) {
		English obj=new English();

		obj.zero();
		obj.first();
		obj.second();
		obj.third();
	}
}





Spanish.java:8: error: zero() is not public in English; cannot be accessed from outside package
                obj.zero();
                   ^
Spanish.java:11: error: third() has private access in English
                obj.third();
                   ^
2 errors
```


---

















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









# sept 20     :+1:     Exception Handling

---

1. __Exception Handling__: Exceptions are abnormal conditions arising in a code segment at run time.
    There may be two type of errors 
    > Compile time \
      Run time

* Compile time errors are like missing semicolons and can't be handled.
* Runtime errors are called exceptions and can be handled by using mechanism like try,catch,throw,finally and throws.
* Exception should be handled and can be handled only once.
* Handling of exception means we are telling user the cause and place of exception. Exception may occur
it is not suer it will.
* There are certain predefined exceptions for specific conditions like __Arithmetic__,__ArrayIndexOutOfBounds__.

* **All exceptions are in the form of Object**.

 *Throwable*

Error | Exception
 ------------ | ------------
   |   Runtime
 IOException,FileNotFound |   Arithmetic,ArrayIndexOutOfBounds,NullPointer 

 NumberFormatException


* We can handle exception explicitly by the help of try and catch. We have to put lesser code in try
that may generate an exception.

* **Java is robust because of Strong exception handling concepts**.

* try can be used in the following ways:

1. The first one

```java

try
{

}
catch(Exception e)
{

}

```

2. Second one

```java
try
{

}
catch (ExceptionType1 e1)
{

}
catch( ExceptionType2 e2)
{

}
```

3. Third 

```java

try
{

}
catch(Exception e)
{

}
finally
{}
```

4. Fourth

```java

try
{

}
catch (RuntimeException e)
{

}
catch()
{

}
....
catch(Exception e)
{

}
finally
{

}
```

5. Fifth one :sparkles:

```java

```

---



2. We can nest one try within another . The outer try can use outer  catch but **outer try can't use
inner catch.**

```java

class A
{
	public static void main(String[] args) {
		
		System.out.println("1");
		try{
			System.out.println("2");
			try
			{
				System.out.println(5/0);
			}
			catch(NullPointerException obj)
			{
				System.out.println(obj);
			}
			System.out.println("3");
		}
		catch(Exception obj)
		{
			System.out.println(obj);
		}
		System.out.println("5");

	}
}

// 1
// 2
// java.lang.ArithmeticException: / by zero
// 5

```



3. We can use finally block **with a try or with try catch** . 

> **Finally block never handle exception.** It is a block which is always executed . \
  Exception occurs or not it doesn't matter for finally to get executed.






# sept 21 

---

1. We can use a finally block without __catch__

> Finally never handles an exception

__Syntax__

```java

try{

}
finally
{

}
```
  \
  If there is no catch __finally is called by JVM before control is passed to try__

  :sparkles: ?          ?  Fix this issue.

```java

class A
{
	public static void main(String[] args) {
		
		System.out.println("first");
		try
		{
			System.out.println("I am within try"+5/0);
		}

		finally
		{
			System.out.println("Within finally");
		}

		System.out.println("Last");
	}
}

// first
// Within finally
// Exception in thread "main" java.lang.ArithmeticException: / by zero
//         at A.main(A.java:9)

```


---



# sept 23


---

1. :rocket:  We can create our own exception and it can be thrown on some user condition. 
	
 > We can throw only those instances whcih are of type throwable.\
 We can throw an exception by the help of throw keyword.\

```java
class A
{
	public static void main(String[] args) {
		
		B b=new B();
		b.calculate(11000,10);
		b.calculate(1000,20);

// 		110000
// Exception in thread "main" java.lang.RuntimeException: RuntimeException obj
//         at B.calculate(A.java:16)
//         at A.main(A.java:7)
		
	}
}

class B
{
	void calculate(int basic,int days)
	{
		RuntimeException obj=new RuntimeException("RuntimeException obj ");
		if(basic>=10000)
			System.out.println(basic*days);
		else
			throw obj;       // explicit
	}
}
```
The exception thrown can be checked or unchecked.\
If we are not able to handle exception under category checked using try block we have to use throws keyword.


2. Invalid 

```java

class A
{
	public static void main(String[] args) {
		
		B b=new B();
		b.calculate(11000,10);
		b.calculate(1000,20);

	}
}

class B
{
	void calculate(int basic,int days)
	{
		Exception obj=new Exception("RuntimeException obj ");
		if(basic>=10000)
			System.out.println(basic*days);
		else
			try
		{
			throw obj;       // explicit
		}
		catch(RuntimeException e)
		{
			System.out.println(e.getMessage());
		}
	}
}

// java:22: error: unreported exception Exception; must be caught or declared to be thrown
//                         throw obj;       // explicit
//                         ^
// 1 error

```
3. This is valid

```java
class A
{
	public static void main(String[] args) {
		
		B b=new B();
		b.calculate(11000,10);
		b.calculate(1000,20);

	}
}

class B
{
	void calculate(int basic,int days)
	{
		RuntimeException obj=new RuntimeException("RuntimeException obj ");
		if(basic>=10000)
			System.out.println(basic*days);
		else
			try
		{
			throw obj;       // explicit
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
```

4. 
---





# sept 23


* Largest palindromic string


```java


class A
{
	public static void main(String[] args) {

		String s="abababaabbabacccaaaabaaaaiaaaaabaaaaa1111112111111";
		System.out.println(s.length());
		System.out.println(longestPalindrome(s));

}

		 public static String interMediate(String s,int left,int right)
		{
			if (left>right) return null;

			while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
			{

				left--;
				right++;
			}

			return s.substring(left+1,right);
		}


		public static  String longestPalindrome(String s)
		{
			if (s==null) return null;
			String longest=s.substring(0,1);
		
			for (int i=0; i<s.length()-1 ; i++) {
			 	String palindrome=interMediate(s,i,i);
			if(longest.length()<palindrome.length())
			 {
				longest=palindrome;
			 }

			 	palindrome=interMediate(s,i,i+1);
			 	if(palindrome.length()>longest.length())
			 	{
			 		longest=palindrome;
			 	}

		}

			return longest;
		}


      	

}



```


---

# Sept 26

1. If a method is throwing checked or unchecked exception it should be handled by the help or try
catch. If exception is under category unchecked like runtime exception it is not mandatory to provide 
try and catch at compile time. __JVM__ can handle it :+1:   
 __If exception are under category checked it is vital to tell at compile time using try catch that how
 you will handle it at runtime__

 > If a method is not capable to handle exception under category checked it must guard to all calling
 methods using throws keyword.\
 If a method is not throwing exception and using throws clause it should be handled properly.


2. A **Constructor** can also throw an exception.

```java

public class A
{
	public static void main(String[] args) {
		
		try
		{
		B b=new B();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}

	
	}
}


class B
{	
	B() throws Exception
	{

	}

}
```

3. We can throw __Custom exceptions__ on some user condition , a method can throw more than 
one exception checked or unchecked , implicitly or explicitly.
 If it is under category checked it should be handled at compile time.

4. We we create object of a class and print that object it internally calls **toString()** method
 and prints hexadecimal address using hex method.

```java

public class A
{
	public static void main(String[] args) {
		
	
		B obj=new B();
		long l=obj.hashCode();
		String hexstring=Integer.toHexString((int)l);
		String name=obj.getClass().getName();
		System.out.println(name+"@"+hexstring);

		System.out.println(obj);

	}
}


class B
{	


}

B@4cc77c2e
B@4cc77c2e



```


---



# sept 27

    :disappointed:

---

 :expressionless: File Operations :unamused:
   

1. We can manage input output operation on some 
standard input output devices by the help of several stream classes. The two types of stream classes are :

> :+1:  Character stream    :smile: Byte stream(8 bit data) \
 The two predefined streams can be used directly to manipulate iput output operation. These are
 	__system.in__ _output stream_ and __system.out__ , __system.err__ ( _input stream_) . \
 __System.in__ is by default associated with *keyboard* while __System.out__ and __System.err__ are associated with *monitor*.




2. We can redirect output of type *out* to a file. Output of type *err* will be visible on 
 *monitor*.

3. We can read from a keyboard using *System.in*
 As we know *System.in* is an object of Input Stream.

4. Read method returns __Integer Value__ . It's
an Integer value *equivalent* to __ASCII__ of readed character. We can read from a file or from a :+1: *keyboard buffer* . All reading will be in sequence as we know file are accessed sequentially.
> If we give 'a' as input and press enter \
  *\r*   - carriage return ASCII value  13\
  *\n*   - new line return ASCII value  10

5. We can read and write from keyboard and to monitor as well as file can be used as a standard *input/output* device.

6. We can create a file by the help of java program in order to perform *input/output* operation.

7. File is a class and can be used to create a file or a directory.


```java
import java.io.*;


class S
{
	public static void main(String[] args)	throws IOException
	 {
		
		File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture/textfilecreated.txt");
		System.out.println(f.createNewFile());

	}
}

```

---

 :joy:  __Before__

//  Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture

// 09/27/2019  07:46 PM    <DIR>          .
// 09/27/2019  07:46 PM    <DIR>          ..
// 09/27/2019  01:44 PM               186 A.java
// 09/27/2019  07:42 PM            23,951 README.md
// 09/27/2019  07:46 PM               249 S.java
//                3 File(s)         24,386 bytes
//                2 Dir(s)  67,851,816,960 bytes free


:imp: 	__after__

Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture

09/27/2019  07:46 PM    <DIR>          .
09/27/2019  07:46 PM    <DIR>          ..
09/27/2019  01:44 PM               186 A.java
09/27/2019  07:42 PM            23,951 README.md
09/27/2019  07:46 PM               595 S.class
09/27/2019  07:46 PM               669 S.java
09/27/2019  07:46 PM                 0 textfilecreated.txt
               5 File(s)         25,401 bytes
               2 Dir(s)  67,851,816,960 bytes free

D:\GEU\Semester_fifth\core-java-concepts\lecture>

---

8. We can create a file within a directory provided the directory should *exist* . We can create a 
directory by the help of *File* class object.

```java
import java.io.*;


class S
{
	public static void main(String[] args)	throws IOException
	 {
		
		File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture/findmeinparis");
		System.out.println(f.mkdir());

	}
}

```

---

Before :-1:


 Volume Serial Number is 387F-AED0

 Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture

09/27/2019  07:46 PM    <DIR>          .
09/27/2019  07:46 PM    <DIR>          ..
09/27/2019  01:44 PM               186 A.java
09/27/2019  07:50 PM            25,584 README.md
09/27/2019  07:46 PM               595 S.class
09/27/2019  07:51 PM               237 S.java
09/27/2019  07:46 PM                 0 textfilecreated.txt
               5 File(s)         26,602 bytes
               2 Dir(s)  67,851,812,864 bytes free

D:\GEU\Semester_fifth\core-java-concepts\lecture>javac S.java

D:\GEU\Semester_fifth\core-java-concepts\lecture>java S
true


:imp: __After__



 Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture

09/27/2019  07:51 PM    <DIR>          .
09/27/2019  07:51 PM    <DIR>          ..
09/27/2019  01:44 PM               186 A.java
09/27/2019  07:51 PM    <DIR>          findmeinparis
09/27/2019  07:50 PM            25,584 README.md
09/27/2019  07:51 PM               581 S.class
09/27/2019  07:51 PM               237 S.java
09/27/2019  07:46 PM                 0 textfilecreated.txt
               5 File(s)         26,588 bytes
               3 Dir(s)  67,851,812,864 bytes free


---

9. Use of __mkdirs()__ to create multiple directories.

 :sunglasses: :dizzy_face:          :imp:
    :smiling_imp:
    :neutral_face:
    :no_mouth:
    :innocent:
    :alien:
    :yellow_heart:
    :blue_heart:


```java
import java.io.*;


class S
{
	public static void main(String[] args)	throws IOException
	 {
		
		File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture/a/aa/aaa");
		System.out.println(f.mkdirs());

	}
}


D:\GEU\Semester_fifth\core-java-concepts\lecture>dir
 Volume in drive D is CRISTIANO
 Volume Serial Number is 387F-AED0

 Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture

09/27/2019  07:51 PM    <DIR>          .
09/27/2019  07:51 PM    <DIR>          ..
09/27/2019  01:44 PM               186 A.java
09/27/2019  07:51 PM    <DIR>          findmeinparis
09/27/2019  07:54 PM            27,121 README.md
09/27/2019  07:51 PM               581 S.class
09/27/2019  07:54 PM               229 S.java
09/27/2019  07:46 PM                 0 textfilecreated.txt
               5 File(s)         28,117 bytes
               3 Dir(s)  67,851,812,864 bytes free

D:\GEU\Semester_fifth\core-java-concepts\lecture>javac S.java

D:\GEU\Semester_fifth\core-java-concepts\lecture>java S
true

D:\GEU\Semester_fifth\core-java-concepts\lecture>dir
 Volume in drive D is CRISTIANO
 Volume Serial Number is 387F-AED0

 Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture

09/27/2019  07:55 PM    <DIR>          .
09/27/2019  07:55 PM    <DIR>          ..
09/27/2019  07:55 PM    <DIR>          a
09/27/2019  01:44 PM               186 A.java
09/27/2019  07:51 PM    <DIR>          findmeinparis
09/27/2019  07:54 PM            27,121 README.md
09/27/2019  07:55 PM               577 S.class
09/27/2019  07:54 PM               229 S.java
09/27/2019  07:46 PM                 0 textfilecreated.txt
               5 File(s)         28,113 bytes
               4 Dir(s)  67,851,812,864 bytes free

D:\GEU\Semester_fifth\core-java-concepts\lecture>cd a

D:\GEU\Semester_fifth\core-java-concepts\lecture\a>dir
 Volume in drive D is CRISTIANO
 Volume Serial Number is 387F-AED0

 Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture\a

09/27/2019  07:55 PM    <DIR>          .
09/27/2019  07:55 PM    <DIR>          ..
09/27/2019  07:55 PM    <DIR>          aa
               0 File(s)              0 bytes
               3 Dir(s)  67,851,812,864 bytes free

D:\GEU\Semester_fifth\core-java-concepts\lecture\a>cd aa

D:\GEU\Semester_fifth\core-java-concepts\lecture\a\aa>dir
 Volume in drive D is CRISTIANO
 Volume Serial Number is 387F-AED0

 Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture\a\aa

09/27/2019  07:55 PM    <DIR>          .
09/27/2019  07:55 PM    <DIR>          ..
09/27/2019  07:55 PM    <DIR>          aaa
               0 File(s)              0 bytes
               3 Dir(s)  67,851,812,864 bytes free

D:\GEU\Semester_fifth\core-java-concepts\lecture\a\aa>
```




10. 









# Create a new file

```java
import java.io.*;


class S
{
	public static void main(String[] args)	throws IOException
	 {
		File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture/Jio.txt");
		System.out.println(f.createNewFile());  //true 
	}
}
```


11. What if we name the directory as "a.file".

  :rage1:
    :rage2:
    :rage3:
    :rage4:
    :suspect:
    :trollface:


    *notice a.file is dir*


```java
import java.io.*;


class S
{
	public static void main(String[] args)	throws IOException
	 {
		
		File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture/a.file");
		System.out.println(f.mkdir());

	}
}



D:\GEU\Semester_fifth\core-java-concepts\lecture>dir
 Volume in drive D is CRISTIANO
 Volume Serial Number is 387F-AED0

 Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture

09/27/2019  07:59 PM    <DIR>          .
09/27/2019  07:59 PM    <DIR>          ..
09/27/2019  07:55 PM    <DIR>          a
09/27/2019  07:59 PM    <DIR>          a.file
09/27/2019  01:44 PM               186 A.java
09/27/2019  07:51 PM    <DIR>          findmeinparis
09/27/2019  07:58 PM            30,341 README.md
09/27/2019  07:59 PM               574 S.class
09/27/2019  07:58 PM               230 S.java
09/27/2019  07:46 PM                 0 textfilecreated.txt
               5 File(s)         31,331 bytes
               5 Dir(s)  67,851,808,768 bytes free

D:\GEU\Semester_fifth\core-java-concepts\lecture>
```



12. We can display the data of file.

```java
import java.io.*;


class S
{
	public static void main(String[] args)	throws IOException
	 {
		
		File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture/textfilecreated.txt");
		FileReader fr=new FileReader(f);
		int k;

		while((k=fr.read())!=-1)
		{
			System.out.println(k);
		}
	}
}


97
98
99
100
101
102
103
104
105
13  // carriage return       /r
10  // new line              /n 

```

13. The whole file can be displayed as

```java
import java.io.*;


class S
{
	public static void main(String[] args)	throws IOException
	 {
		
		File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture/S.java");
		FileReader fr=new FileReader(f);
		int k;

		while((k=fr.read())!=-1)
		{
			System.out.print((char)k);
		}
	}
}



D:\GEU\Semester_fifth\core-java-concepts\lecture>javac S.java

D:\GEU\Semester_fifth\core-java-concepts\lecture>java S
import java.io.*;


class S
{
        public static void main(String[] args)  throws IOException
         {

                File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture/S.java");
                FileReader fr=new FileReader(f);
                int k;

                while((k=fr.read())!=-1)
                {
                        System.out.print((char)k);
                }
        }
}


D:\GEU\Semester_fifth\core-java-concepts\lecture>

```


14. Some of the methods

:pouting_cat:
    :japanese_ogre:
    :japanese_goblin:
    :see_no_evil:
    :hear_no_evil:
    :speak_no_evil:

```java
import java.io.*;


class S
{
	public static void main(String[] args)	throws IOException
	 {
		
		File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture/S.java");

		System.out.println(f.length());
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());
		System.out.println(f.getAbsolutePath());

	}
}



D:\GEU\Semester_fifth\core-java-concepts\lecture>java S
352
true
false
D:\GEU\Semester_fifth\core-java-concepts\lecture\S.java


```


---

```java

import java.io.*;


class S
{
	public static void main(String[] args)	throws IOException
	 {
		
		File f=new File("octave.txt");

		System.out.println(f.length());
		System.out.println(f.isFile());
		System.out.println(f.isDirectory());
		System.out.println(f.getAbsolutePath());


		File obj=new File("nova.txt");
		System.out.println(f.renameTo(obj));

	}
}



D:\GEU\Semester_fifth\core-java-concepts\lecture>dir
 Volume in drive D is CRISTIANO
 Volume Serial Number is 387F-AED0

 Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture

09/27/2019  08:22 PM    <DIR>          .
09/27/2019  08:22 PM    <DIR>          ..
09/27/2019  01:44 PM               186 A.java
09/27/2019  08:09 PM                 5 octave.txt
09/27/2019  08:16 PM            33,551 README.md
09/27/2019  08:22 PM               783 S.class
09/27/2019  08:22 PM               381 S.java
               5 File(s)         34,906 bytes
               2 Dir(s)  67,851,800,576 bytes free

D:\GEU\Semester_fifth\core-java-concepts\lecture>javac S.java

D:\GEU\Semester_fifth\core-java-concepts\lecture>java S
5
true
false
D:\GEU\Semester_fifth\core-java-concepts\lecture\octave.txt
true

D:\GEU\Semester_fifth\core-java-concepts\lecture>dir
 Volume in drive D is CRISTIANO
 Volume Serial Number is 387F-AED0

 Directory of D:\GEU\Semester_fifth\core-java-concepts\lecture

09/27/2019  08:23 PM    <DIR>          .
09/27/2019  08:23 PM    <DIR>          ..
09/27/2019  01:44 PM               186 A.java
09/27/2019  08:09 PM                 5 nova.txt
09/27/2019  08:16 PM            33,551 README.md
09/27/2019  08:22 PM               783 S.class
09/27/2019  08:22 PM               381 S.java
               5 File(s)         34,906 bytes
               2 Dir(s)  67,851,800,576 bytes free

D:\GEU\Semester_fifth\core-java-concepts\lecture>
```

---


15. *list vs ListFile*

---

```java

import java.io.*;

public class S
{
	public static void main(String[] args) {
		
	 File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture");
	 String s[]=null;

	 if (f.isDirectory())
	 {
	 	s=f.list();
	 }

	 for(String r:s)
	 {
	 	System.out.println(r);
	 }
	}
}



D:\GEU\Semester_fifth\core-java-concepts\lecture>java S
A.java
nova.txt
README.md
S.class
S.java

D:\GEU\Semester_fifth\core-java-concepts\lecture>

```

*listFiles() returns the absolute path of files*

```java
import java.io.*;

public class S
{
	public static void main(String[] args) {
		
	 File f=new File("D:/GEU/Semester_fifth/core-java-concepts/lecture");
	 File wow[]=null;


	 if (f.isDirectory())
	 {
	 	wow=f.listFiles();
	 }

	 for(File r:wow)
	 {
	 	System.out.println(r);
	 }
	}
}



D:\GEU\Semester_fifth\core-java-concepts\lecture>java S
D:\GEU\Semester_fifth\core-java-concepts\lecture\A.java
D:\GEU\Semester_fifth\core-java-concepts\lecture\nova.txt
D:\GEU\Semester_fifth\core-java-concepts\lecture\README.md
D:\GEU\Semester_fifth\core-java-concepts\lecture\S.class
D:\GEU\Semester_fifth\core-java-concepts\lecture\S.java

D:\GEU\Semester_fifth\core-java-concepts\lecture>
```

---

16. A file can be used as an input/output device i.e., data can be readed from it. To perform input/output operation two types of *streams* are used:

> *Byte*\
*Stream*

17. **Stream** is sequence of data when we are using Character stream we are dealing with 16 bit while we deal with byte it is *8bit*.

18. Inorder to use stream we should follow

> openStream()\
 useStream()\
 closeStream()

19. There are several classes in support of these
stream category.

Reader  read()  | Writer    write()
 ------------ | ------------
InputStreamReader | OutPutStreamWriter
FileReader        |  PrintWriter
BufferedReader  | FileStreamWriter



20. FileReader and FileWrite class can be used to read and write to file.

21. If  file exist and have no content means is empty then read method returns -1.



---
