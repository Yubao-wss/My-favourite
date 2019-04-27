package com.wss;

/**
 * @Author: WSS
 * @Date: 2019/4/27 19:27
 * @Description: 分析堆栈轨迹元素 (P281)
 */
public class StackTraceTest {
    /**
     * 计算阶乘的方法
     * @param n
     * @return
     */
    public static int factorial(int n){
        System.out.println("factorial("+n+"):");

        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for(StackTraceElement f : frames){
            System.out.println(f);
            System.out.println(f.getFileName());
        }

        int r;
        if(n <= 1){
            r = 1;
        }else {
            r = n * factorial(n - 1);
        }
        System.out.println("return"+r);
        return r;
    }

    public static void main(String[] args) {
        factorial(3);
        /*
            结果：
            factorial(3):
            com.wss.StackTraceTest.factorial(StackTraceTest.java:17)
            com.wss.StackTraceTest.main(StackTraceTest.java:34)
            factorial(2):
            com.wss.StackTraceTest.factorial(StackTraceTest.java:17)
            com.wss.StackTraceTest.factorial(StackTraceTest.java:27)
            com.wss.StackTraceTest.main(StackTraceTest.java:34)
            factorial(1):
            com.wss.StackTraceTest.factorial(StackTraceTest.java:17)
            com.wss.StackTraceTest.factorial(StackTraceTest.java:27)
            com.wss.StackTraceTest.factorial(StackTraceTest.java:27)
            com.wss.StackTraceTest.main(StackTraceTest.java:34)
            return1
            return2
            return6
        */
    }

}
