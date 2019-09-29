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
