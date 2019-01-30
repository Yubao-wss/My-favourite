import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: WSS
 * @Date:
 * @Description： 异常机制：
 *              异常指程序运行过程中出现的非正常现象，例如用户输入错误、除数为零、需要处理的文件不存在、数组下标越界等。
 *              在Java的异常处理机制中，引进了很多用来描述和处理异常的类，称为异常类。异常类定义中包含了该类异常的信息和对异常进行处理的方法。
 *              所谓异常处理，就是指程序在出现问题时依然可以正确的执行完。
 *
 *             Java是采用面向对象的方式来处理异常的。处理过程：
 *               1. 抛出异常：在执行一个方法时，如果发生异常，则这个方法生成代表该异常的一个对象，停止当前执行路径，并把异常对象提交给JRE。
 *               2. 捕获异常：JRE得到该异常后，寻找相应的代码来处理该异常。JRE在方法的调用栈中查找，从生成异常的方法开始回溯，直到找到相应的异常处理代码为止。
 *
 *            异常分类：JDK 中定义了很多异常类，这些类对应了各种各样可能出现的异常事件，所有异常对象都是派生于Throwable类的一个实例。如果内置的异常类不能够满足需要，还可以创建自己的异常类。
 *              Java对异常进行了分类，不同类型的异常分别用不同的Java类表示，所有异常的根类为java.lang.Throwable，Throwable下面又派生了两个子类：Error和Exception。
 *
 *            Error：
 *              Error是程序无法处理的错误，表示运行应用程序中较严重问题。大多数错误与代码编写者执行的操作无关，而表示代码运行时 JVM(Java 虚拟机)出现的问题。
 *              例如，Java虚拟机运行错误(Virtual MachineError)，当 JVM 不再有继续执行操作所需的内存资源时，将出现 OutOfMemoryError。
 *              这些异常发生时，Java虚拟机(JVM)一般会选择线程终止。
 *              Error表明系统JVM已经处于不可恢复的崩溃状态中。我们不需要管它。
 *
 *            Exception：是程序本身能够处理的异常
 *              如：空指针异常(NullPointerException)、数组下标越界异常(ArrayIndexOutOfBoundsException)、类型转换异常(ClassCastException)、算术异常(ArithmeticException)等。
 *              Exception类是所有异常类的父类，其子类对应了各种各样可能出现的异常事件。 通常Java的异常可分为：
 *               1. RuntimeException 运行时异常
 *               2. CheckedException 已检查异常
 */
public class TestException {
    public static void main(String[] args) {
        //RuntimeException 运行时异常处理
        //ArithmeticException异常

        /*int i = 1/0;
        System.out.println(i);*/

        //运行结果 Exception in thread "main" java.lang.ArithmeticException: / by zero
        //	        at TestException.main(TestException.java:47)
        //解决方法
        int b = 0;
        if (b != 0) {
            System.out.println(1 / b);
        }
        //派生于RuntimeException的异常，如被 0 除、数组下标越界、空指针等，其产生比较频繁，处理麻烦，如果显式的声明或捕获将会对程序可读性和运行效率影响很大。
        //因此由系统自动检测并将它们交给缺省的异常处理程序(用户可不必对其处理)。
        //这类异常通常是由编程错误导致的，所以在编写程序时，并不要求必须使用异常处理机制来处理这类异常,经常需要通过增加“逻辑处理来避免这些异常”。




        //NullPointerException异常（空指针）

        /*String str = null;
        str.length();*/

        //Exception in thread "main" java.lang.NullPointerException
        //	at TestException.main(TestException.java:62)
        //解决方法:解决空指针异常，通常是增加非空判断
        String str1 = null;
        if (str1 != null){
            System.out.println(str1.length());
        }




        //ClassCastException异常
        //在引用数据类型转换时，有可能发生类型转换异常(ClassCastException)

        /*class Animal{

        }
        class Dog extends Animal{

        }
        class Cat extends Animal{

        }
        Animal animal = new Dog();
        Cat cat = (Cat)animal;*/

        //Exception in thread "main" java.lang.ClassCastException: TestException$1Dog cannot be cast to TestException$1Cat
        //	at TestException.main(TestException.java:90)
        //解决方法：
        class Animal{

        }
        class Dog extends Animal{

        }
        class Cat extends Animal{

        }
        Animal animal = new Dog();
        if (animal instanceof Cat){
            Cat cat = (Cat) animal;
        }




        //ArrayIndexOutOfBoundsException异常
        //当程序访问一个数组的某个元素时，如果这个元素的索引超出了0~数组长度-1这个范围，则会出现数组下标越界异常(ArrayIndexOutOfBoundsException)

        /*int[] arr = new int[5];
        System.out.println(arr[5]);*/

        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
        //	at TestException.main(TestException.java:114)
        //解决方法：增加关于边界的判断
        int[] arr = new int[5];
        int a = 5;
        if (a < arr.length){
            System.out.println(arr[a]);
        }




        //NumberFormatException异常
        //在使用包装类将字符串转换成基本数据类型时，如果字符串的格式不正确，则会出现数字格式异常(NumberFormatException)

        /*String string = "123abc";
        System.out.println(Integer.parseInt(string));*/

        //Exception in thread "main" java.lang.NumberFormatException: For input string: "123abc"
        //	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
        //	at java.lang.Integer.parseInt(Integer.java:580)
        //	at java.lang.Integer.parseInt(Integer.java:615)
        //	at TestException.main(TestException.java:138)
        //解决方法：引入正则表达式判断是否为数字
        String string = "123abc";
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = p.matcher(string);
        if (m.matches()) { // 如果str匹配代表数字的正则表达式,才会转换
            System.out.println(Integer.parseInt(string));
        }

    }
}
