package com.company;

/**
 * @Auther: WSS
 * @Date:
 * @Description 内部类
 */
public class MyNestedClasses {
    public static void main(String[] args) {
        //创建非静态内部类对象
        Outer.Inner inner = new Outer().new Inner();
        inner.show();
        //静态内部类对象
        Outer2.Inner2 inner2 = new Outer2.Inner2();
        //匿名内部类
        MyNestedClasses.test01(new AA() {
            @Override
            public void aa() {
            }
        });
        //局部内部类
        new Outer3().show();
    }
    public static void test01(AA a){
        a.aa();
    }
}



class Outer{
    private int age = 10;
    public void tsstOuter(){
        System.out.println("Outer.testOuter()");
    }
    //非静态内部类：
    //非静态内部类必须寄存在一个外部类对象里。因此，如果有一个非静态内部类对象那么一定存在对应的外部类对象。非静态内部类对象单独属于外部类的某个对象。
    //非静态内部类可以直接访问外部类的成员，但是外部类不能直接访问非静态内部类成员。
    //非静态内部类不能有静态方法、静态属性和静态初始化块。
    //外部类的静态方法、静态代码块不能访问非静态内部类，包括不能使用非静态内部类定义变量、创建实例。
    class Inner{
        int age = 20;
        public void show(){
            int age = 30;
            System.out.println("外部类的成员变量age:"+Outer.this.age);
            System.out.println("内部类的成员变量age:"+this.age);
            System.out.println("局部变量age:"+age);//就近原则
            //成员变量访问要点：
            // 内部类里方法的局部变量：变量名。
            // 内部类属性：this.变量名。
            // 外部类属性：外部类名.this.变量名。
        }
    }
}

class Outer2{
    //静态内部类
    //相当于外部类的一个静态成员
    //当一个静态内部类对象存在，并不一定存在对应的外部类对象。 因此，静态内部类的实例方法不能直接访问外部类的实例方法。
    //静态内部类看做外部类的一个静态成员。 因此，外部类的方法中可以通过：“静态内部类.名字”的方式访问静态内部类的静态成员，通过 new 静态内部类()访问静态内部类的实例。
    static class Inner2{
    }
}

interface AA {
    void aa();
//匿名内部类
//适合那种只需要使用一次的类。比如：键盘监听操作等等。
//语法：
//new  父类构造器(实参类表) \实现接口 () {
//           //匿名内部类类体！
//}
//注意
// 匿名内部类没有访问修饰符。
// 匿名内部类没有构造方法。
//博客观摩
/*
https://www.cnblogs.com/nerxious/archive/2013/01/25/2876489.html
*/
}

 class Outer3 {
    public void show() {
        /*
        还有一种内部类，它是定义在方法内部的，作用域只限于本方法，称为局部内部类。
        局部内部类的的使用主要是用来解决比较复杂的问题，想创建一个类来辅助我们的解决方案，到那时又不希望这个类是公共可用的，所以就产生了局部内部类。局部内部类和成员内部类一样被编译，只是它的作用域发生了改变，它只能在该方法中被使用，出了该方法就会失效。
        局部内部类在实际开发中应用很少。
        */
        //作用域仅限于该方法

        class Inner {
            public void fun() {
                System.out.println("helloworld");
            }
        }
        new Inner().fun();
    }
}
