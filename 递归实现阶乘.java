public class Work1
{
    public static void main(String[] args)
    {
       int a = 20;
       long ret = factorial(a);
       System.out.print(ret);
    }
    public static  long factorial(int x)
    {
       if(x < 1)
       {
           return 1L;
       }
       else
       {
           return  x * factorial(x-1);
       }
    }
}
