package www.wss;

import java.io.*;

/**
 * @Author: WSS
 * @Date: 2019/4/6 21:54
 * @Description: 转换流
 *
 * 转换流的基本使用
 *      现在为止已经知道了两种数据流：字节流和字符流。实际上这两泪流是可以进行互相转换处理的。
 *      OutputStreamWriter:将字节输出流变为字符输出流（Writer对于文字的输出要比OutputStream方便）
 *      InputStreamReader:将字节输入流变为字符输入流（InputStream读取的是字节，不方便中文的处理）
 *
 * 文件拷贝
 *      建立一个CopyFile程序类，这个类通过初始化参数接收源文件与目标文件路径。
 *      1. 要想实现数据的拷贝肯定是要通过流的方式来完成，对于流有两类，由于要拷贝的内容不一定是文字数据，所以次此处我们采用字节流。
 *      2. 在进行拷贝的时候需要确定模式：a.在程序中开辟一个数组，该数组长度为文件长度，
 *         将所有数据一次性读取到该数组中随后进行输出保存。b.采用同边读边写的方式完成。
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
/*CopyFile类实现文件拷贝*/
/**
 * 该类具备如下功能：1.判断拷贝的源文件是否存在
 * 2.判断目标文件的父路径是否存在，如果不存在则创建父目录
 * 3.进行文件拷贝的处理
 */
class CopyFileUtil{
    private CopyFileUtil(){}// 构造方法私有化

    /***
     * 判断要拷贝的源路经是否存在
     * @param path 输入的源路径信息
     * @return 如果该路径真实存在返回true，否则返回false
     */
    public static boolean fileIsExists(String path){
        return new File(path).exists();
    }

    /***
     * 根据传入的路径判断父路径是否存在，如果不存在则创建
     * @param path 输出的目标地址，根据此地址判断父路经是否存在，不存在则创建
     */
    public static void createParentsDir(String path){
        File file = new File(path);
        if (!file.getParentFile().exists()){// 路径不存在
            file.getParentFile().mkdirs();// 创建多级父目录
        }
    }

    /***
     * 文件拷贝
     * @param sourcePath 源文件路径
     * @param destPath 目标文件路径
     * @return 是否拷贝成功
     * @throws FileNotFoundException
     */
    public static boolean copyFile(String sourcePath,String destPath)  {
        File inFile = new File(sourcePath);
        File outFile = new File(destPath);
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(inFile);
            fileOutputStream = new FileOutputStream(outFile);
            copyFileHandle(fileInputStream, fileOutputStream);// 完成具体文件拷贝处理
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    /***
     * 实现具体的文件拷贝操作
     * @param inputStream 输入流对象
     * @param outputStream 输出流对象
     */
    private static void copyFileHandle(InputStream inputStream,OutputStream outputStream) throws IOException {
        int temp = 0;
        do{
            temp = inputStream.read();// 读取单个字节数据
            outputStream.write(temp);// 通过输出流输出
        }while (temp != -1);
    }

    /***
     * 优化后的拷贝方法
     */
    private static void betterCopyFileHandle(InputStream inputStream,OutputStream outputStream) throws IOException {
        byte[] data = new byte[1024];
        int len = -1;
        while ((len = inputStream.read(data)) != -1){
            outputStream.write(data,0,len);
        }
    }


}
public class TransformStream {
    public static void main(String[] args) throws IOException {
        /*范例：观察字节流与字符流的转换*/
        File file = new File(File.separator+"Users"+File.separator+
                "Administrator"+File.separator+"Desktop"+File.separator+"Test.txt");
        if(!file.getParentFile().exists()){// 保证父目录存在
            file.getParentFile().mkdirs();
        }
        OutputStream output = new FileOutputStream(file);
        Writer out = new OutputStreamWriter(output);// 字节流转为字符流
        String msg = "你好，世界";
        out.write(msg);
        out.close();

        /*使用CopyFile类实现文件拷贝*/
        /*
            if (args.length != 2){// 参数不是两个
                System.out.println("非法操作");
                return;
            }
            String sourcePath = args[0]; // 取得源文件路径
            String destPath = args[1]; // 取得目标路径
            if (CopyFileUtil.fileIsExists(sourcePath)){
                CopyFileUtil.createParentsDir(destPath);
                System.out.println(CopyFileUtil.copyFile(sourcePath,destPath) ? "文件拷贝成功" : "文件拷贝失败");
            }else {
                System.out.println("源文件不存在，无法进行拷贝");
            }
        */
    }
}
