class Light
{
	int noOfWatts;
	private boolean indicator;
	protected String location;
	private static int counter;
	Light()
	{
		noOfWatts=50;
		indicator=true;
		location="X";
		counter++;
	}

	public void switchOn(){indicator=true;}
	public void switchOff(){indicator=false;}

	public static void writeCount()
	{
		System.out.println("Number of lights"+counter);
	}
}	

class TubeLight extends Light
{
	private int tubeLength=54;
	private int colorNo=10;

	public int getTubeLength(){return tubeLength;}

	public void printInfo(){
		System.out.println("From the subclass");
		System.out.println("Tube Length"+tubeLength);
		System.out.println("Color number"+colorNo);
		System.out.println("Tube length"+getTubeLength());
		System.out.println("^^^^^^^^^^^^^^");
		System.out.println("From the superclass");
		System.out.println("Wattage"+noOfWatts);
		// System.out.println("indicator"+indicator);
		System.out.println("location"+location);
		// System.out.println("Counter "+counter);
		switchOn();
		switchOff();
		// System.out.println("Indicator"+isOn());
		writeCount();


	}
}


class Winds
{
	public static void main(String[] args) {
		TubeLight obj=new TubeLight();
		obj.printInfo();
	}
}