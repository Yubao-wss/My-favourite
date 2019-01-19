package com.company;

public class Test1 {
    public static void main(String[] args) {
        Man[] mans;//声明引用类型数据
        mans = new Man[10];//给引用类型数组分配空间

        Man m1=new Man(1,1);
        Man m2=new Man(2,2);

        mans[0]=m1;
        mans[1]=m2;
        System.out.println(mans[1].getAge());
    }
}
class Man{
    private int age;
    private int id;
    public Man(int id,int age){
        super();
        this.age=age;
        this.id=id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
