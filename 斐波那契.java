public class Day1{
    public static void main(String[] args){
       Fibonacci f = new Fibonacci();
       f.printfib(10);
    }
}
class Fibonacci{
  public static void printfib(int num){
      int i = 1;
      for(;i<=num;i++){
          System.out.print(fib(i)+" ");
      }
    }
  public static int fib(int n){
      return n<=1?n:fib(n-1)+fib(n-2);
  }
}
