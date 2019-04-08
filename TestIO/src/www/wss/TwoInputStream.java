package www.wss;

import java.io.*;
import java.util.Scanner;

/**
 * @Author: WSS
 * @Date: 2019/4/8 13:08
 * @Description: 两种输入流
 *
 * 1.BufferedReader类
 *      BufferedReader类属于一个缓冲的输入流，而且是一个字符流的操作对象。在java中对于缓冲流也分为两类：
 *      字节缓冲流(BufferedInputStream)、字符缓冲流(BufferedReader)。
 *
 *      BufferedReader类中提供有如下方法（读取一行数据）:
 *      String readLine() throws IOException     这个方法可以直接读取一行数据(以回车为换行符)
 *
 *      但是这个时候有一个非常重要的问题要解决，来看BufferedReader类的定义与构造方法:
 *          public class BufferedReader extends Reader
 *          public BufferedReader(Reader in)
 *      System.in是InputStream类的子类，这个时候与Reader没有关系，要建立起联系就要用到InputStreamReader类。
 *
 * 2.java.util.Scanner类
 *      打印流解决的是OutputStream类的缺陷，BufferedReader解决的是InputStream类的缺陷。而Scanner解决的是BufferedReader类的缺陷(替换了BufferedReader类)
 *      Scanner是一个专门进行输入流处理的程序类，利用这个类可以方便处理各种数据类型，同时也可以直接结合正则表达式进行各项处理，这个类中主要关注以下方法：
 *          1. 判断是否有指定类型数据: public boolean hasNextXxx()
 *          2. 取得指定类型的数据: public 数据类型 nextXxx()
 *          3. 定义分隔符:public Scanner useDelimiter(Pattern pattern)
 *          4. 构造方法:public Scanner(InputStream source)
 *
 */
public class TwoInputStream {
    public static void main(String[] args) throws IOException {
        /*范例：利用BufferedReader实现键盘输入*/
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入信息：");
        // 默认的换行模式是BufferedReader的最大缺点
        String str = buf.readLine();// 默认使用回车换行
        System.out.println("输入信息为："+str);
        /*
            以上操作形式是java10多年前输入的标准格式，但是时过境迁，这个类也淹没在历史的潮流之中，被JDK1.5提供的java.util.Scanner类所取代。
            使用以上形式实现的键盘输入还有一个最大特点，由于接收的数据类型为String，可以使用String类的各种操作进行数据处理并且可以变为各种常见数据类型。
        */


        /*范例：使用Scanner实现数据输入*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入：");
        if(scanner.hasNext()){// 有输入内容，不判断空字符串
            System.out.println("输入内容为："+scanner.next());
        }
        /*
            使用Scanner还可以接收各种数据类型，并且帮助用户减少转型处理。
        */
        /*范例：接受其他类型数据*/
        System.out.println("请输入年龄：");
        if(scanner.hasNextInt()) {
            int age = scanner.nextInt();
            System.out.println("输入内容为："+age);
        }else {
            System.out.println("输入的不是数字！");
        }
        /*最为重要的是，Scanner可以对接收的数据类型使用正则表达式判断
        范例:利用正则表达式进行判断*/
        System.out.println("请输入生日：");
        if(scanner.hasNext("\\d{4}-\\d{2}-\\d{2}")){
            String birthday = scanner.next();
            System.out.println("输入的生日为："+birthday);
        }else {
            System.out.println("输入的格式非法！");
        }
        scanner.close();
        /*
            但是以上操作在开发之中基本不会出现，现在不可能让你编写一个命令行程序进行数据输入。
            使用Scanner本身能够接收的是一个InputStream对象，那么也就意味着可以接收任意输入流，
            例如:文件输入流 ;Scanner完美的替代了BufferedReader，而且更好的实现了InputStream的操作。
        */

        /*范例：使用Scanner操作文件*/
        Scanner scan = new Scanner(new FileInputStream(new File(
                "C:\\Users\\Administrator\\Desktop\\Test.txt")));
        scan.useDelimiter(",");// 自定义分隔符
        while (scan.hasNext()){
            System.out.println(scan.next());
        }
        scan.close();


        }
}
