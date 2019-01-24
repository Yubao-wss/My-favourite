package com.company;

/**
 * @Auther: WSS
 * @Date:
 * @Description 接口
 */
//接口是比“抽象类”还“抽象”的“抽象类”
//抽象类还提供某些具体实现，接口不提供任何实现，接口中所有方法都是抽象方法。接口是完全面向规范的，规定了一批类具有的公共方法规范。
//接口和实现类不是父子关系，是实现规则的关系。比如：我定义一个接口Runnable，Car实现它就能在地上跑，Train实现它也能在地上跑，飞机实现它也能在地上跑。就是说，如果它是交通工具，就一定能跑，但是一定要实现Runnable接口。

interface MyInterface1{

    /*public static final*/ int maxAge = 100;

    /*public abstract*/ void test01();
}

class Myclass implements MyInterface1{
    @Override
    public void test01() {
        System.out.println("1");
    }
}
/**
 * 定义接口的详细说明：
 *
 * 1. 访问修饰符：只能是public或默认。
 *
 * 2. 接口名：和类名采用相同命名机制。
 *
 * 3. extends：接口可以多继承。
 *
 * 4. 常量：接口中的属性只能是常量，总是：public static final 修饰。不写也是。
 *
 * 5. 方法：接口中的方法只能是：public abstract。 省略的话，也是public abstract。
 */

/**
 * 飞行接口
 */
interface Volant{
    int FLY_HEIGHT = 1000;
    void fly();
}
/**
 * 善良接口
 */
interface Honest{
    void helpOther();
}

class Angel implements Volant,Honest{
    @Override
    public void fly() {
        System.out.println("Angel.fly()");
    }

    @Override
    public void helpOther() {
        System.out.println("Angel.helpOther()");
    }
}
public class MyInterface {
    public static void main(String[] args) {
        Volant v = new Angel();
        ((Angel) v).helpOther();
        v.fly();
    }
}

/**
 *接口的多继承
 */

interface A {
    void testa();
}
interface B {
    void testb();
}
/**接口可以多继承：接口C继承接口A和B*/
interface C extends A, B {
    void testc();
}
class Test implements C {
    @Override
    public void testa() {

    }

    @Override
    public void testb() {

    }

    @Override
    public void testc() {

    }
}