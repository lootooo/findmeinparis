# Chapter 3 , Class in Java


1. Example 3.1 __Using this reference__
   If we declare a class public then the file name must be similar to class name.
   A local variable should be initialized prior to use.

```java

class Light
{
	// fields
	int noOfWatts;
	boolean indicator;
	String location;

	public  Light(int noOfWatts,boolean indicator,String site)
	{
		System.out.println("site   "+this.location);
		System.out.println("no of watts "+this.noOfWatts);
		System.out.println("site   "+this.indicator);
		String location;	


		this.noOfWatts=noOfWatts;   //assignment of field
		location=site;					// assignment of local variable
		indicator=indicator;		// assignment to parameter
		System.out.println(indicator);
	    this.superFlous();
		superFlous();                   //equivalent to above

		System.out.println("*************************************");
		System.out.println("site   "+this.location);
		System.out.println("no of watts "+this.noOfWatts);
		System.out.println("site   "+this.indicator);
	}

	 void superFlous()
    {
   	System.out.println("The object     :"+this);
	}


	public static void main(String[] args) {
		Light obj=new Light(100,true,"loft");
		System.out.println("no. of watts    :"+obj.noOfWatts);
		System.out.println("Indicator       :"+obj.indicator);	
		System.out.println("Location        :"+obj.location);
	}
}


// The object     :Light@449b2d27
// The object     :Light@449b2d27
// no. of watts    :100
// Indicator       :false
// Location        :null

// site   null
// no of watts 0
// site   false
// true
// The object     :Light@2d6d8735
// The object     :Light@2d6d8735
// *************************************
// site   null
// no of watts 100
// site   false
// no. of watts    :100
// Indicator       :false
// Location        :null


```

> When there is no conflict between local variable and instance variable

```java
class Light
{
	// fields
	int noOfWatts;
	boolean indicator;
	String location;

	public  Light(int watts,boolean indi,String site)
	{
		System.out.println("site   "+this.location);
		System.out.println("no of watts "+this.noOfWatts);
		System.out.println("site   "+this.indicator);
	//	String location;	


		noOfWatts=watts;   //assignment of field
		location=site;					// assignment of local variable
		indicator=indi;		// assignment to parameter
	    this.superFlous();
		superFlous();                   //equivalent to above

		System.out.println("*************************************");
		System.out.println("site   "+this.location);
		System.out.println("no of watts "+this.noOfWatts);
		System.out.println("site   "+this.indicator);
	}

	 void superFlous()
    {
   	System.out.println("The object     :"+this);
	}


	public static void main(String[] args) {
		Light obj=new Light(100,true,"loft");
		System.out.println("no. of watts    :"+obj.noOfWatts);
		System.out.println("Indicator       :"+obj.indicator);	
		System.out.println("Location        :"+obj.location);
	}
}




// site   null
// no of watts 0
// site   false
// The object     :Light@2d6d8735
// The object     :Light@2d6d8735
// *************************************
// site   loft
// no of watts 100
// site   true
// no. of watts    :100
// Indicator       :true
// Location        :loft

```

---

__ this reference cannot be used in a static context, as static code is not executed in the context of
 any object__

---



2. Example 3.2

