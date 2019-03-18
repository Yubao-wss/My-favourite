package www.wss;

/**
 * @Author: WSS
 * @Date: 2019/3/17 9:55
 * @Description: 测试泛型的使用
 *
 * 从JDK1.5以后引入了三大常用新特性：泛型、枚举(enum)、注解（Annotation）。
 * 其中在JDK1.5中泛型是一件非常重要的实现技术，它可以帮助我们解决程序的参数转换问题。
 *
 */
public class TestGenerics {
    //假设需要你定义一个描述坐标的程序类Point，需要提供两个属性x、y。对于这两个属性的内容可能有如下选择：
    /*
       1. x = 10、y = 20 ；
       2. x = 10.1、y = 20.1 ；
       3. x = 东经80度、y = 北纬20度
    */
    //那么现在首先要解决的问题就是Point类中的x、y的属性类型问题，此时需要保存的有int、double、String，所以
    //在java中只有一种类型可以保存所有类型：Object型

    static class Point{
        private Object x;
        private Object y;

        public Object getX() {
            return x;
        }

        public void setX(Object x) {
            this.x = x;
        }

        public Object getY() {
            return y;
        }

        public void setY(Object y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        //设置数据
        Point p = new Point();
        p.setX(10);// 自动装箱并向上转型为Object
        p.setY(20);
        //取出数据
        int x = (int) p.getX();// 强制向下转型为int并且自动拆箱
        int y = (int) p.getY();
        System.out.println("x = "+x+",y = "+y); /*结果：x = 10,y = 20*/

        p.setX("东经80度");
        p.setY("北纬20度");
        String x1 = (String)p.getX();
        String y1 = (String)p.getY();
        System.out.println("x = "+x1+",y = "+y1);/*结果：x = 东经80度,y = 北纬20度*/

        //上面的代码没有问题，由于每次都需要强制转型，这个时候由于设置方的错误，将坐标内容设置成了double与String，但是接收方不知道，于
        // 是在执行时就会出现ClassCastException 。ClassCastException 指的是两个没有关系的对象进行强转出现的异常。
        /*
            p.setX(10.2);
            p.setY("北纬20度");
            String x2 = (String) p.getX() ;
            String y2 = (String) p.getY() ;
            System.out.println("x = " +x+",y = "+y);
        */
        //这个时候语法不会对其做任何限制，但执行的时候出现了程序错误，所以得出结论：向下转型是不安全的操作，会带来隐患。

        //泛型类的使用
        NewPoint<String> np = new NewPoint<>();// JDK1.7以后的语法，以前<>中必须写类型
        np.setX("东经30度");
        np.setY("北纬40度");
        String x3 = np.getX();// 避免了向下转型
        String y3 = np.getY();
        System.out.println("x = "+x3+",y = "+y3);// 结果：x = 东经30度,y = 北纬40度
        /*
                泛型的出现彻底改变了向下转型的需求。引入泛型后，如果明确设置了类型，则为设置类型；
                如果没有设置类型，则默认为Object类型。
        */

        //泛型方法的使用
        MyClass<String> myClass = new MyClass<>();
        myClass.testMethod1("hello 泛型类");// 输出：hello 泛型类
        Integer i = myClass.testMethod2(100);
        System.out.println(i);//结果：100
        /*
            上面代码中，MyClass <T> 是泛型类，testMethod1 是泛型类中的普通方法，而 testMethod2 是一个泛型方法。
            而泛型类中的类型参数与泛型方法中的类型参数是没有相应的联系的，泛型方法始终以自己定义的类型参数为准。
        */
        //泛型类的实际类型参数是 String，而传递给泛型方法的类型参数是 Integer，两者不相干。
        //但是，为了避免混淆，如果在一个泛型类中存在泛型方法，那么两者的类型参数最好不要同名。
        //MyClass <T> 代码可以更改为这样：
        /*
            class MyClass<T>{
                public void testMethod1(T t) {
                    System.out.println(t);
                }
                public <E> E testMethod2(E e) {
                    return e;
                }
            }
        */
    }
    //由此引出泛型，使用泛型就可以避免上述问题，大量简化代码量
    static class NewPoint <T>{ //T表示参数，是一个占位的标记；如果有多个泛型就在后面追加
        private T x;
        private T y;

        public T getX() {
            return x;
        }

        public void setX(T x) {
            this.x = x;
        }

        public T getY() {
            return y;
        }

        public void setY(T y) {
            this.y = y;
        }
    }

    //泛型方法：
    //泛型不仅可以用于定义类，还可以单独来定义方法。
    static class MyClass <T>{// 泛型方法可以与泛型类共存
        public void testMethod1(T t){
            System.out.println(t);
        }
        /*
        泛型方法与泛型类稍有不同的地方是，类型参数也就是尖括号那一部分是写在返回值前面的。
        <T> 中的 T 被称为 类型参数，而方法中的 T 被称为参数化类型，它不是运行时真正的参数。
    */
        //当然，声明的类型参数，其实也是可以当作返回值的类型的。
        //范例：使用类型参数做返回值的泛型方法
        public <T> T testMethod2(T t){
            return t;
        }
    }


}
