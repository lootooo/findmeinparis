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


