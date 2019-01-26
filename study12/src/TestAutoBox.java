/**
 * @Auther: WSS
 * @Date:
 * @Description 自动装箱：基本类型的数据处于需要对象的环境中时，会自动转为“对象”。
 *              自动拆箱：每当需要一个值时，对象会自动转成基本数据类型，
 *                      没必要再去显式调用intValue()、doubleValue()等转型方法。
 */
public class TestAutoBox {
    public static void main(String[] args) {
        Integer a = 123; //自动装箱
        //编译器执行了(修改成）：Integer a = Integer.valueOf(123);
        int b = a;//自动拆箱
        //编译器执行了(修改成）int b = a.intValue();

        Integer c = null;
        //int d = c;//自动拆箱，调用c.intValue()
        //结果：Exception in thread "main" java.lang.NullPointerException
        //	at TestAutoBox.main(TestAutoBox.java:14)


    }
}
