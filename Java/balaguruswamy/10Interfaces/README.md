# Interfaces : Multiple Inheritance

1. __Syntax__
  ```java
    interface InterFaceName
    {
        variable decalaration;
        methods declaration;
    }
    
    
    interface Item
    {
        
        static final int encrypt=1000101;
        int b=1001;           // compiler will make this static and final by default
        void display();
    }
  ```
 


2. display() in B cannot implement display() in ItemConstants
             void display()
             ^
             attempting to assign __weaker__ access privileges; was __public__

```java
class A
{
    public static void main(String[] args) {
        B obj=new B();
        obj.display();
    }
}

interface ItemConstants
{
    int code=1001;
    String name="fan";
    static int game=1;

    void display();


}

class B implements ItemConstants
{
    void display()
    {
        System.out.println(code);
        System.out.println(name);
        System.out.println(game);
    }
}

.java:22: error: display() in B cannot implement display() in ItemConstants
        void display()
        ^
        attempting to assign weaker access privileges; was public
1 error

        D:\GEU\Semester_fifth\core-java-concepts\balaguruswamy\10Interfaces>






```

---

* The updated one

```java
class A
{
    public static void main(String[] args) {
        B obj=new B();
        obj.display();
    }
}

interface ItemConstants
{
    int code=1001;         //   final and static
    String name="fan";    // final and static
    static int game=1;        // final too

    void display();


}

class B implements ItemConstants
{
    public void display()
    {
        System.out.println(code);  
        System.out.println(name);
        System.out.println(game);
    }
}


```


* Implementing interfaces

```java

interface Area
{
    final static float pi=3.14F;
    float compute(float x,float y);
}



class Rectangle implements Area
{
    @java.lang.Override
    public float compute(float x, float y) {
        return x*y;
    }
}

class Circle implements Area
{
    public float compute (float x,float y)
    {
        return pi*x*x;
    }
}



class A {
    public static void main(String[] args) {
        Area a=new Rectangle();
        Area b =new Circle();
        System.out.println(a.compute(10,7));
        System.out.println(b.compute(10,7));
    }
}

```

---

* Implementing multiple inheritance

```java

class Student
{
    int rollNumber;
    void getRollNumber(int n)
    {
        rollNumber=n;
    }
    void putRollNumber()
    {
        System.out.println("Roll no :"+rollNumber);
    }
}

class Test extends Student
{
    float part1,part2;
    void getMarks(float m1,float m2)
    {
        part1=m1;
        part2=m2;
    }
    void putMarks()
    {
        System.out.println("Marks Obtained");
        System.out.println("Part 1  :"+part1);

        System.out.println("Part 2  :"+part2);
    }

}

interface Sports
{
    float sportWt=6.5F;
    void putwT();
}

class Results extends Test implements Sports
{
    float total;
    public void putwT()
    {
        System.out.println("Sports wt ="+sportWt);
    }
    void display()
    {
        total=part1+part2+sportWt;
        putRollNumber();
        putMarks();
        putwT();
        System.out.println("Total score   :"+total);
    }
}


class Hybrid
{
    public static void main(String[] args) {
        Results obj=new Results();
        obj.getRollNumber(1);
        obj.getMarks(12.43f,43.4f);
        obj.display();
    }
}

Roll no :1
Marks Obtained
Part 1  :12.43
Part 2  :43.4
Sports wt =6.5
Total score   :62.33



```


* __Question__


```java
public interface FamousLine
{
    void showLin();
}

class Hybrid
{
    public static void main(String[] args) {

    }
}

//interface FamousLine is public, should be declared in a file named FamousLine.java

```

---

#### javap Famousline when public is omitted

```java

interface FamousLine {
  public abstract void showLin();
}


```

---


1. __initializers are not allowed within an interface__

```java

interface IntStack
{
    public abstract void push(int item);
    public abstract int pop();
    int x;
    {
        x=10;
    }
}


class Hybrid
{
    public static void main(String[] args) {

    }
}
`

```

* Implementing stack using interface and class

```java

interface IntStack
{
    public abstract void push(int item);
    public abstract int pop();


}

class FixedStack implements IntStack {
    private int stck[];
    private int tos;

    FixedStack(int size) {
        stck = new int[size];
        tos = -1;
    }

    @java.lang.Override
    public void push(int item) {
        if (tos == stck.length - 1) {
            System.out.println("Stack full");
        } else {
            stck[++tos] = item;
        }
    }

    @java.lang.Override
    public int pop() {
        if (tos < 0) {
            System.out.println("Under flow");
            return 0;
        } else {
            return stck[tos--];
        }
    }
}


class Hybrid
{
    public static void main(String[] args) {
        FixedStack obj=new FixedStack(5);
        FixedStack objb=new FixedStack(10);

        for (int i = 0; i < 5; i++) obj.push(i*10);
        for (int i = 0; i < 10; i++) objb.push(i*10);


        for (int i = 0; i < 5; i++) {
            System.out.println(obj.pop());
        }
        for (int i = 0; i < 10; i++) {

            System.out.println(objb.pop());
        }
    }
}


```





# Arrays,Strings and Vectors

---

1. 2D array is a collection of 1D array

```java


class A
{
    public static void main(String args[]) {

        int x[][]=new int[3][];
        x[0]=new int[2];
        x[1]=new int[4];
        x[2]=new int [3];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {

                System.out.print("  "+x[i][j]);
            }
            System.out.println();
        }
    }
}

// 0  0
// 0  0  0  0
// 0  0  0


```

2. String can be declared in the following way

```java

class A
{
    public static void main(String args[]) {

        int x[][]=new int[3][];
        x[0]=new int[2];
        x[1]=new int[4];
        x[2]=new int [3];

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {

                System.out.print("  "+x[i][j]);
            }
            System.out.println();
        }




        System.out.println("----------------------------");

        String string=new String("holaahi");
        System.out.println(string);


        System.out.println("----------------------------");

        char c[]=new char[3];
        c[0]='1';
        c[1]='2';
        c[2]='3';
        System.out.println(c);

        System.out.println(c.length);
        String s=""+c;
        System.out.println(s);






    }
}
//
//D:\GEU\Semester_fifth\core-java-concepts\balaguruswamy\9 Arrays Strings and vectors>javac A.java
//        A.java:37: error: incompatible types: char[] cannot be converted to String
//        String s=c;
//        ^
//        1 error
//
//        D:\GEU\Semester_fifth\core-java-concepts\balaguruswamy\9 Arrays Strings and vectors>javac A.java
//
//        D:\GEU\Semester_fifth\core-java-concepts\balaguruswamy\9 Arrays Strings and vectors>java A
//        0  0
//        0  0  0  0
//        0  0  0
//        ----------------------------
//        holaahi
//        ----------------------------
//        123
//        3
//        [C@17ed40e0
//
//        D:\GEU\Semest


```


3. Some operations on string

> __valueOf creates string object of it's parameter :)__ +String.valueOf(7));  valueOf creates string object of it's parameter\
  This is the string representation of the object using toString (: "+s.toString()); creates string representation of x \    
  Converts the parameter value to string  representation"+String.valueOf(21));       
      
      
      



class A
{
    public static void main(String args[]) {

        String s="Astute";
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.replace('s','k'));
        System.out.println(s.trim());
        System.out.println(s.length());
        System.out.println("valueOf creates string object of it's parameter :)"+String.valueOf(7));  // valueOf creates string object of it's parameter

        System.out.println("This is the string representation of the object using toString (: "+s.toString());       // creates string representation of x
        System.out.println("Converts the parameter value to string  representation"+String.valueOf(21));

    }
}


4. This is obvious

```java


class A
{

    static String name[]={"James","Vue","Andreas","Justin","Zayn"};
    public static void main(String args[]) {

        String temp=null;

        for (int i = 0; i < name.length; i++) {
            for (int j = i+1; j < name.length; j++) {
                if (name[i].compareTo(name[j])<0)
                {
                    temp=name[i];
                    name[i]=name[j];
                    name[j]=temp;
                }
            }
        }


        for (String s: name) {
            System.out.println(s);
        }

    }
}


```



5. 
---






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


