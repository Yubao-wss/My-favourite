package com.company;

/*public class Private2 {
    public static void main(String[] args) {
        P1 p = new P1();
        System.out.println(p.getAge());
    }
}*/
class P1{
    private int age;
    private int id;
    private String name;
    private boolean man;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>0&&age<=130)
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }
}

/*
类的属性的处理:
一般使用private访问权限。
提供相应的get/set方法来访问相关属性，这些方法通常是public修饰的，以提供对属性的赋值与读取操作(注意：boolean变量的get方法是is开头!)。
一些只用于本类的辅助性方法可以用private修饰，希望其他类调用的方法用public修饰。
*/

class P2 {
    private String name;
    private int age;
    public P2() {

    }
    public P2(String name, int age) {
        this.name = name;
        // this.age = age;//构造方法中不能直接赋值，应该调用setAge方法
        setAge(age);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        //在赋值之前先判断年龄是否合法
        if (age > 130 || age < 0) {
            this.age = 18;//不合法赋默认值18
        } else {
            this.age = age;//合法才能赋值给属性age
        }
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "P2 [name=" + name + ", age=" + age + "]";
    }
}

public class Private2 {
    public static void main(String[] args) {
        P2 p1 = new P2();
        //p1.name = "小红"; //编译错误
        //p1.age = -45;  //编译错误
        p1.setName("小红");
        p1.setAge(-45);
        System.out.println(p1);

        P2 p2 = new P2("小白", 300);
        System.out.println(p2);
    }
}