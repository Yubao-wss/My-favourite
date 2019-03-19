/**
 * @Author: WSS
 * @Date: 2019/3/17 15:18
 * @Description: Lambda表达式的使用
 *
 * Lambda是JDK1.8推出的重要新特性
 *
 * 面向对象语法最大的局限：结构必须非常完整。
 * 要想使用函数式编程有一个前提：接口必须只有一个方法，如果有两个方法，则无法使用函数式编程。如果现在某
 * 个接口就是为了函数式编程而生的，最好在定义时就让其只能够定义一个方法，所以有了一个新的注解：
 * //@FunctionalInterface
 *
 * 语法如下:
 * (参数) -> 单行语句 ;
 * (参数) -> {} ;（多行语句）
 */
//传统面向对象开发
        /*
            IMessage message = new IMessage() { //生成一个匿名内部类，该类继承于IMessage接口
                @Override
                public void print() {
                    System.out.println("Hello World");
                }
            };
            message.print();
        */
//函数式编程
//函数式编程的使用，目的还是输出一句话
        /*
            IMessage message = () -> System.out.println("Hello World");
            message.print();
        */
//定义一个接口
@FunctionalInterface // 表示是一个函数式编程接口，只允许有一个方法
interface IMessage{
    public void print();
}

interface IMath{
    public int add(int x,int y);
}

public class TestLambda {
    public static void main(String[] args) {
        IMessage message = () -> System.out.println("Hello World");// 等同于生成了一个匿名内部类，并覆写了接口中的方法
        message.print();// 结果：Hello World

        /*范例：多行语句*/
        IMessage message1 = () ->{
            System.out.println("Hello World1");
            System.out.println("Hello World2");
            System.out.println("Hello World3");
        };
        message1.print();
        /*
         结果：
            Hello World1
            Hello World2
            Hello World3
        */

        /*范例：直接进行计算*/
        IMath msg = (p1,p2) ->  p1 + p2 ;//如果现在表达式里只有一行进行数据的返回，那么直接使用语句即可，可以不使用return
        System.out.println(msg.add(10,20));// 结果：30

        msg = (p1,p2) -> {// 多行的写法
            if (p1 > 0){
                return p1+p2;
            }else {
                return p2-p1;
            }
        };

    }
}
