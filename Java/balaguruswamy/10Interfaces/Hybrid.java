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





class DynamicStack implements IntStack
{
    private int stck[];
    private int tos;

    DynamicStack(int size)
    {
        stck=new int(size);
        tos=-1;
    }

    public void push(int item)
    {
        if (tos==stck.length-1)
        {
            int temp[]=new int[stck.length*2];
            for (int i = 0; i < stck.length; i++) {
                temp[i]=stck[i];
                stck=temp;
                stck[++tos]=item;

            }
        }
        else
            stck[++tos]=item;
    }

    public int pop()
    {
        if (tos<0)
        {
            System.out.println("Nothing left");
            return 0;
        }
        else
        {
            return stck[--tos];
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






        DynamicStack obj=new DynamicStack(5);
        DynamicStack objb=new DynamicStack(10);

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