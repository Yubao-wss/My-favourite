import cn.wss.oo.*;

import static java.lang.Math.*;//导入类中静态属性

public class Main {

    public static void main(String[] args) {
        User u1=new User();
//        cn.wss.oo.User u1 = new cn.wss.oo.User();
//也可像上面这样，同时这样解决了不同包中同名类的问题,例子如下:
        java.util.Date date1 = new java.util.Date();
        java.sql.Date date2 = new java.sql.Date(12);

        System.out.println(Math.PI);
        System.out.println(PI); //可以直接写PI
    }
}
