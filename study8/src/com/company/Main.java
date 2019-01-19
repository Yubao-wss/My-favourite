package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] s = null;//声明数组
        s = new int[10];//给数组分配空间
        for (int i = 0;i<s.length;i++){
            s[i]=2*i+1;
            System.out.println(s[i]);
        }
    }
}
/*
1. 声明的时候并没有实例化任何对象，只有在实例化数组对象时，JVM才分配空间，这时才与长度有关。
2. 声明一个数组的时候并没有数组真正被创建。
3. 构造一个数组，必须指定长度。
*/

