package com.company;

import javax.jws.soap.SOAPBinding;

public class Main {

    public static void main(String[] args) {
        Student s1 = new Student("wss",20,"java");
        s1.rest();
        s1.study();
        Student s2 = new Student("zmy",19,"doctor");

        System.out.println(s1 instanceof Student);
        System.out.println(s1 instanceof Person);
        System.out.println(s1 instanceof Object);
        System.out.println(new Person() instanceof Student);
        //instanceof用于判断某对象是否属于某一类
    }
}

class Person{
    String name;
    int age;
    public void rest(){
        System.out.println("休息一会");
    }
}

class Student extends Person{
    String major;
    public void study(){
        System.out.println("学习两小时");
    }
    public Student(){ }
    public Student(String name,int age,String major){
        //天然拥有父类属性
        this.name=name;
        this.age=age;
        this.major=major;
    }
}