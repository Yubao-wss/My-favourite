package com.company;
public class Super{
    public static void main(String[] args) {
        new childClass();
    }
}
class fatherClass{
    public fatherClass(){
        //super();  默认
        System.out.println("创建fatherclass");
    }
}
class childClass extends fatherClass{
    public childClass(){
        //super();  默认
        System.out.println("创建childclass");
    }
}
/*属性/方法查找顺序：(比如：查找变量h)
        1. 查找当前类中有没有属性h

        2. 依次上溯每个父类，查看每个父类中是否有h，直到Object

        3. 如果没找到，则出现编译错误。

        4. 上面步骤，只要找到h变量，则这个过程终止。*/

/*构造方法调用顺序：

        构造方法第一句总是：super(…)来调用父类对应的构造方法。所以，流程就是：先向上追溯到Object，然后再依次向下执行类的初始化块和构造方法，直到当前子类为止。

        注：静态初始化块调用顺序，与构造方法调用顺序一样，不再重复。*/
