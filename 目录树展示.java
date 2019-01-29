import java.io.File;

/**
 * @Author: WSS
 * @Date:
 * @Description 使用递归算法，以树状结构展示文件目录树
 */
public class TestCatalogTree {
    public static void main(String[] args) {
        File file = new File("D:\\a");
        /*
        用于测试程序
        在D盘建立文件夹a，其中有b、c、d三个子文件夹及文件a.txt,
        文件夹b中有子文件夹e、f和 文件b.txt
        文件夹c中有子文件夹g和 文件c.txt
        文件夹d中有 文件d.txt
        文件夹e中有子文件夹h和文件e.txt
         */
        printFile(file,0);
    }

    static void printFile(File file,int level){
        //输出层数
        for (int i=0;i<level;i++){
            System.out.print("-");
        }
        //输出文件名
        System.out.println(file.getName());
        //如果file是目录，获取子文件列表
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File temp:files){
                printFile(temp,level+1);//递归调用,层级+1
            }
        }
    }
}
//输出结果：
        /*
        a
        -b
        --b.txt
        --e
        ---e.txt
        ---h
        --f
        -c
        --c.txt
        --g
        -d
        --d.txt
        */
