import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @Author: WSS
 * @Date:
 * @Description: 练习
 */
public class practice1 {
//1.接口，抽象类
interface InterfaceA {
    String S = "good ";
    void f();
}
static abstract class ClassA {
    abstract void g();
}
static class ClassB extends ClassA implements InterfaceA {
    void g() {
        System.out.print(S);
    }
    public void f() {
        System.out.print(" "+ S);
    }
}
/*2.编程题:
利用接口做参数，写个计算器，能完成加减乘除运算。
（1）定义一个接口Compute含有一个方法int computer(int n, int m)。
（2）设计四个类分别实现此接口，完成加减乘除运算。
（3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, int one, int two)，此方法能够用传递过来的对象调用computer方法完成运算，并输出运算的结果。
（4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。*/
interface Compute{
    int computer(int n,int m);
}
static class Plus implements Compute {
    @Override
    public int computer(int n, int m) {
        return n + m;
    }
}
static class Minus implements Compute{
    @Override
    public int computer(int n, int m) {
        return n - m;
    }
}
    static class Multiply implements Compute{
        @Override
        public int computer(int n, int m) {
            return n * m;
        }
    }
    static class Divide implements Compute{
        @Override
        public int computer(int n, int m) {
            return n / m;
        }
    }
    public static class UseCompute{
        public static void useCom (Compute com, int one, int two){
            int result = com.computer(one,two);
            System.out.println(result);
        }
    }
    /*3.按如下要求编写Java程序：
（1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。
（2）定义接口B，里面包含抽象方法void setColor(String c)。
（3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。
（4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、
圆柱体的高height、颜色color。
（5）创建主类来测试类Cylinder。
*/
    interface A{
        double PI = (double) 3.14;
        double area();
    }
    interface B{
        void setColor(String c);
    }
    interface C extends A,B{
        void volume();
    }
    public static class Cylinder implements C{

        private double radius;
        private double height;
        private String color;

        public void setRadius(int radius) {
            this.radius = radius;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public Cylinder(double radius, double height) {
            this.radius = radius;
            this.height = height;
        }

        @Override
        public double area() {
            return radius*radius*PI*2 + 2*radius*PI*height;
        }

        @Override
        public void setColor(String c) {
            this.color = c;
        }

        @Override
        public void volume() {
            System.out.println(height*radius*radius*PI*2);
        }

    }
//    //4./**
//         * 重复某个字符
//         *
//         * 例如：
//         * 'a' 5   => "aaaaa"
//         * 'a' -1  => ""
//         *
//         * @param c     被重复的字符
//         * @param count 重复的数目，如果小于等于0则返回""
//         * @return 重复字符字符串
//         */
        public static String repeat(char c, int count) {
            if (count <= 0) {
                return "";
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0;i<count;i++){
                    sb.append(c);
                }
                return sb.toString();
            }
        }

        /**
         * 将已有字符串填充为规定长度，如果已有字符串大于等于这个长度则返回这个字符串
         * 字符填充于字符串前
         *
         * 例如：
         * "abc" 'A' 5  => "AAabc"
         * "abc" 'A' 2  => "abc"
         *
         * @param str        被填充的字符串
         * @param filledChar 填充的字符
         * @param len        填充长度
         * @return 填充后的字符串
         */
        public static String fillBefore(String str, char filledChar, int len) {
            if (str.length()>=len){
                return str;
            }else {
               int L = len-str.length();
               StringBuilder sb = new StringBuilder();
               for (int i = 0;i<L;i++){
                    sb.append(filledChar);
               }
                sb.append(str);
               return sb.toString();
            }
        }

        /**
         * 将已有字符串填充为规定长度，如果已有字符串大于等于这个长度则返回这个字符串<br>
         * 字符填充于字符串后
         * 例如：
         * "abc" 'A' 5  => "abcAA"
         * "abc" 'A' 3  => "abc"
         *
         * @param str        被填充的字符串
         * @param filledChar 填充的字符
         * @param len        填充长度
         * @return 填充后的字符串
         */
        public static String fillAfter(String str, char filledChar, int len) {
            if (str.length()>=len){
                return str;
            }else {
                int L = len-str.length();
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                for (int i = 0;i<L;i++){
                    sb.append(filledChar);
                }
                return sb.toString();
            }
        }

        /**
         * 移除字符串中所有给定字符串
         * 例：removeAll("aa-bb-cc-dd", "-") => aabbccdd
         *
         * @param str         字符串
         * @param strToRemove 被移除的字符串
         * @return 移除后的字符串
         */
        public static String removeAll(String str, String strToRemove) {
            if (!str.contains(strToRemove)){
                return str;
            }else {
                return str.replaceAll(strToRemove, "");
            }
        }

        /**
         * 反转字符串
         * 例如：abcd => dcba
         *
         * @param str 被反转的字符串
         * @return 反转后的字符串
         */
        public static String reverse(String str) {
            // str -> char[]
            char[] data = str.toCharArray();
            char[] result = new char[str.length()];
            char temp = '0';
            for (int i = 0;i<(str.length()/2);i++){
                temp = data[i] ;
                data[i] = data[str.length()-i-1];
                data[str.length()-i-1] = temp;
            }
            // char[] -> String
            return String.valueOf(data);
        }
        //5.(附加题-算法)
//一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程 找出1000以内的所有完数

    /***
     * 找出并打印count以内的所有完数
     *
     * @param count 查找上限
     */
        public static void FindFullNumber(int count){
            for (int n = 1;n<count;n++){
                int sum = 0;
                for (int i = 1;i<n;i++){

                    if (n%i == 0){
                        sum += i;

                    }

                }
                if (sum == n){
                    System.out.print(n+"\t");
                }
            }
        }
public static void main(String[] args) {
    //1.
        ClassA a = new ClassB();
        InterfaceA b = new ClassB();
        a.g();
        b.f();
        //结果：good  good
    //2.
        int one = 4;
        int two = 5;
        Compute uc01 = new Plus();
        Compute uc02 = new Minus();
        Compute uc03 = new Multiply();
        Compute uc04 = new Divide();
        UseCompute.useCom(uc01,one,two);
        UseCompute.useCom(uc02,one,two);
        UseCompute.useCom(uc03,one,two);
        UseCompute.useCom(uc04,one,two);
        //结果：9
        //-1
        //20
        //0
    //3.
        Cylinder cy = new Cylinder(3.0,4.0);
        cy.volume();
        double area = cy.area();
        System.out.println(area);
        //结果：226.08
        //131.88
    //4.
        System.out.println(repeat('k',5));
        System.out.println(fillAfter("utu",'L',5));
        System.out.println(fillBefore("utu",'L',5));
        System.out.println(removeAll("w-s-s","-"));
        System.out.println(reverse("school"));
        //结果：
        //kkkkk
        //utuLL
        //LLutu
        //wss
        //loohcs
    //5.
        FindFullNumber(1000);
        //结果：6 	28	496
    }
}
