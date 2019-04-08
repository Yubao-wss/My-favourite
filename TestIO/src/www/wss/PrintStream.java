package www.wss;

import java.io.*;

/**
 * @Author: WSS
 * @Date: 2019/4/7 21:27
 * @Description: 打印流
 *
 * 打印流解决的就是OutputStream的设计缺陷，属于OutputStream功能的加强版。如果操作的不是二进制数据，
 * 只是想通过程序向终端目标输出信息的话，OutputStream不是很方便，其缺点有两个：
 *      1. 所有的数据必须转换为字节数组。
 *      2. 如果要输出的是int、double等类型就不方便了
 *
 * 1.打印流概念
 *      打印流设计的主要目的是为了解决OutputStream的设计问题，其本质不会脱离OutputStream。
 *      经过简单处理之后，让OutputStream的功能变的更加强大了，其实本质就只是对OutputStream的功能做了一个封装而已
 *
 * 2.系统提供的打印流
 *      打印流分为字节打印流：PrintStream、字符打印流:PrintWriter，以后使用PrintWriter几率较高。首先来观察这两个类的继承结构与构造方法：
 *      打印流的设计属于装饰设计模式：核心依然是某个类的功能，但是为了得到更好的操作效果，让其支持的功能更多一些。
 *
 * 3.格式化输出
 *      C语言有一个printf()函数，这个函数在输出的时候可以使用一些占位符，例如：字符串(%s)、数字(%d)、小数(%m.nf)、字符(%c)等。
 *      从JDK1.5开始，PrintStream类中也追加了此种操作。
 *      格式化输出:public PrintStream printf(String format, Object ... args)
 *
 *      同时在String类中也追加有一个格式化字符串方法
 *      格式化字符串：public static String format(String format, Object... args)
 *
 *
 */
/*范例：自己设计一个简单打印流*/
class PrintUtil{
    private OutputStream out;

    //由外部传入要输出的目标终端
    public PrintUtil(OutputStream out){
        this.out = out;
    }

    //核心功能
    public void print(String str){
        try {
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void println(String str){
        this.print(str+"\n");
    }

    public void print(int data){
        this.print(String.valueOf(data));
    }

    public void println(int data){
        this.println(String.valueOf(data));
    }

    public void print(double data){
        this.print(String.valueOf(data));
    }

    public void println(double data){
        this.println(String.valueOf(data));
    }
}
public class PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        /*测试自制打印流*/
        PrintUtil printUtil = new PrintUtil(new FileOutputStream(new File(
                "C:\\Users\\Administrator\\Desktop\\Test.txt")));
        printUtil.print("Name:");
        printUtil.println("Wss");
        printUtil.print("Age:");
        printUtil.println(21);
        printUtil.print("Skill:");
        printUtil.println("Java");


        /*范例：使用打印流*/
        PrintWriter printUtil2 = new PrintWriter(new FileOutputStream(new File(
                "C:\\Users\\Administrator\\Desktop\\Test.txt")));
        printUtil2.print("Name:");
        printUtil2.println("Jack");
        printUtil2.close();


        /*范例：观察格式化输出*/
        String name = "Sam";
        int age = 20;
        double salay = 8000.055;
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(new File(
                "C:\\Users\\Administrator\\Desktop\\Test.txt")));
        printWriter.printf("姓名：%s,年龄：%d,工资：%1.2f",name,age,salay);
        printWriter.close();


        /*格式化字符串*/
        String str = String.format("姓名：%s,年龄：%d,工资：%1.2f",name,age,salay);
        System.out.println(str);
        /*
            结果：
            姓名：Sam,年龄：20,工资：8000.05
        */
    }
}
