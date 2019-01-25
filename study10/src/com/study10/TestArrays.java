package com.study10;

import java.util.Arrays;

/**
 * @Auther: WSS
 * @Date:
 * @Description 测试Arrays工具类的使用
 */
public class TestArrays {
    public static void main(String[] args) {
        int[] a = {30,20,10};
        System.out.println(a);
        //打印数组内容
        System.out.println(Arrays.toString(a));
        //数组的排序
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
        //二分查找
        System.out.println(Arrays.binarySearch(a,30));

        //输出结果
        // [I@1540e19d
        //[30, 20, 10]
        //[10, 20, 30]
        //2
    }

}
