package www.wss;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @Author: WSS
 * @Date: 2019/3/15 20:44
 * @Description: 新特性(JDK1.5)
 *
 *  可变参数
 *
 */
public class VariableParameters {

    //现在假设说有这样的要求：要求设计一个方法，用于计算任意参数的整数的相加结果。
    //这个需求在早期只能通过数组的方式来实现。
    public static int addOld(int[] data) {
        int result = 0 ;
        for (int i = 0; i < data.length; i++) {
            result += data[i] ;
        }
        return result ;
    }

    //从JDK1.5之后追加了可变参的概念，这个时候方法的定义格式:
    public static int addNew(int ... data){//本质上表示的还是数组
        int result = 0;
        for(int i = 0;i < data.length;i++){
            result += data[i];
        }
        return result;
    }

    //！注意点：如果要传递多类参数，可变参数一定放在最后，并且只能设置一个可变参数
    public static int addPlus(String msg,int ... data){
        int result = 0 ;
        for (int i = 0; i < data.length; i++) {
            result += data[i] ;
        }
        return result ;
    }

    public static void main(String[] args) {
        System.out.println(addOld(new int[]{1}));
        System.out.println(addOld(new int[]{1,2,3}));
        System.out.println(addOld(new int[]{1,2,3,4,5,6,7,8}));
        //结果：
        /*
            1
            6
            36
        */

        System.out.println(addNew(1,2,3,4));//新方法中可以随意传递内容，随意个数
        System.out.println(addNew(new int[]{1,2,3,4}));//也可以以数组方式传参
        //结果：
        /*
            10
            10
        */

        System.out.println(addPlus("ksd",1,2,3));
    }
}
