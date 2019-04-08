package www.wss;

import java.io.*;

/**
 * @Author: WSS
 * @Date: 2019/4/8 14:09
 * @Description: 序列化
 *
 * 1.序列化的基本概念
 *      对象序列化是指：将内存中保存的对象变为二进制数据流的形式进行传输，或者是将其保存在文本之中。
 *      但是并不意味着所有类的对象都可以被序列化，严格来讲，需要被序列化的类对象往往需要传输使用，
 *      同时这个类必须实现java.io.Serializable接口。但是这个接口并没有任何的方法定义，只是一个标识而已。
 *
 *      序列化对象时所需要保存的就是对象中的属性，所以默认情况下对象的属性将被转为二进制数据流存在。
 *
 *
 * 2.序列化与反序列化
 *      如果要想实现序列化与反序列化的对象操作，在java.io包中提供有两个处理类:ObjectOutputStream、ObjectInputStream
 *
 * 3.transient关键字
 *      实际上序列化的处理在java.io包里面有两类，Serializable是使用最多的序列化接口，这种操作采用自动化模式完成，
 *      也就是说默认情况下所有的属性都会被序列化下来。
 *
 *      还有一个Externalizable接口是需要用户自己动手来处理序列化，一般很少使用。
 *
 *      但是由于Serializable默认会将对象中所有属性进行序列化保存，如果现在某些属性不希望被保存了，那么就可以使用transient关键字。
 *
 *
 */
/*范例：定义可以被序列化对象的类*/
class Person implements Serializable{
    private String name;
    private int age;
    private transient String salary;// 这里使用了关键字，使该属性无法被序列化
    public Person(String name,int age,String salary){
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary='" + salary + '\'' +
                '}';
    }
}
public class TestSerializable {
    public static final File FILE = new File("C:\\Users\\Administrator\\Desktop\\TestSerializable.txt");
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ser(new Person("Sam",18,"XUST"));

        dser();
        /*
            结果：
            Person{name='Sam', age=18, salary='null'}
        */
    }

    /***
     * 序列化对象，并传入文件
     * @param obj 被序列化的对象
     * @throws IOException
     */
    public static void ser(Object obj) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
        oos.writeObject(obj);
        oos.close();
    }

    /***
     * 反序列化
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void dser() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE));
        System.out.println(ois.readObject());
        ois.close();
    }
}
