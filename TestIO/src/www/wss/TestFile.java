package www.wss;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: WSS
 * @Date: 2019/4/5 14:55
 * @Description: File文件操作类
 *
 * 在Java.io包之中，File类是唯一一个与文件本身操作(创建、删除、取得信息..)有关的程序类。
 * java.io.File类是一个普通的类，直接产生实例化对象即可。如果要实例化对象则需要使用到两个构造方法：
 *      public File(String pathname) ;
 *      public File(String parent, String child)，设置父路径和子路径。
 *
 * 如果要想进行文件的基本操作，可以使用File类的如下方法：
 *      创建一个新文件 :public boolean createNewFile()
 *      判断文件是否存在:public boolean exists()
 *      删除文件:public boolean delete()
 *
 * 目录操作，File类中关于目录有如下方法：
 *      取得父路径或父File对象：public String getParent()
 *                          public File getParentFile()
 *      创建目录(无论有多少级父目录，都会创建)：public boolean mkdirs()
 *
 * 文件信息,在File类里面提供有一系列取得文件信息的操作：
 *      1. 判断路径是否是文件: public boolean isFile()
 *      2. 判断路径是否是目录: public boolean isDirectory()
 *      3. 取得文件大小(字节): public long length()
 *      4. 最后一次修改日期 : public long lastModified()
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        /*范例：创建新文件*/
        File file = new File("C:\\Users\\Administrator\\Desktop\\Test.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*范例：编写文件的基本操作(如果文件不存在则进行创建；存在则删除)*/
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\Test1.txt");
        if (file.exists()){
            file.delete();
        }else {
            file.createNewFile();
        }

        //以上实现了最简化的文件处理操作，但是代码存在两个问题：
        /*
          1.实际项目部署环境可能与开发环境不同。那么这个时候路径的问题就很麻烦了。windows下使用的是"\",
          而Unix系统下使用的是"/"。所以在使用路径分隔符时都会采用File类的一个常量"public static final String separator "来描述。

          2.在Java中要进行文件的处理操作是要通过本地操作系统支持的，在这之中如果操作的是同名文件，
          就可能出现延迟的问题。（开发之中尽可能避免文件重名问题）
        */
        /*使用File.separator来避免由于操作系统不同而产生的错误*/
        File file2 = new File(File.separator+"Users"+File.separator+
                "Administrator"+File.separator+"Desktop"+File.separator+"Test2.txt");
        file2.createNewFile();

        /*范例：Java文件目录操作*/
        File file3 = new File("C:"+File.separator+"Users"+File.separator+
                "Administrator"+File.separator+"Desktop"+File.separator+"JavaIO"
                +File.separator+"company"+File.separator+"Test.txt");
        if (!file3.getParentFile().exists()){// 如果目录不存在
            file3.getParentFile().mkdirs();// 有多少级父目录就创建多少级
        }
        if (file3.exists()){
            file3.delete();// 文件存下，进行删除
        }else {
            file3.createNewFile();
        }

        /*范例：取得文件信息*/
        if (file2.exists() && file2.isFile()){// 保证文件存在再进行操作
            System.out.println("文件大小："+file2.length());
            System.out.println("最后一次修改日期: " + new Date(file.lastModified()));
        }
        /*
            结果：
            文件大小：0
            最后一次修改日期: Thu Jan 01 08:00:00 CST 1970
        */

        /*范例：列出目录中的全部组成*/
        File file4 = new File(File.separator+"Users"+File.separator+
                "Administrator"+File.separator+"Desktop");
        //保证是个目录且存在
        if(file4.exists() && file4.isDirectory()){
            //列出目录中的全部内容
            File[] result = file4.listFiles();
            for(File f : result){
                System.out.println(f);
            }
        }
    }
}
