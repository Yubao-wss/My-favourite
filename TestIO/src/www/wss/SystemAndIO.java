package www.wss;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: WSS
 * @Date: 2019/4/7 23:25
 * @Description: System类对IO的支持
 *
 * 学习完PrintStream与PrintWriter后，我们发现里面的方法名都很熟悉。例如：print()、println()，
 * 实际上我们一直在使用的系统输出就是利用了IO流的模式完成。在System类中定义了三个操作的常量
 *     1. 标准输出（显示器) : public final static PrintStream out
 *     2. 错误输出 : public final static PrintStream err
 *     3. 标准输入(键盘):public final static InputStream in
 *     一直在使用的System.out.println()属于IO的操作范畴!
 *
 * 1.系统输出：
 *     系统输出一共有两个常量:out、err,并且这两个常量表示的都是PrintStream类的对象。
 *     1. out输出的是希望用户能看到的内容
 *     2. err输出的是不希望用户看到的内容
 *     这两种输出在实际的开发之中都没用了，取而代之的是"日志"。
 *     System.err只是作为一个保留的属性而存在，现在几乎用不到。唯一可能用到的就是System.out
 *
 *     由于System.out是PrintStream的实例化对象，而PrintStream又是OutputStream的子类，
 *     所以可以直接使用System.out直接为OutputStream实例化，这个时候的OutputStream输出的位置将变为屏幕。
 *
 *
 * 2.系统输入
 *      System.in对应的类型是InputStream，而这种输入流指的是由用户通过键盘进行输入(用户输入)。
 *      java本身并没有直接的用户输入处理，如果要想实现这种操作，必须使用java.io的模式来完成。
 *
 */
public class SystemAndIO {
    public static void main(String[] args) throws IOException {
        /*范例：使用System.out为OutputStream实例化*/
        OutputStream out = System.out;
        out.write("hello world".getBytes());
        /*
            控制台出现：
            hello world（效果与常用到的System.out.println一样）
        */

        /*范例：利用InputStream实现数据输入*/
        InputStream in = System.in;
        byte[] data = new byte[1024];
        System.out.println("请输入信息：");
        int temp = in.read(data);// 数据读取到字节数组中(需要用户在控制台中键入）
        System.out.println("输出内容为："+new String(data,0,temp));
        /*
            现在发现当用户输入数据的时候程序需要暂停执行，也就是程序进入了阻塞状态。
            直到用户输入完成(按下回车)，程序才能继续向下执行。

            以上的程序本身有一个致命的问题，核心点在于:开辟的字节数组长度固定，如果现在输入的长度超过了字节数组长度，
            那么只能够接收部分数据。这个时候是由于一次读取不完所造成的问题，所以此时最好的做法是引入内存操作流来进行控制，
            这些数据先保存在内存流中而后一次取出。
        */


        /*范例：引入内存流*/
        InputStream in2 = System.in;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] data2 = new byte[10];
        System.out.println("请输入信息：");
        int temp2 = 0;
        while ((temp2 = in2.read(data2)) != -1){
            bos.write(data2,0,temp2);// 保存数据到内存输出流中
            // 判断用户输入是否结束
            if(temp2 < data2.length){
                break;
            }
        }
        in.close();
        bos.close();
        System.out.println("输出内容为："+new String(bos.toByteArray()));
        /*
            现在虽然实现了键盘输入数据的功能，但是整体的实现逻辑过于混乱了，即java提供的System.in并不好用,
            还要结合内存流来完成，复杂度很高。

            如果要想在IO中进行中文的处理，最好的做法是将所有输入的数据保存在一起再处理，这样才可以保证不出现乱码。
        */
    }
}
