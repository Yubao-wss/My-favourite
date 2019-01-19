package com.company;

public class Test2 {
    public static void main(String[] args) {
        //静态初始化
        int[] a={2,4,5,6};
        Man[] b={
                new Man(1,1),
                new Man(2,2)
                };

        //默认初始化
        int[] c = new int[3];//int型默认值为0

        //动态初始化
        int[] a1=new int[2];//动态初始化数组，先分配空间
        a1[0]=1;//给数组元素赋值
        a1[1]=2;
    }
}
