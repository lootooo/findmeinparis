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
