package www.wss;

import java.io.*;

/**
 * @Author: WSS
 * @Date: 2019/4/6 23:51
 * @Description: 字符编码
 *
 *  1.常用字符编码
 *  在计算机的世界里面，所有的文字都是通过编码来描述的。对于编码而言，如果没有正确的解码，那么就会产生乱码。
 *  那么要想避免乱码问题，就必须清楚常见的编码有哪些
 *      1. GBK、GB2312：表示的是国标编码，GBK包含简体中文和繁体中文，而GB2312只包含简体中文。也就是说，这两种编码都是描述中文的编码。
 *      2. UNICODE编码：java提供的16进制编码，可以描述世界上任意的文字信息，但是有个问题，
 *      如果现在所有的字母也都使用16进制编码，那么这个编码太庞大了，会造成网络传输的负担。
 *      3. ISO8859-1：国际通用编码，但是所有的编码都需要进行转换。
 *      4. UTF编码：相当于结合了UNICODE、ISO8859-1，也就是说需要使用到16进制文字使用UNICODE，
 *      而如果只是字母就使用ISO8859-1，而常用的就是UTF-8编码形式。
 *
 *  2.乱码产生分析
 *      清楚了常用编码后，下面就可以观察一下乱码的产生。要想观察出乱码，就必须首先知道当前操作系统中默认支持的编码是什么(java默认编码)
 *      如果说现在本地系统所用的编码与程序所用编码不同，那么强制转换就会出现乱码。
 *
 *  乱码产生的本质：编码和解码不统一产生的问题。
 */
public class CharacterCoding {
    public static void main(String[] args) throws IOException {
        /*范例：读取java运行属性*/
        System.getProperties().list(System.out);
        /*
            结果中出现了：
            file.encoding=UTF-8
        */

        /*范例：观察乱码产生*/
        OutputStream out = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\Test.txt"));
        out.write("举头望明月".getBytes("ISO8859-1"));
        out.close();
        /*
            文件中的内容显示为：
            ?????
        */
    }
}
