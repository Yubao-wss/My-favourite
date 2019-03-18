package www.wss;

import www.TestStaticImport;
import static www.TestStaticImport.*;// 静态导入

/**
 * @Author: WSS
 * @Date: 2019/3/17 9:11
 * @Description: 新特性(JDK1.5)
 *
 * 静态导入
 *
 */
public class StaticImport {
    //在此包外建了一个新类TestStaticImport，该类中所有方法均为静态方法，
    //于是按照最初的使用原则。首先导入TestStaticImport类，然后通过TestStaticImport类调用所有静态方法。
    public static void main(String[] args) {
        System.out.println(TestStaticImport.add(10,20));
        System.out.println(TestStaticImport.sub(30,10));
        /*
            30
            20
        */

        //从JDK1.5开始，如果类中方法全是static方法，则可以直接把这个类的方法导入进来，这样就好比像在主类中定义的方法那样，可以被主方法直接调用。
        System.out.println(add(10,20));
        System.out.println(sub(30,10));
        /*
            30
            20
        */
    }



}
