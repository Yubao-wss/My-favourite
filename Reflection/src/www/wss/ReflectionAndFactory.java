package www.wss;

/**
 * @Author: WSS
 * @Date: 2019/3/20 9:45
 * @Description: 反射 与 工厂模式
 *
 * 工厂设计模式曾经给过原则：如果是自己编写的接口，要想取得本接口的实例化对象，最好使用工厂类来设计。
 * 但是也需要知道传统工厂设计所带来的问题。
 *
 * 传统工厂类在实际开发之中根本用不到。(问题就在于new)。每增加一个接口的子类就需要修改工厂类。
 *
 */
interface IFruit {
    public void eat();
}

class Apple implements IFruit{
    @Override
    public void eat() {
        System.out.println("[Apple]");
    }
}
/*范例：传统工厂类增加接口子类*/
class Orange implements IFruit{
    @Override
    public void eat() {
        System.out.println("[Orange]");
    }
}
// 传统工厂类
class FruitFactory{
    private FruitFactory(){}
    public static IFruit getInstance(String className){
        if ("apple".equals(className)){
            return new Apple();
        }else if ("orange".equals(className)){// 增加子类接口后，工厂类也需要改变
            return new Orange();
        }
        return null;
    }
}

//如果要想解决关键字new带来的问题，最好的做法就是通过反射来完成处理，
//因为Class类可以使用newInstance()实例化对象，同时Class.forName()能够接收类名称。
class NewFruitFactory {
    private NewFruitFactory(){}
    public static IFruit getInstance(String className){
        IFruit fruit = null;
        try {
            fruit = (IFruit) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fruit;
    }
}
/*
    引入反射后，每当新增接口子类，无需去修改工厂类代码就可以很方便的进行接口子类扩容。
    以上这种工厂类代码我们称之为简单工厂模式
*/
public class ReflectionAndFactory {
    public static void main(String[] args) {
        IFruit fruit = FruitFactory.getInstance("apple");
        fruit.eat();
        /*
            结果：
            [Apple]
        */

        fruit = NewFruitFactory.getInstance("www.wss.Orange");
        fruit.eat();
        /*
            结果：
            [Orange]
        */
    }
}
