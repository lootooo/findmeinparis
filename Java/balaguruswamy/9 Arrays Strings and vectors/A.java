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








