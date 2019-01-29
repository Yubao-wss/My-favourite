import java.io.File;
import java.io.IOException;

/**
 * @Author: WSS
 * @Date:
 * @Description File类的综合应用
 */
public class FileApplication {
    public static void main(String[] args) {
        //指定一个文件
        File file = new File("C:\\Users\\Administrator\\Desktop\\java_project\\test.txt");
        //判断该文件是否存在
        boolean flag = file.exists();
        //如果存在就删除，如果不存在就创建
        if (flag){
            //删除
            boolean flag2 = file.delete();
            if (flag2) {
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        }else {
            //创建
            boolean flag3 = true;
            try {
            //如果目录不存在，先创建目录
            File dir = file.getParentFile();
            dir.mkdirs();
            //创建文件
                flag3 = file.createNewFile();
                System.out.println("创建成功");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("创建失败");
            }
        }
    }
}
