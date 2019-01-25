package com.study10;

import javax.jws.soap.SOAPBinding;

/**
 * @Auther: WSS
 * @Date:
 * @Description 测试字符串的用法
 */
public class TestString {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = new String("abc");
        String str3 = "a"+"b"+"c";
        System.out.println(str+str2+str3);
        System.out.println("##############");
        String str4 = "WSS";
        String str5 = "WSS";
        String str6 = new String("WSS");

        System.out.println(str4 == str5);//true ==比较对象
        System.out.println(str4 == str6);//false 说明不是同一对象

        //比较字符串，一般使用equals
        System.out.println(str4.equals(str5));

        System.out.println("#################");
        //String常用方法
        String s1 = "core Java";
        String s2 = "Core Java";
        System.out.println(s1.charAt(3));//提取下标为3的字符
        System.out.println(s2.length());//字符串的长度
        System.out.println(s1.equals(s2));//比较两个字符串是否相等
        System.out.println(s1.equalsIgnoreCase(s2));//比较两个字符串（忽略大小写）
        System.out.println(s1.indexOf("Java"));//字符串s1中是否包含Java
        System.out.println(s1.indexOf("apple"));//字符串s1中是否包含apple
        String s = s1.replace(' ', '&');//将s1中的空格替换成&
        System.out.println("result is :" + s);

//        String s = "";
//        String s1 = "How are you?";
//        System.out.println(s1.startsWith("How"));//是否以How开头
//        System.out.println(s1.endsWith("you"));//是否以you结尾
//        s = s1.substring(4);//提取子字符串：从下标为4的开始到字符串结尾为止
//        System.out.println(s);
//        s = s1.substring(4, 7);//提取子字符串：下标[4, 7) 不包括7
//        System.out.println(s);
//        s = s1.toLowerCase();//转小写
//        System.out.println(s);
//        s = s1.toUpperCase();//转大写
//        System.out.println(s);
//        String s2 = "  How old are you!! ";
//        s = s2.trim();//去除字符串首尾的空格。注意：中间的空格不能去除
//        System.out.println(s);
//        System.out.println(s2);//因为String是不可变字符串，所以s2不变
    }

}
