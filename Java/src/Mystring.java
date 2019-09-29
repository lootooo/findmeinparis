import java.io.*;

public class Mystring {
    void con() throws ArithmeticException,Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
        System.out.println("Enter your string");
        String s1 =br.readLine();

        System.out.println("Enter another one");
        String s2=br.readLine();


        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        String s3=s1.concat(s2);
        System.out.println(s3);


        System.out.println("----------------");
        System.out.println("Lenght of string"+s3.length());

        System.out.println(s3.toUpperCase());



    }

    public static void main(String args[]) throws ArithmeticException,Exception
    {
        Mystring t1=new Mystring();
        t1.con();
    }
}
