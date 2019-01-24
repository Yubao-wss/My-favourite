package com.company;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * 抽象类的意义在于:为子类提供统一的、规范的模板
 */
public abstract class MyAbstractClass {
    //抽象方法没有实现，子类必须实现
    abstract public void shout();

    public void run(){
        System.out.println("跑");
    }

    public static void main(String[] args) {
        Dog d = new Dog(10);
        System.out.println("######");
        d.print();
        System.out.println(d);
    }

}

class Dog extends MyAbstractClass{
    public Dog(){
        System.out.println(this);
    }

    public Dog(int num){
        for(int i=0;i<num;i++){
            Dog d = new Dog();
        }
    }
    @Override
    public void shout() {
        System.out.println("汪汪汪");
    }
    public void print(){
        System.out.println(this);
    }
}

/*
抽象类的使用要点:

1. 有抽象方法的类只能定义成抽象类

2. 抽象类不能实例化，即不能用new来实例化抽象类。

3. 抽象类可以包含属性、方法、构造方法。但是构造方法不能用来new实例，只能用来被子类调用。

4. 抽象类只能用来被继承。

5. 抽象方法必须被子类实现。
*/
/*
此程序输出结果：
        com.company.Dog@1540e19d
        com.company.Dog@677327b6
        com.company.Dog@14ae5a5
        com.company.Dog@7f31245a
        com.company.Dog@6d6f6e28
        com.company.Dog@135fbaa4
        com.company.Dog@45ee12a7
        com.company.Dog@330bedb4
        com.company.Dog@2503dbd3
        com.company.Dog@4b67cf4d
        ######
        com.company.Dog@7ea987ac
        com.company.Dog@7ea987ac*/
