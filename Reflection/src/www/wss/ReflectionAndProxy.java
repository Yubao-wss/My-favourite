package www.wss;

import java.lang.reflect.*;

/**
 * @Author: WSS
 * @Date: 2019/4/2 20:25
 * @Description: 反射与代理设计模式
 *
 * 1.基础代理设计模式
 *  代理设计模式的核心本质在于：一个接口有两个子类，一个负责真实业务，一个负责与真实业务有关的所有辅助性操作。
 *
 *   动态代理模式的引入：
 *   在开发中并不知道项目会有多少个接口，如果这些接口都需要使用到代理模式，那么就意味着每一个接口都需要编写两个子类，再假设这些接口的代理类的功能几乎都一样。
 *   之前的这种代理设计只是一种最简单的代理设计，所以这种代理设计只能够代理一个接口的子类对象，无法代理更多的接口子类对象。要想真正使用代理设计模式，我们需要引入动态代理设计模式
 *
 * 2.动态代理设计模式
 *   动态代理模式的核心特点：一个代理类可以代理所有需要被代理的接口的子类对象
 *
 *   动态代理实现的标识接口：
 *   只有实现此接口才具备有动态代理的功能
 *
 *   interface InvocationHandler{
 *
 *       invoke表示的是调用执行的方法，但是所有的代理类返回给用户的接口对象都属于代理对象
 *       当用户执行接口方法的时候所调用的实例化对象就是该代理主题动态创建的一个接口对象
 *       *@param proxy 表示被代理的对象信息
 *       *@param method 返回的是被调用的方法对象，取得了Method对象则意味着可以使用invoke()反射调用方法
 *       *@param args 方法中接收的参数
 *       *@return 方法的返回值
 *
 *       public Object invoke(Object proxy,Method method,Object[]args)throws InvocationTargetException,IllegalAccessException;
 *   }
 *
 */
/*Traditional*/
// 核心操作接口
interface ISubject{
    // 核心业务：吃
    public void eat();
}

class RealSubject implements ISubject{
    @Override
    public void eat() {
        System.out.println("吃饭!");
    }
}

class ProxySubject implements ISubject{

    private ISubject subject;

    public ProxySubject(ISubject subject) {
        this.subject = subject;
    }

    //辅助业务
    public void prepare(){
        System.out.println("做饭");
    }

    public void afterEat(){
        System.out.println("洗碗");
    }
    @Override
    public void eat() {
        this.prepare();
        this.subject.eat();// 核心业务
        this.afterEat();
    }
}

class Factory{
    private Factory(){}
    /*基础代理模式的方法*/
    public static <T> T getInstance(String className) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {

        T t = null;
        t = (T) Class.forName(className).newInstance();
        return t;
    }
    public static <T> T getInstance(String className,Object obj) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        T t = null;
        Constructor<?> cons = Class.forName(className).getConstructor(obj.getClass().getInterfaces()[0]);
        t = (T) cons.newInstance(obj);
        return t;
    }
    /*对于基础代理模式的优化*/
    public static <T> T secondGetInstance(String proxyClassName,String realClassName) throws IllegalAccessException,
            InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        T t = null;
        // 取得真实接口对象
        T realObj = getInstance(realClassName);
        Constructor<?> cons = Class.forName(proxyClassName).getConstructor(realObj.getClass().getInterfaces()[0]);
        t = (T) cons.newInstance(realObj);
        return t;
    }
}



/*动态代理设计*/
//动态代理设计的实现，代理类不再具体实现于某一个接口

//其他接口
interface AnotherISubject{
    public void eat(String msg,int num);
}

class AnotherRealSubject implements AnotherISubject{

    @Override
    public void eat(String msg, int num) {
        System.out.println("我要吃"+num + "分量的"+msg);
    }
}
/**
 * 动态代理类
 */
class DynamicProxySubject implements InvocationHandler {
    // 绑定任意接口的对象，使用Object描述
    private Object target;

    /***
     * 实现真实对象的绑定处理，同时返回代理对象
     * @param target
     * @return 返回一个代理对象(这个对象是根据接口定义动态创建生成的代理对象)
     */
    public Object bind(Object target){
        // 保存真实主题对象
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), (java.lang.reflect.InvocationHandler) this);
    }

    public void preHandle(){
        System.out.println("[ProxySubject] 方法处理前");
    }

    public void afterHandle(){
        System.out.println("[ProxySubject] 方法处理后");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
        this.preHandle();
        // 反射调用方法
        Object ret = method.invoke(this.target,args);
        this.afterHandle();
        return ret;
    }

}
public class ReflectionAndProxy {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException,
            ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        /*基础代理模式*/
        ISubject subject = Factory.getInstance("www.wss.ProxySubject",Factory.getInstance("www.wss.RealSubject"));
        subject.eat();
        /*
            结果：
            做饭
            吃饭!
            洗碗
         */
        /*以上程序如果结合反射之后，整体的处理会非常繁琐。不光开发端，使用者使用起来也很麻烦。对于以上操作，客户端最多只需要关系代理是谁，实际业务是谁即可。*/

        System.out.println("-------------------");
        /*优化后的基础代理*/
        ISubject subject2 = Factory.secondGetInstance("www.wss.ProxySubject","www.wss.RealSubject");
        subject2.eat();
        /*
            结果：
            做饭
            吃饭!
            洗碗
        */

        System.out.println("-------------------");
        /*动态代理*/
        AnotherISubject subject3 = (AnotherISubject) new DynamicProxySubject().bind(new AnotherRealSubject());
        subject3.eat("米饭",10);
        /*
            结果：
            [ProxySubject] 方法处理前
            我要吃10分量的米饭
            [ProxySubject] 方法处理后
        */
        System.out.println(subject3.getClass().getName());
        /*
            结果：
            www.wss.$Proxy0
        */
    }
}
