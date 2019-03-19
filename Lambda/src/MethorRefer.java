/**
 * @Author: WSS
 * @Date: 2019/3/19 16:51
 * @Description: 方法引用
 *
 * 从最初开始，只要是进行引用都是针对于引用类型完成的，也就是只有数组、类、接口具备引用操作。但是JDK1.8
 * 开始追加了方法引用的概念。实际上引用的本质就是别名。所以方法的引用也是别名的使用。而方法引用的类型有
 * 四种形式：
 *      1. 引用静态方法：类名称::static 方法名称 ；
 *      2. 引用某个对象的方法：实例化对象 :: 普通方法 ；
 *      3. 引用某个特定类的方法： 类名称 :: 普通方法 ；
 *      4. 引用构造方法： 类名称 :: new
 *
 * 注意：方法引用一般结合函数式编程使用
 */
@FunctionalInterface //只允许有一个方法
interface IUtil<P,R>{
    public R switchPara(P p);
}
@FunctionalInterface
interface Fun1<R>{
    public R switchPara();
}
@FunctionalInterface
interface Fun2<R,P>{
    public R compare(P p1,P p2);
}

@FunctionalInterface
interface Fun3<R,PN,PA>{
    public R createPerson(PN p1,PA p2);
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name +",age=" + age + "]";
    }
}
public class MethorRefer {
    public static void main(String[] args) {
        /*引用静态方法*/
        IUtil<Integer,String> iu = String :: valueOf; // 进行方法引用   （就相当于为方法起了个别名）
        String str = iu.switchPara(1000);// 相当于调用了String.valueOf(1000)
        System.out.println(str.length());
        /*
            结果：4
        */

        /*引用对象方法*/
        Fun1<String> f = "hello" :: toUpperCase;
        System.out.println(f.switchPara());
        /*
            结果：HELLO
        */

        /*引用类中普通方法*/
        Fun2<Integer,String> f2 = String::compareTo;
        System.out.println(f2.compare("A","S"));
        /*
            结果：-18
        */

        /*引用构造方法*/
        Fun3<Person,String,Integer> f3 = Person :: new;// 相当于调用Person类的构造方法
        System.out.println(f3.createPerson("wss",21));
        /*
            结果：Person [name=wss,age=21]
        */
    }
}
