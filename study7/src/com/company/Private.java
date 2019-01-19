package com.company;

public class Private {
    public static void main(String[] args) {

    }
}
class Human{
    private int age;
    String name;
}
class Boy extends Human{
    public Boy(){
//        System.out.println(age);//不能调用
        System.out.println(name);//可以
    }
}

/*访问权限修饰符
修饰符        同一个类      同一个包       子类        所有类
private         *
default         *           *
protected       *           *           *
public          *           *           *           *
*/

/*
private 表示私有，只有自己类能访问
default表示没有修饰符修饰，只有同一个包的类能访问
protected表示可以被同一个包的类以及其他包中的子类访问
public表示可以被该项目的所有包中的所有类访问
*/
