/**
 * @Auther: WSS
 * @Date:
 * @Description 测试StringBuilder、StringBuffer
 *              StringBuffer和StringBuilder非常类似，均代表可变的字符序列。
 *              这两个类都是抽象类AbstractStringBuilder的子类，方法几乎一模一样。
 *              AbstractStringBuilder 部分源码
 *
 *              abstract class AbstractStringBuilder implements Appendable, CharSequence {
 *                  /**
 *                   * The value is used for character storage.
 *                   *
 *                  char value[];
 *              }
 *
 *              显然，内部也是一个字符数组，但这个字符数组没有用final修饰，随时可以修改。
 *              因此，StringBuilder和StringBuffer称之为“可变字符序列”。
 *
 *
 *
 *
 */
public class TestStringBuider {
    public static void main(String[] args) {

        //StringBuilder线程不安全，不做线程同步检查，效率高（一般使用它）；StringBuffer线程安全，做线程同步检查，效率低。
        StringBuilder sb = new StringBuilder("abcdefg");
        System.out.println(Integer.toHexString(sb.hashCode()));//sb的地址
        System.out.println(sb);

        //常用方法
        sb.setCharAt(2,'m');//修改字符串
        System.out.println(Integer.toHexString(sb.hashCode()));//sb的地址
        System.out.println(sb);
        //结果：1540e19d
        //     abcdefg
        //     1540e19d
        //     abmdefg

        StringBuilder sb2 = new StringBuilder("123");
        for (int i=0;i<26;i++){
            char temp = (char)('a'+i);
            sb2.append(temp);//向后填充
        }
        System.out.println(sb2);//结果：123abcdefghijklmnopqrstuvwxyz

        sb2.reverse(); //倒序
        System.out.println(sb2);//结果：zyxwvutsrqponmlkjihgfedcba321
        sb2.setCharAt(0,'P');//改变指定索引位置的字符
        System.out.println(sb2);//结果：Pyxwvutsrqponmlkjihgfedcba321

        sb2.insert(1,'Y');//指定索引位置插入一个字符
        System.out.println(sb2);//结果：PYyxwvutsrqponmlkjihgfedcba321
        /*public StringBuilder insert(int offset, int i) {
            super.insert(offset, i);
            return this;
        }*//*（insert方法源码，返回值为当前对象）*/
        sb2.insert(1,'K').insert(1,'B');//insert方法可以链式调用
        System.out.println(sb2);//结果：PBKYyxwvutsrqponmlkjihgfedcba321

        sb2.delete(0,3);//删除指定字符，左闭右开，可以链式调用
        System.out.println(sb2);//结果：Yyxwvutsrqponmlkjihgfedcba321


        //使用陷阱
        /*使用String进行字符串的拼接*/
        /*本质上使用StringBuilder拼接，但每次循环都会生成一个StringBuilder对象*/
        long num1 = Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
        long time1 = System.currentTimeMillis();//获取系统的当前时间
        String str = "";
        for (int i = 0;i<500;i++){
            str = str + i;//相当于产生了1000个对象，耗费资源
        }
        long num2 = Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
        long time2 = System.currentTimeMillis();//获取系统的当前时间
        System.out.println("String方法占用内存" + (num1 - num2));
        System.out.println("String方法占用时间" + (time2-time1));


        /*使用StringBuilder进行字符串的拼接*/
        long num3 = Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
        long time3 = System.currentTimeMillis();//获取系统的当前时间
        StringBuilder sb3 = new StringBuilder("");
        for (int i = 0;i<500;i++){
            sb3.append(i);//往字符数组中追加，不会产生额外对象
        }
        long num4 = Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
        long time4 = System.currentTimeMillis();//获取系统的当前时间
        System.out.println("StringBuilder方法占用内存" + (num3 - num4));
        System.out.println("StringBuilder方法占用时间" + (time4-time3));
        //结果： String方法占用内存2730688
        //      String方法占用时间1
        //      StringBuilder方法占用内存0
        //      StringBuilder方法占用时间0
    }
}
