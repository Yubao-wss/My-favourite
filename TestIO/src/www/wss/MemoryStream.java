package www.wss;

import java.io.*;

/**
 * @Author: WSS
 * @Date: 2019/4/7 0:04
 * @Description: 内存操作流
 *
 * 1.内存流概念
 *      在之前所有的操作都是针对于文件进行的IO处理。除了文件之外，IO的操作也可以发生在内存之中，这种流称之为内存操作流。
 *      文件流的操作里面一定会产生一个文件数据(不管最后这个文件数据是否被保留)。
 *      如果现在需求是：需要进行IO处理，但是又不希望产生文件。这种情况下就可以使用内存作为操作终端。
 *
 *      对于内存流也分为两类：
 *      1. 字节内存流:ByteArrayInputStream、ByteArrayOutputStream
 *      2. 字符内存流:CharArrayReader、CharArrayWriter
 *
 * 2.内存流操作
 *      内存操作流还有一个很小的功能，可以实现两个文件的合并处理(文件量不大)。
 *      内存操作流最为核心的部分就是：将所有OutputStream输出的程序保存在了程序里面，所以可以通过这一特征实现处理。
 *
 *
 *
 *
 */
public class MemoryStream {
    public static void main(String[] args) throws IOException {
        /*范例：通过内存流实现大小写转换*/
        String msg = "hello world";
        // 实例化InputStream类对象，实例化的时候需要将你操作的数据保存到内存之中
        // 最终读取的就是你设置的内容
        InputStream input = new ByteArrayInputStream(msg.getBytes());
        OutputStream output = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = input.read()) != -1){// 逐字节进行处理
            output.write(Character.toUpperCase(temp));
        }
        // 直接输出output对象
        System.out.println(output);
        /*
            结果：
            HELLO WORLD
            这个时候发生了IO操作，但是没有文件产生，可以理解为一个临时文件处理。
        */

        input.close();
        output.close();


        /*范例：内存流实现文件合并处理*/
        /*
            文件data-a中的内容为H e l l o
            文件data-a中的内容为W o r l d
        */
        File[] files = new File[]{new File("C:\\Users\\Administrator\\Desktop\\data-a.txt"),
            new File("C:\\Users\\Administrator\\Desktop\\data-b.txt")};
        String[] data = new String[2];
        for(int i = 0; i < files.length; i++){
            data[i] = readFile(files[i]);
        }
        // 组合操作
        StringBuffer buf = new StringBuffer();
        String contenA [] = data[0].split(" ");
        String contenB [] = data[1].split(" ");
        for (int i = 0;i < contenA.length;i++){
            buf.append(new StringBuffer(contenA[i]).append("(").append(new StringBuffer(contenB[i]).append(")").append(" ")));
        }
        System.out.println(buf);
        /*
            结果：
            H(W) e(o) l(r) l(l) o(d)
        */

    }

    public static String readFile(File file) throws IOException {
        if (file.exists()){
            InputStream input = new FileInputStream(file);
            // 没有向上转型，因为稍后要使用到toByteArray()方法
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int temp = 0;
            byte[] data = new byte[10];
            while((temp = input.read(data)) != -1){
                // 将数据保存在bos中
                bos.write(data,0,temp);
            }
            bos.close();
            input.close();
            // 将读取内容返回
            return new String(bos.toByteArray());
        }
        return null;
    }
}
