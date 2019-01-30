import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: WSS
 * @Date:
 * @Description: CheckedException 已检查异常处理
 *              所有不是RuntimeException的异常，统称为Checked Exception，又被称为“已检查异常”，
 *              如IOException、SQLException等以及用户自定义的Exception异常。
 *              这类异常在编译时就必须做出处理，否则无法通过编译。
 *
 *              该异常的处理方式有两种：使用“try/catch”捕获异常、使用“throws”声明异常。
 *
 *              捕获异常是通过3个关键词来实现的：try-catch-finally。
 *              用try来执行一段程序，如果出现异常，系统抛出一个异常，可以通过它的类型来捕捉(catch)并处理它，最后一步是通过finally语句为异常处理提供一个统一的出口，
 *              finally所指定的代码都要被执行(catch语句可有多条;finally语句最多只能有一条，根据自己的需要可有可无)。
 *
 *              try：
 *              try语句指定了一段代码，该段代码就是异常捕获并处理的范围。在执行过程中，当任意一条语句产生异常时，就会跳过该条语句中后面的代码。
 *              代码中可能会产生并抛出一种或几种类型的异常对象，它后面的catch语句要分别对这些异常做相应的处理。
 *              一个try语句必须带有至少一个catch语句块或一个finally语句块
 *              当异常处理的代码执行结束以后，不会回到try语句去执行尚未执行的代码。
 *
 *              catch：
 *              n-每个try语句块可以伴随一个或多个catch语句，用于处理可能产生的不同类型的异常对象。
 *              常用方法，这些方法均继承自Throwable类 。
 *              toString ()方法，显示异常的类名和产生异常的原因
 *              getMessage()方法，只显示产生异常的原因，但不显示类名。
 *              printStackTrace()方法，用来跟踪异常事件发生时堆栈的内容。
 *              catch捕获异常时的捕获顺序：
 *              如果异常类之间有继承关系，在顺序安排上需注意。越是顶层的类，越放在下面，再不然就直接把多余的catch省略掉。 也就是先捕获子类异常再捕获父类异常。
 *
 *              finally：
 *              有些语句，不管是否发生了异常，都必须要执行，那么就可以把这样的语句放到finally语句块中。
 *              通常在finally中关闭程序块已打开的资源，比如：关闭文件流、释放数据库连接等。
 *
 *              try-catch-finally语句块的执行过程：
 *              程序首先执行可能发生异常的try语句块。如果try语句没有出现异常则执行完后跳至finally语句块执行;
 *              如果try语句出现异常，则中断执行并根据发生的异常类型跳至相应的catch语句块执行处理。
 *              catch语句块可以有多个，分别捕获不同类型的异常。
 *              catch语句块执行完后程序会继续执行finally语句块。
 *              finally语句是可选的，如果有的话，则不管是否发生异常，finally语句都会被执行。
 *
 *              注意事项：
 *              1. 即使try和catch块中存在return语句，finally语句也会执行。是在执行完finally语句后再通过return退出。
 *              2. finally语句块只有一种情况是不会执行的，那就是在执行finally之前遇到了System.exit(0)结束程序运行。
 */
public class TestTryCatch {
    public static void main(String[] args) {
        //用于测试，在d盘下创建文件a.txt，并写入“test”。
        FileReader reader = null;
        try {
            reader = new FileReader("d:\\b.txt");

            char c1 = (char)reader.read();//读文件中的一个字符并存到变量c1中
            System.out.println(c1);//正常情况下会输出字母“t”

        } catch (FileNotFoundException e) {
            e.printStackTrace();//处理 FileReader reader = new FileReader("d:\\a.txt");
        } catch (IOException e) {
            e.printStackTrace();//处理 char c1 = (char)reader.read();
            //IOException是FileNotFoundException的父类
            //catch语句中子类在前，父类在后
        }finally {
            try {
                if (reader != null){
                    reader.close();//无论是否遇到异常，最后都要关闭
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
//结果：java.io.FileNotFoundException: d:\b.txt (系统找不到指定的文件。)
//	at java.io.FileInputStream.open0(Native Method)
//	at java.io.FileInputStream.open(FileInputStream.java:195)
//	at java.io.FileInputStream.<init>(FileInputStream.java:138)
//	at java.io.FileInputStream.<init>(FileInputStream.java:93)
//	at java.io.FileReader.<init>(FileReader.java:58)
//	at TestTryCatch.main(TestTryCatch.java:55)
