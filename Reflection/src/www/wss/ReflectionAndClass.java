package www.wss;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: WSS
 * @Date: 2019/3/20 12:19
 * @Description: 反射与类操作
 *
 * 利用反射可以做出一个对象具备的所有操作行为，最为关键的是这一切的操作都可以基于Object进行。
 *
 *  1.取得父类信息
 *
 *       取得类的包名称: public Package getPackage()
 *       取得父类的Class对象: public native Class<? super T> getSuperclass();
 *       取得实现的父接口:public Class<?>[] getInterfaces()
 *
 *  2.反射调用构造
 *
 *       取得指定参数类型的构造:public Constructor<T> getConstructor(Class<?>... parameterTypes)
 *       取得类中的所有构造:public Constructor<?>[] getConstructors() throws SecurityException
 *     以上两个方法返回的类型都是java.lang.reflect.Constructor类的实例化对象，这个类之中大家只需要关注一个方法.
 *       实例化对象:
 *       public T newInstance(Object ... initargs)
 *
 *  3.反射调用普通方法
 *
 *       类中普通方法的反射调用你在开发之中一定会使用到，并且使用好了可以节省大量的重复编码。在Class类中有如下两种取得类中普通方法的函数:
 *       取得全部普通方法:public Method[] getMethods() throws SecurityException
 *       取得指定普通方法:public Method getMethod(String name, Class<?>... parameterTypes)
 *       以上两个方法范辉的类型是java.lang.reflect.Method类的对象，在此类中提供有一个调用方法的支持:
 *       调用:public Object invoke(Object obj, Object... args)
 *
 *  4.反射调用类中属性
 *
 *       前提:类中的所有属性一定在类对象实例化之后才会进行空间分配，所以此时如果要想调用类的属性，必须保证有实
 *       例化对象。通过反射的newInstance()可以直接取得实例化对象(Object类型)
 *       在Class类中提供有两组取得属性的方法:
 *       1. 第一组（父类中）-取得类中全部属性: public Field[] getFields()
 *       2. 第一组(父类中)-取得类中指定名称属性: public Field getField(String name)
 *       3. 第二组(本类中)-取得类中全部属性: public Field[] getDeclaredFields()
 *       4. 第二组(本类中)-取得类中指定名称属性 : public Method getDeclaredMethod(String name, Class<?>... parameterTypes)
 *
 */
interface IMessage{}
interface TestMessage{}

class CLS implements IMessage,TestMessage{}

class Person{
    public String name;
    public int age;

    public Person() {}
    public Person(String name){}
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ",age=" + age + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //设置1个private方法
    private void pp(){
        System.out.println("this is private pp");
    }
}

class Student extends Person{
    private String school;
}

public class ReflectionAndClass {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        /*范例：取得包名称*/
        Class<?> cls = CLS.class;// 取得class类对象
        System.out.println(cls.getPackage().getName());
        /*
            结果：
            www.wss
        */

        /*范例：取得父类(实现的父接口)*/
        //取得父类名称
        System.out.println(cls.getSuperclass().getName());
        /*
            结果：
            java.lang.Object
        */

        //取得实现的父接口对象
        Class<?>[] iClass = cls.getInterfaces();
        for (Class<?> class1 : iClass){
            System.out.println(class1.getName());
        }
        /*
            结果：
            www.wss.IMessage
            www.wss.TestMessage
        */
        //通过反射可以取得类结构上的所有关键信息

        /*范例：取得类中所有构造信息*/
        //取得类中的全部构造
        cls = Person.class;/*由此获得反射入口*/
        Constructor<?>[] constructors = cls.getConstructors();
        for (Constructor<?> constructor:constructors){
            System.out.println(constructor);
        }
        /*
            结果：
            public www.wss.Person()
            public www.wss.Person(java.lang.String)
            public www.wss.Person(java.lang.String,int)
        */
        /*
        以上的操作是直接利用了Constructor类中的toString()方法取得了构造方法的完整信息(包含方法权限，参数列表)，
        而如果只使用了getName()方法，只会返回构造方法的包名.类名。
        */

        /*范例：取得指定参数类型的构造*/
        //public Constructor<T> getConstructor(Class<?>... parameterTypes)方法，参数为构造方法参数的类名
        Constructor<?> constructor1 = cls.getConstructor(String.class);
        System.out.println(constructor1);
        /*
            结果：
            public www.wss.Person(java.lang.String)
        */

        /*范例：Class实例化对象*/
        System.out.println(cls.newInstance());
        /*
            结果：
            Person [name=null,age=0]
        */
        /*
            Class类通过反射实例化类对象的时候，只能够调用类中的无参构造。
            如果现在类中没有无参构造则无法使用Class 类调用，只能够通过明确的构造调用实例化处理。
            所以在定义简单java类的时候一定要保留有一个无参构造
        */


        /*通过Constructor类实例化对象*/
        Constructor<?> cons = cls.getConstructor(String.class, int.class);/*注意：在这里int.class和Integer.class可不一样，参数必须和原构造方法中的参数一致*/
        System.out.println(cons.newInstance("wss",21));
        /*
            结果：
            Person [name=wss,age=21]
        */


        /*范例：取得一个类中的公共普通方法*/
        Method[] methods = cls.getMethods();
        for (Method method : methods){
            System.out.println(method);
        }
        /*
            结果：
            public java.lang.String www.wss.Person.toString()
            public java.lang.String www.wss.Person.getName()
            public void www.wss.Person.setName(java.lang.String)
            public int www.wss.Person.getAge()
            public void www.wss.Person.setAge(int)
            public final void java.lang.Object.wait() throws java.lang.InterruptedException
            public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
            public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
            public boolean java.lang.Object.equals(java.lang.Object)
            public native int java.lang.Object.hashCode()
            public final native java.lang.Class java.lang.Object.getClass()
            public final native void java.lang.Object.notify()
            public final native void java.lang.Object.notifyAll()
        */
        /*可以看到输出结果中包含了Person类的普通方法，以及Person的父类的普通方法*/

        /*范例：取得指定方法*/
        Method mpp = cls.getMethod("getAge");
        System.out.println(mpp);
        /*
            结果：
            public int www.wss.Person.getAge()
        */

        /*
            之前程序编写的简单java类中的getter、setter方法采用的都是明确的对象调用。
            而现在有了反射机制处理之后，即使你没有明确的Person类型对象(依然需要实例化对象，Object对象描述，所有
            的普通方法必须在有实例化对象之后才可以进行调用)。就可以通过反射调用。
        */
        /*范例：通过反射调用setter、getter方法*/
        Object obj = cls.newInstance();
        Method steMethod = cls.getMethod("setName", String.class);

        steMethod.invoke(obj,"Wss");// 相当于Person对象.getName();
        Method getMethord = cls.getMethod("getName");
        Object result = getMethord.invoke(obj);// 相当于Person对象.getName();
        System.out.println(result);
        /*
            结果：
            Wss
        */
        /*
            此类操作的好处是:不再局限于某一具体类型的对象，而是可以通过Object类型进行所有类的方法调用
        */

        /*范例：取得类中全部属性*/
        cls = Student.class;
        /*取得类的公共属性*/
        Field[] fields = cls.getFields();
        for (Field field : fields){
            System.out.println(field);
        }
        /*
            结果：
            public java.lang.String www.wss.Person.name
            public int www.wss.Person.age
        */
        /*取得类中全部属性*/
        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields){
            System.out.println(field);
        }
        /*
            结果：
            private java.lang.String www.wss.Student.school
        */
        /*
            在实际开发之中，属性基本上都会进行封装处理，所以没有必要去关注父类中的属性。也就是说以后所取得的属性都以本类属性为主
            需要关注属性的核心描述类:java.lang.reflect.Field,在这个类之中有两个重要方法：
            1. 设置属性内容 : public void set(Object obj, Object value)
            2. 取得属性内容 : public Object get(Object obj)
        */


        /*范例：通过反射操作属性*/
        Object obj2 = cls.newInstance();
        Field schoolField = cls.getDeclaredField("school");//取得类中指定属性，参数为属性名称
        schoolField.setAccessible(true);/*注意：调用private属性需要这样取消封装*/
        schoolField.set(obj2,"XUST");// 相当于对象.school = "XUST";
        System.out.println(schoolField.get(obj2));// 取得属性
        /*
            结果：
            XUST
        */


        /*
            在Field类之中有一个特别有用的方法:
            取得属性类型:public Class<?> getType()
        */
        /*范例：取得属性类型*/
        System.out.println(schoolField.getType().getName());
        System.out.println(schoolField.getType().getSimpleName());
        /*
            结果：
            java.lang.String
            String
        */
    }

}
