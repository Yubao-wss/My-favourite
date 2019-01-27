/**
 * @Auther: WSS
 * @Date:
 * @Description 测试String类
 *              String 类对象代表不可变的Unicode字符序列，对象内部的成员变量的值无法再改变。
 *
 */
public class TestString {
    public static void main(String[] args) {
        //substring()是对字符串的截取操作，但本质是读取原字符串内容生成了新的字符串。
        String s1 = new String("abcdefg");
        String s2 = s1.substring(2,5);
        System.out.println(s1);
        //结果：abcdefg

        System.out.println(Integer.toHexString(s1.hashCode()));
        System.out.println(Integer.toHexString(s2.hashCode()));
        // 打印： b8197464 显然s1和s2不是同一个对象
        //      18024

        //在遇到字符串常量之间的拼接时，编译器会做出优化，即在编译期间就会完成字符串的拼接。
        //因此，在使用==进行String对象之间的比较时，我们需要特别注意。
        String str1 = "hello" + " java";//相当于str1 = "hello java";编译器做了优化，直接在编译的时候将字符串进行拼接
        String str2 = "hello java";
        System.out.println(str1 == str2);//true
        String str3 = "hello";
        String str4 = " java";
        //编译时不知道变量中储存的是什么，所以没办法在编译时优化
        String str5 = str3+str4;
        System.out.println(str2 == str5);//false

        System.out.println(str2.equals(str5));//true,所以做字符串比较时，尽量使用equals

    }
}
