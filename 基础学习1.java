import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.print.DocFlavor;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        /*boolean man = true;
        System.out.println("believe yourself");
        System.out.println(""+'a'+'b');
        System.out.println(""+'a'+'\''+'b');
        if (man){
            System.out.println("yes");
        }*/
        /*1*/

        /*byte a = 1;
        int b = 2;
        long b2 = 3;
        byte c = (a + b);
        float f1 = b2;
        System.out.println(7/-3);*/
        /*2*/

        /*int a = 2;
        int b = 3;
        a*=b+3;
        System.out.println(a);*/
        /*3*/

        /*char b = 'a';
        System.out.println((int)b);
        System.out.println(0+b);
        System.out.println(b);*/
        /*4*/

        /*boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1&b2);
        System.out.println(b1|b2);
        System.out.println(b1^b2);
        boolean b3 = 1>2&&2<(3/0);
        boolean b4 = 1>2&2<(3/0);
        System.out.println(b3);*/
        /*5*/

        /*int a = 3;
        int b = 4;
        System.out.println(a&b);
        System.out.println(a|b);
        System.out.println(a^b);
        System.out.println(~b);
        System.out.println(a>>1);*/
        /*6*/

        /*String a = "3";
        int b = 4;
        int c = 5;
        char d = 'a';
        System.out.println(a+b+c);
        System.out.println(b+c+a);
        System.out.println(d + 4);*/
        /*7*/

        /*int score = 80;
        int x = -100;
        String type = score<60?"不及格":"及格";
        System.out.println(type);
        if(score<60){
            System.out.println("不及格");
        }else {
            System.out.println("及格");
        }
        System.out.println(x>0?1:(x == 0?0:-1));*/
        /*8*/

        /*逻辑非>逻辑与>逻辑或（优先级）*/
        /*a || b && c 的运算结果是：a || (b && c)，而不是(a || b) && c*/
        /*9*/

        /*int a = 324;
        long b = a;
        double d = b;
        a = b;  *//*不行*//*
        long e = 3.23;  *//*不行*//*
        float f = 234324.5;  *//*不行*//*
        float f2 = 234324L;
        byte b2 = 129;  *//*不行*/
        /*10.自动类型转换*/

        /*double x = 3.14;
        int nx = (int)x;
        char c = 'a';
        int d = c+1;
        System.out.println(nx);
        System.out.println(d);
        System.out.println((char)d);*/
        /*11.强制类型转换*/

        /*int money = 1000000000;
        int year = 20;
        int total = money*year;
        System.out.println(total);
        long total1 = money*year;
        System.out.println(total1);
        long total2 = money*(long)year;
        System.out.println(total2);
        long m = 99999999L*year*money;
        System.out.println(m);*/
        /*12.溢出*/

        /*Scanner scanner = new Scanner(System.in);
        System.out.println("请输入名字：");
        String name = scanner.nextLine();
        System.out.println("请输入你的爱好");
        String favor = scanner.nextLine();
        System.out.println("请输入你的年龄");
        int age = scanner.nextInt();
        System.out.println("########################");
        System.out.println(name);
        System.out.println(favor);
        System.out.println(age);*/
        /*13.键盘输入*/
    }
}
