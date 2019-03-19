/**
 * @Author: WSS
 * @Date: 2019/3/19 12:35
 * @Description: 注解（Annotation）
 *
 * Annotation可以说是JDK发展的重要技术，从现在的开发来讲，Annotation的使用已经变得非常常见。
 *
 * 要想理解Annotation的作用，对于软件项目的开发往往会经历以下过程：
 *      在进行软件项目的开发过程之中，会将所有使用到的第三方信息或者程序有关的操作都写在程序里
 *      如果现在服务器地址改变了，意味着需要你更改程序源代码。而这个工程就相当庞大了。
 *
 *      后来使用一个配置文件，程序运行的时候要通过配置文件读取相关的配置操作。
 *      如果此时要想更改一些配置，那么只需要更改配置文件即可，也就是可以在不修改源代码的前提下实现项目的变更。
 *
 *      使用配置文件之后，虽然代码的维护方便了，但是在开发里不方便。另外，对于非专业人士，很难去修改，并且一
 *      个项目的配置文件可能会非常多。于是后来JDK提供了一个新的做法，将配置写回到程序里，但是与传统程序作了
 *      区分，这样就形成了注解的概念。
 *
 * 这里主要解析JDK提供的三个内置注解：@Override、@Deprecated、@SuppressWarnings
 */
public class TestAnnotation {
    /*
        准确覆写
        @Override
        发生在继承关系之中，子类定义了与父类的方法名称相同、参数列表相同、返回值类型相同称为方法的
        覆写，被覆写的方法不能够拥有比父类更为严格的访问控制权限。
    */

    /*
        声明过期
        @Deprecated
        如果现在你有一个程序类，从项目1.0版本到一直到99.0版本一直都在使用着，但是从100.0版本后发现该程序类可
        能会产生问题，那么这个时候你能直接删除这个类换一个新的吗？
        绝对不能，因为其他旧版本还在使用这个类，并且这个类在旧版本中没有问题。这个时候就希望在进行新版本扩展
        的时候不再去使用这个不建议的类，所以加一个过期的注解(@Deprecated)。
    */

    static class Person{

        public Person(){}
        @Deprecated
        public Person(String name){}
        @Deprecated
        public void fun(){}

        @Override // 追加了此注解后将明确的表示该方法是一个覆写的方法，如果覆写错误会出现语法错误
        public String toString() {
            return "Hello";
        }
    }

    /*
        压制警告
        @SuppressWarnings
        当调用了某些操作可能产生问题的时候就会出现警告进行，但是警告信息并不是错，这个时候又不想总提示警告，
        这个时候可以使用压制警告。
    */

    @SuppressWarnings({"rawtypes","unused"})// 这时，在编译器中就不会再提示一些错误
    public static void main(String[] args) {
        System.out.println(new Person()); // 结果：Hello

        Person person = new Person("p");//函数名上有一条横线，表示过期
        person.fun();
        //这种过期的处理操作往往出现在一些平台支持的工具上，例如：JDK就是一个平台，所以在JDK中有很多方法都推荐用户不再使用了。

    }
}
