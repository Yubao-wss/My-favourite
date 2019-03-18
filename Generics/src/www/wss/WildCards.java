package www.wss;

import java.lang.reflect.Field;

/**
 * @Author: WSS
 * @Date: 2019/3/18 15:48
 * @Description: 泛型中的通配符
 *
 * 在程序类中追加了泛型的定义后，避免了ClassCastException 的问题，但是又会产生新的情况：参数的统一问题。
 * 而通配符的使用就恰好解决了这一问题
 *
 * 注意：上限可以用在声明，不能修改；而下限只能用在方法参数，可以修改内容！
 */
public class WildCards {

    static class Message<T>{
        private T message;

        public T getMessage() {
            return message;
        }

        public void setMessage(T message) {
            this.message = message;
        }
    }

    //通配符 “？” 描述的是它可以接受任意类型，但是由于不确定类型，所以无法进行修改操作
    public static void fun(Message<?> temp){
        //temp.setMessage(100); 错误！
        System.out.println(temp.getMessage());
    }

    //此时使用通配符 “？” 描述的是它可以接收 Number 及其子类的任意类型，但由于不确定类型，依然无法进行修改操作
    public static void fun2(TestExtend<? extends Number> temp){
        //temp.setMessage(100); 仍然错误！
        System.out.println(temp.getMessage());
    }

    /*范例：设置泛型下限*/
    public static void fun3(Message<? super String> temp){
        //此时可以进行修改操作（自动向上转型）
        temp.setMessage("key");
        System.out.println(temp.getMessage());
    }
    /*!注意，泛型下限不能在类后设置*/

                public static void main(String[] args) {
                    /*测试普通通配符*/
                    Message<Integer> message = new Message();
                    message.setMessage(100);
                    fun(message); // 结果： 100

                    /*测试 ？ extends 类*/
                    TestExtend<Integer> testextend = new TestExtend<>();
                    testextend.setMessage(55);
                    fun2(testextend);// 结果： 55

                    /*测试 ？ super 类*/
                    fun3(new Message<>());// 结果：key

                    /*测试泛型接口*/
                    IMessage<String> msg = new MessageImpl1();
                    msg.print("Hello");// 结果：Hello
                    IMessage msg2 = new MessageImpl2();
                    // msg2.print("5");//结果：java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer

                    /*观察类型擦除*/
                    Message<String> myClass1 = new Message<>();
                    Message<Integer> myClass2 = new Message<>();
                    System.out.println(myClass1.getClass() == myClass2.getClass());
                    //结果：true 因为 MyClass<String> 和 MyClass<Integer> 在 JVM 中的 Class 都是MyClass.class

                    MyClass<String,Integer> myClass = new MyClass<>();
                    Class cls = myClass1.getClass();
                    Field[] fields = cls.getDeclaredFields();
                    for (Field field: fields){
                        System.out.println(field.getType());
                    }
                    //结果：class java.lang.Object
                    /*
                        在泛型类被类型擦除的时候，之前泛型类中的类型参数部分如果没有指定上限，如 <T> 则会被转译成普通的
                        Object 类型，如果指定了上限如 <T extends String> 则类型参数就被替换成类型上限
                    */
                }

    //？ extends 类：设置泛型上限
    //例如：? extends Number，表示只能够设置Number或其子类，例如：Integer、Double等；
    //？ super 类：设置泛型下限
    //例如：? super String，表示只能够设置String及其父类Object。

    /*范例：观察泛型上限*/
    static class TestExtend<T extends Number>{// 设置了泛型上限
        private T message;

        public T getMessage() {
            return message;
        }

        public void setMessage(T message) {
            this.message = message;
        }
    }

    //泛型接口
    /*范例：定义一个泛型接口*/
    interface IMessage<T>{// 在接口定义了泛型
        public void print(T t);
    }

    //对于这个接口的实现子类有两种做法
    /*范例：在子类定义时继续使用泛型*/
    static class MessageImpl1<T> implements IMessage<T>{
        @Override
        public void print(T t) {
            System.out.println(t);
        }
    }

    /*范例：在子类实现接口的时候明确给出具体类型*/
    static class MessageImpl2 implements IMessage<Integer>{
        @Override
        public void print(Integer s) {
            System.out.println(s);
        }
    }

    //类型擦除
    /*
        泛型是 Java 1.5 版本才引进的概念，在这之前是没有泛型的概念的，但显然，泛型代码能够很好地和之前版本的代码很好地兼容。
        这是因为，泛型信息只存在于代码编译阶段，在进入 JVM 之前，与泛型相关的信息会被擦除掉，专业术语叫做类型擦除。
        通俗地讲，泛型类和普通类在 java 虚拟机内是没有什么特别的地方。
    */

    static class MyClass<T,E>{
        private T message;
        private E text;

        public T getMessage() {
            return message;
        }

        public void setMessage(T message) {
            this.message = message;
        }

        public E getText() {
            return text;
        }

        public void setText(E text) {
            this.text = text;
        }

        public void testMethod(T t){
            System.out.println(t);
        }
    }
}
