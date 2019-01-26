/**
 * @Auther: WSS
 * @Date:
 * @Description 包装类 Java是面向对象的语言，但并不是“纯面向对象”的，
 *              因为我们经常用到的基本数据类型就不是对象。但是我们在实际应用中经常需要将基本数据转化成对象，以便于操作。
 *              比如：将基本数据类型存储到Object[]数组或集合中的操作等等。
 *              为了解决这个不足，Java在设计类时为每个基本数据类型设计了一个对应的类进行代表，
 *              这样八个和基本数据类型对应的类统称为包装类(Wrapper Class)。
 *
 *              byte    ----------> Byte
 *              boolean ----------> Boolean
 *              short   ----------> Short
 *              char    ----------> Character
 *              int     ----------> Integer
 *              long    ----------> Long
 *              float   ----------> Float
 *              double  ----------> Double
 *
 *              在这八个类中，除了Character和Boolean以外，其他的都是“数字型”，
 *              “数字型”都是java.lang.Number的子类。Number类是抽象类，
 *              因此它的抽象方法，所有子类都需要提供实现。Number类提供了抽象方法：
 *              intValue()、longValue()、floatValue()、doubleValue()，
 *              意味着所有的“数字型”包装类都可以互相转型。
 */
public class TestWrappedClass {
    public static void main(String[] args) {
        //基本数据类型转成包装类对象
        Integer a = new Integer(3);
        Integer b = Integer.valueOf(30);

        //把包装类对象转成基本数据类型
        int c = b.intValue();
        double d = b.doubleValue();

        //把字符串转成包装类对象
        Integer e = new Integer("123");
        System.out.println(e);//结果123
        Integer f = Integer.parseInt("456");

        //包装类对象转为字符串
        String str = f.toString();

        //常见的常量
        System.out.println(Integer.MIN_VALUE);//-2147483648
        System.out.println(Integer.MAX_VALUE);//2147483647

        //包装类的主要用途
        /*作为和基本数据类型对应的类型存在，方便涉及到对象的操作，
        如Object[]、集合等的操作。
        包含每种基本数据类型的相关属性如最大值、最小值等，
        以及相关的操作方法(这些操作方法的作用是在基本数据类型、包装类对象、字符串之间提供相互之间的转化!)。*/
    }
}
