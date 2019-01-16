import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {

    public static void main(String[] args){
        //通过对象调用普通方法
        /*Main me = new Main();
        me.print();
        me.add(3,4,5);*/
        /*1*/


        /*System.out.println(add(2,3,4));
        System.out.println(add(2,3));
        System.out.println(add(2,3.0));
        System.out.println(add(2.0,3));
        //println方法的重载
        System.out.println();
        System.out.println(1);
        System.out.println(1.0);*/
        /*2*/



        /*long d1 = System.currentTimeMillis();
        System.out.printf("%d阶乘的结果:%s%n",10,factorial(10));
        long d2 = System.currentTimeMillis();
        System.out.printf("递归用时: %s ms %n",d2-d1);
        factorialLoop(10);*/
        /*3*/
    }



    /*void print(){
        System.out.println("wss");
    }
    void add(int a,int b,int c){
        int sum = a+b+c;
        System.out.println(sum);
        return ;  //return有两个作用：1.结束方法的运行，2.返回值
    }*/
    /*1.方法 */



    /*//求和方法
    public static int add(int n1,int n2){
        int sum = n1+n2;
        return sum;
    }
    //方法名相同，参数个数不同，构成重载
    public static int add(int n1,int n2,int n3){
        int sum = n1+n2+n3;
        return sum;
    }
    //方法名相同，返回值不同，参数类型不同，构成重载
    public static double add(double n1,int n2){
        double sum = n1+n2;
        return sum;
    }
    //方法名相同，返回值不同，参数顺序不同，构成重载
    public static double add(int n1,double n2){
        double sum = n1+n2;
        return sum;
    }*/
    /*2.方法重载*/



    /*static long factorial(int n){
        if (n==1){
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }
    static long factorialLoop(int a){
        long d3 = System.currentTimeMillis();
        long result =1;
        while (a>1){
            result *= a;
            a--;
        }
        long d4 = System.currentTimeMillis();
        System.out.println(result);
        System.out.printf("普通循环费时：%s ms%n",d4-d3);
        return result;
    }*/
    /*3.递归*/





}
