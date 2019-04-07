package www.wss;

import java.util.Date;

/**
 * @Author: WSS
 * @Date: 2019/3/17 16:03
 * @Description: 学习反射机制
 *
 */
public class TestReflection {
    //反射指的是对象的反向处理操作，既然是反向处理。我们先来观察一下"正"的操作。
    //在默认情况下，必须要先导入一个包，而后才能产生类的实例化对象
    /*范例：观察正常处理*/
    /*
        public static void main(String[] args) {
            Date date = new Date() ;
        }
    */

    //以上是我们正常的关于对象的处理流程:根据包名.类名找到类所谓的"反"指的是根据对象来取得对象的来源信息，
    // 而这个"反"的操作核心的处理就在于Object类的一个方法
    //取得Class对象:
    /*
        public final native Class<?> getClass();
    */

    /*范例：调用getClass()方法*/
    /*
        public static void main(String[] args) {
            Date date = new Date() ;
            System.out.println(date.getClass());// 结果：class java.util.Date
        }
    */
    /*此时通过对象取得了对象的来源，这就是"反"的本质。
    在反射的世界里面，看重的不再是一个对象，而是对象身后的组成(类、构造、普通、成员等)*/

    //Class类是描述整个类的概念，也是整个反射的操作源头，在使用Class类的时候需要关注的依然是这个类的对象。
    //而这个类的对象的产生模式一共有三种：
    /*
         1. 任何类的实例化对象可以通过Object类中的getClass()方法取得Class类对象。
         2. "类.class":直接根据某个具体的类来取得Class类的实例化对象。
         3. 使用Class类提供的方法:public static Class<?> forName(String className) throws ClassNotFoundException
    */


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Date date = new Date();
        /*范例：通过Object类中的getClass()方法取得Class类对象*/
        Object obj = date.getClass();
        System.out.println(obj);// 结果：class java.util.Date

        /*范例：使用Class.forName方法*/
        Class<?> cls = Class.forName("java.util.Date");
        System.out.println(cls.getName());// 结果：java.util.Date

        /*范例：类.class取得Class类的实例化对象*/
        System.out.println(Date.class);// 结果：class java.util.Date

        /*
            除了第一种方法会产生Date类的实例化对象之外，其他的两种都不会产生
            Date类的实例化对象。于是取得了Class类对象有一个最直接的好处:可以通过反射实例化对象，在Class类中定义有
            如下方法:
        */

        /*范例：反射实例化对象*/
        obj = cls.newInstance();// 使用无参构造实例化对象，等价于 new java.util.Date() ;
        System.out.println(obj);// 结果：Wed Mar 20 09:39:54 CST 2019

    }
}

