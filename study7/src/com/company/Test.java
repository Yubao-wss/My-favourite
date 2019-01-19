package com.company;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        /*Vehicle v1=new Vehicle();
        Vehicle v2=new Horse();
        v1.run();
        v1.stop();
        v2.run();
        v2.stop();*/
        /*1*/



        /*Test t=new Test();
        System.out.println(t.toString());*/
        /*2.重写toString方法*/



        /*User u1 = new User(1000,"wss");
        User u2 = new User(1000,"ABC");
        System.out.println(u1==u2);
        System.out.println(u1.equals(u2));*/
        /*3.equals的重写*/




    }
    public String toString(){
        return "测试Object对象";
    }
}

class Vehicle{
    public void run(){
        System.out.println("跑");
    }
    public void stop(){
        System.out.println("停止不动");
    }
    public Person who(){
        return new Person();
    }
}

class Horse extends Vehicle{
    public void run(){
        System.out.println("四蹄翻飞");//方法的重写
    }
    public Person who(){
        return new Student();//返回值类型，子类小于父类
        //turn new Object();//错误
    }
}

/*
重写的要求
1.“==”：方法名、形参列表相同。
2.“<=”：返回值类型和声明异常类型，子类小于等于父类。
3.“>=”：访问权限，子类大于等于父类。*/

class User{
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
//重写equals方法