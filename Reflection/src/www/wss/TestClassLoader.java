package www.wss;

import java.io.*;

/**
 * @Author: WSS
 * @Date: 2019/4/1 23:43
 * @Description: 测试ClassLoader类加载器
 *
 * Class类描述的是整个类的信息，在Class类中提供的forName()方法,这个方法根据ClassPath配置的路径进行类的加载，
 * 如果说现在你的类的加载路径可能是网络、文件，这个时候就必须实现类加载器，也就是ClassLoader类的主要作用。
 *
 * 什么是类加载器?
 * JVM设计团队把类加载阶段中的"通过一个类的全限定名来获取描述此类的二进制字节流"这个动作放在Java虚拟机外部去实现，
 * 以便让应用程序自己决定如何去获取所需要的类。实现这个动作的代码模块称之为"类加载器"
 *
 *      Bootstrap(启动类加载器)：这个类加载器使用C++实现，是虚拟机自身的一部分；其他的类加载器都由Java语言实现，
 *      独立于JVM外部并且都继承于java.lang.ClassLoader.BootStrap类加载器负责将存放于<Java_HOME>\lib目录
 *      中(或者被-Xbootclasspath参数指定路径中)能被虚拟机识别的(仅按照文件名识别，如rt.jar，名字不符合的类库即
 *      使放在lib目录中也不会被加载)类库加载到JVM内存中。启动类加载器无法被Java程序直接引用。
 *
 *      ExtClassLoader(扩展类加载器)：它负责加载<Java_HOME>\lib\ext目录中，或者被java.ext.dirs系统变量指定的路
 *      径中的类库。开发者可以直接使用扩展类加载器。
 *
 *      AppClassLoader(应用程序类加载器):负责加载用户类路径(ClassPath)上指定的类库，如果应用程序中没有自定义
 *      自己的类加载器，则此加载器就是程序中默认的类加载器。
 *
 * 双亲委派模型:
 *
 *      我们的应用程序都是由这三种加载器互相配合进行加载的，如果有必要，还可以加入自定义的类加载器。这些类加载器的关系一般如下:
 *
 *      自定义ClassLoader(多个) -> Application ClassLoader -> Extension ClassLoader -> Bootstrap ClassLoader
 *
 *      上面的这种层次关系，就称为类加载器的双亲委派模型，双亲委派模型要求除了顶层的父类加载器外，其余的类加载器都应有自己的父类加载器。
 *      双亲委派模型的工作流程是：如果一个类加载器收到了类加载请求，它首先不会自己去尝试加载这个类，
 *      而是把这个请求委托给父类加载器去完成，每一个层次的类加载器都是如此。
 *      【因此，所有的加载请求都应当传送到顶层的BootStrap加载器中，
 *      只有当父加载器反馈无法完成这个加载请求时(在自己搜索范围中没有找到此类)，子加载器才会尝试自己去加载。】
 *
 *      双亲委派模式对于保证Java程序的稳定运行很重要。有一个显而易见的好处就是Java类随着它的类加载器一起具备了一种带有优先级的层次关系。
 *      例如java.lang.Object类，它存放在rt.jar中，无论哪一个类加载器要加载这个类，最终都是委派给处于顶端的启动类加载器进行加载。
 *      因此，Object类在程序的各种类加载器环境中都是同一个类
 *
 *  自定义类加载器:由用户决定类从哪里加载
 *
 *      ClassLoader 类中提供有如下方法（进行类的加载）:
 *      protected Class<?> loadClass(String name, boolean resolve)
 *      ClassLoader提供的类加载:
 *      protected final Class<?> defineClass(String name, byte[] b, int off, int len)
 *
 *      在Desktop上建立New.java文件
 *      内容：
 *          public class New {
 *              @Override
 *              public String toString() {
 *              return "New";
 *              }
 *          }
 *      随后将此文件用javac编译后生成class文件。现在希望通过自定义的类加载器实现/Desktop/Member.class文件的加载。
 */
class Test{
    @Override
    public String toString() {
        return "Test";
    }
}

class Object{
    @Override
    public String toString() {
        return "My Object";
    }
}



/*实现自己的类加载器*/
class MyClassLoader extends ClassLoader{

    /***
     * 实现一个自定义的类加载器，传入类名称，通过指定路径加载
     * @param className 类名称
     * @return 返回的Class对象
     */
    public Class<?> loadData(String className) throws IOException {
        //加载类文件的信息
        byte[] classData = this.loadClassData();
        return super.defineClass(className,classData,0,classData.length);
    }

    /***
     * 通过指定的文件路径进行类的文件加载，实际上就是进行二进制文件读取
     * @return 类文件数据
     */
    private byte[] loadClassData() throws IOException {
        InputStream input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\New.class");

        //取得所有的字节内容，放到内存中
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //读取缓冲区
        //File I/O
        //文件内容转换为byte[]
        byte[] data = new byte[20];
        int temp = 0;
        while((temp = input.read(data)) != -1){
            bos.write(data,0,temp);
        }
        byte[] result = bos.toByteArray();
        input.close();
        bos.close();
        return result;
    }
}

public class TestClassLoader {
    public static void main(String[] args) throws Exception {

        /*观察ClassLoader的存在*/
        Class<?> cls = Test.class;
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
        /*
            结果：
            sun.misc.Launcher$AppClassLoader@18b4aac2
            sun.misc.Launcher$ExtClassLoader@1540e19d
            null
        */
        //出现了两个类加载器：ExtClassLoader(扩展类加载器)、AppClassLoader(应用程序类加载器)

        /*自己调用类加载器来生成一个类的实例，使用的是默认的类加载器*/
        System.out.println(Class.forName("www.wss.Object").getClassLoader().loadClass("www.wss.Object").newInstance());
        /*
            结果：
            My Object
        */

        /*使用自定义类加载器*/

        Class<?> cls2 = new MyClassLoader().loadData("New");
        System.out.println(cls2.getClassLoader());
        System.out.println(cls2.getClassLoader().getParent());
        System.out.println(cls2.getClassLoader().getParent().getParent());
        System.out.println(cls2.newInstance());
        /*
            结果：
            www.wss.MyClassLoader@14ae5a5
            sun.misc.Launcher$AppClassLoader@18b4aac2
            sun.misc.Launcher$ExtClassLoader@1540e19d
            New
        */

    }
}
