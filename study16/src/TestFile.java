import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @Author: WSS
 * @Date:
 * @Description java.io.File类：代表文件和目录
 *              在开发中，读取文件、生成文件、删除文件、修改文件的属性时经常会用到本类。
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\java_project\\test.txt");//绝对路径,如果直接写文件名，则默认放到user.dir目录下
        file.createNewFile();//创建文件
        System.out.println(file);//C:\Users\Administrator\Desktop\java_project\test.txt
        file.renameTo(new File("C:\\Users\\Administrator\\Desktop\\java_project\\rename.txt"));//文件改名

        System.out.println(System.getProperty("user.dir"));//C:\Users\Administrator\Desktop\java_project\study16--->当前项目的路径
        File file2 = new File("ss.txt");
        file2.createNewFile();//在当前项目下创建文件

        //File类访问属性的基本用法
        System.out.println("File是否存在："+file2.exists());//true
        System.out.println("File是否是目录："+file2.isDirectory());//false
        System.out.println("File是否是文件："+file2.isFile());//true
        System.out.println("File最后修改时间："+new Date(file2.lastModified()));//Tue Jan 29 17:14:55 CST 2019
        System.out.println("File的大小："+file2.length());//0
        System.out.println("File的文件名："+file2.getName());//ss.txt
        System.out.println("File的目录路径："+file2.getPath());//ss.txt
        System.out.println("File的目录路径："+file2.getAbsolutePath());//C:\Users\Administrator\Desktop\java_project\study16\ss.txt(绝对路径）
        file2.delete();//将该文件从硬盘上删除


        //使用mkdir创建目录
        File file3 = new File("A\\B\\C");
        boolean flag = file3.mkdir();
        System.out.println(flag);//false,目录结构中有一个不存在，则不会创建整个目录树
        File file4 = new File("A\\B\\C");
        boolean flag2 = file4.mkdirs();
        System.out.println(flag2);//true,目录结构中有不存在的也没关系，会创建整个目录树

        //mkdir()：创建一个目录，中间某个目录缺失，则创建失败
        //mkdirs()：创建多个目录，中间某个目录缺失，则创建该缺失目录

    }
}
