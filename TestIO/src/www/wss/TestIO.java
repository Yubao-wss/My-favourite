package www.wss;

import java.io.*;

/**
 * @Author: WSS
 * @Date: 2019/4/5 16:21
 * @Description: 字节流与字符流
 *
 * File类不支持文件内容处理，如果要处理文件内容，必须要通过流的操作模式来完成。流分为输入流和输出流。
 * 在java.io包中，流分为两种：字节流与字符流
 *      1. 字节流：InputStream、OutputStream
 *      2. 字符流：Reader、Writer
 *
 * 字节流与字符流操作的本质区别只有一个：字节流是原生的操作，而字符流是经过处理后的操作。
 *      在进行网络数据传输、磁盘数据保存所保存所支持的数据类型只有：字节。
 *      而所有磁盘中的数据必须先读取到内存后才能进行操作，而内存中会帮助我们把字节变为字符。字符更加适合处中文。
 *
 * 不管使用的是字节流还是字符流，其基本的操作流程几乎是一样的，以文件操作为例；
 *      1. 根据文件路径创建File类对象 ；
 *      2. 根据字节流或字符流的子类实例化父类对象 ；
 *      3. 进行数据的读取或写入操作
 *      4. 关闭流(close())
 *
 * 对于IO操作属于资源处理，所有的资源处理操作(IO操作、数据库操作、网络)最后必须要进行关闭！
 * AutoCloseable自动关闭支持(这里不做展示）：
 *        从JDk1.7开始追加了一个AutoCloseable接口，这个接口的主要目的是自动进行关闭处理，但是这种处理一般不好用，因为使用它必须结合try..catch
 *        是否去使用由大家决定，但是一般不推荐使用，因为语法结构比较混乱，还是推荐大家使用close方法手工关闭资源。
 *
 * 字节输出流(OutputStream)
 * 如果要想通过程序进行内容输出，则可以使用java.io.OutputStream
 *      OutputStream类实现了Closeable，Flushable两个接口，这两个接口中的方法：
 *      1. Closeable: public void close() throws IOException;
 *      2. Flushable: public void flush() throws IOException;
 *      在OutputStream类中还定义有其他方法：
 *      1. 将给定的字节数组内容全部输出：public void write(byte b[]) throws IOException
 *      2. 将部分字节数组内容输出：public void write(byte b[], int off, int len) throws IOException
 *      3. 输出单个字节：public abstract void write(int b) throws IOException;
 *
 * 由于OutputStream是一个抽象类，所以要想为父类实例化，就必须要使用子类。由于方法名称都由父类声明好了，
 * 所以我们在此处只需要关系子类的构造方法。如果要进行文件的操作，可以使用FileOutputStream类来处理，这个类的构造方法如下：
 *      1. 接收File类（覆盖）：public FileOutputStream(File file) throws FileNotFoundException
 *      2. 接收File类（追加）：public FileOutputStream(File file, boolean append)
 *
 *
 *
 * 字节输入流(InputStream)
 *      利用了OutputStream实现了程序输出内容到文件的处理，下面使用InputStream类在程序中读取文件内容。InputStream类的定义如下：
 *      public abstract class InputStream implements Closeable
 * 发现InputStream类只实现了Closeable接口，在InputStream类中提供有如下方法：
 *      1.读取数据到字节数组中,返回数据的读取个数。如果此时开辟的字节数组大小大于读取的数据大小，则返回的就是读取个数；
 *      如果要读取的数据大于数组的内容，那么这个时候返回的就是数组长度；如果没有数据了还在读，则返回-1:public int read(byte b[]) throws IOException
 *      2.读取部分数据到字节数组中，每次只读取传递数组的部分内容，如果读取满了则返回长度(len),如果没有
 *      读取满则返回读取的数据个数，如果读取到最后没有数据了返回-1：public int read(byte b[], int off,int len) throws IOException
 *      3. 读取单个字节，每次读取一个字节的内容，直到没有数据了返回-1：public abstract int read() throwsIOException;
 *      同OutputStream的使用一样，InputStream是一个抽象类，如果要对其实例化，同样也需要使用子类。如果要对文件进行处理，则使用FileInputStream类。
 *
 *
 *
 * 字符输出流(Writer)
 *      字符适合于处理中文数据，Writer是字符输出流的处理类，这个类的定义如下:
 *      public abstract class Writer implements Appendable, Closeable, Flushable
 *
 *      与OutputStream相比多了一个Appendable接口。
 *      在Writer类里面也提供write()方法，而且该方法接收的类型都是char型，要注意的是，Writer类提供了一个直接输出字符串的方法：
 *      public void write(String str) throws IOException
 *
 *
 * 字符输入流(Reader)
 *      Reader依然也是一个抽象类。如果要进行文件读取，同样的，使用FileReader。
 *      在上面讲到的Writer类中提供有方法直接向目标源写入字符串，而在Reader类中没有方法可以直接读取字符串类型，这个时候只能通过字符数组进行读取操作
 *
 * 字符流适合处理中文，字节流适合处理一切数据类型（对中文支持不好）！
 *
 * 字节流vs字符流
 *      使用字节流和字符流从代码形式上区别不大。但是如果从实际开发来讲，字节流一定是优先考虑的，只有在处理中文时才会考虑字符流。
 *      因为所有的字符都需要通过内存缓冲来进行处理。所有字符流的操作，无论是写入还是输出，数据都先保存在缓存中。
 *
 * 
 *
 */
public class TestIO {
    public static void main(String[] args) throws IOException {
        /*范例：实现文件的内容输出*/
        File file = new File(File.separator+"Users"+File.separator+
                "Administrator"+File.separator+"Desktop"+File.separator+"Test.txt");
        if (!file.getParentFile().exists()){// 必须保证父目录存在
            file.getParentFile().mkdirs();
        }
        // OutputStream是一个抽象类，所以需要通过子类进行实例化，此时只能操作File类
        OutputStream output = new FileOutputStream(file);
        // 要求输出到文件的内容
        String msg = "My test file ";
        // 将内容变为字节数组
        output.write(msg.getBytes());
        // 关闭输出
        output.close();
        /*
            在进行文件输出的时候，所有的文件会自动帮助用户创建，不在需要调用createFile()方法手工创建。
            这个时候程序如果重复执行，并不会出现内容追加的情况而是一直在覆盖。如果需要文件内容追加，则需要调用FileOutputStream提供的另外一种构造方法。
        */

        /*范例：文件内容追加*/
        OutputStream output2 = new FileOutputStream(file,true);
        String msg2 = "hello world ";
        output2.write(msg2.getBytes());


        /*范例：部分内容输出*/
        String msg3 = "hello java ";
        output2.write(msg3.getBytes(),0,5);
        output2.close();
        /*
            此时Test.txt文件中的内容：
            My test file hello world hello
        */

        /*范例：实现文件信息的读取*/
        if(file.exists()){// 必须保证文件存在才能进行处理
            InputStream input = new FileInputStream(file);
            byte[] data = new byte[1024];// 每次可以读取的最大数量
            int len = input.read(data);// 此时的数据读取到了数组之中
            String result = new String(data,0,len);// 将字节数组转为String
            System.out.println("读取内容["+result+"]");
            input.close();
            /*
                结果：
                读取内容[My test file hello world hello]
            */
            //整个的操作流程可以发现OutputStream、InputStream类的使用形式上是非常类似的。

            /*范例：通过Writer类实现输出*/

            String msg4 = "窗前明月光";
            Writer out = new FileWriter(file);// 根据程序的流程，文件里的内容被重新定义了
            out.write(msg4);
            out.close();
            //Writer类的结构与方法的使用与OutputStream非常相似，只是Writer类对于中文的支持很好并且提供了直接写入String的方法而已。

            /*范例：通过文件读取数据*/
            if (file.exists()){
                Reader in = new FileReader(file);
                char[] data2 = new char[1024];
                int len2 = in.read(data2);// 将数据读取到字符数组中
                String result2 = new String(data2,0,len2);
                System.out.println("读取内容["+result2+"]");
                in.close();
                /*
                    结果：
                    读取内容[窗前明月光]
                */
            }
        }
    }
}
