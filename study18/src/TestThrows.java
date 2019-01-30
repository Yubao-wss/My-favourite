import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Author: WSS
 * @Date:
 * @Description: 测试使用throws声明异常
 *       当CheckedException产生时，不一定立刻处理它，可以再把异常throws出去。
 *       在方法中使用try-catch-finally是由这个方法来处理异常。但是在一些情况下，当前方法并不需要处理发生的异常，而是向上传递给调用它的方法处理。
 *       如果一个方法中可能产生某种异常，但是并不能确定如何处理这种异常，则应根据异常规范在方法的首部声明该方法可能抛出的异常。
 *       如果一个方法抛出多个已检查异常，就必须在方法的首部列出所有的异常，之间以逗号隔开。
 */
public class TestThrows {
    public static void main(String[] args) throws IOException {
        readMyFile();
    }
    public static void readMyFile() throws IOException {
        FileReader reader = null;
            reader = new FileReader("d:\\b.txt");
            char c1 = (char)reader.read();
            System.out.println(c1);
                if (reader != null){
                    reader.close();
                }

    }
}
//结果：Exception in thread "main" java.io.FileNotFoundException: d:\b.txt (系统找不到指定的文件。)
//	at java.io.FileInputStream.open0(Native Method)
//	at java.io.FileInputStream.open(FileInputStream.java:195)
//	at java.io.FileInputStream.<init>(FileInputStream.java:138)
//	at java.io.FileInputStream.<init>(FileInputStream.java:93)
//	at java.io.FileReader.<init>(FileReader.java:58)
//	at TestThrows.readMyFile(TestThrows.java:20)
//	at TestThrows.main(TestThrows.java:16)


