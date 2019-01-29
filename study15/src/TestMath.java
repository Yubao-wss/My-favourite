/**
 * @Auther: WSS
 * @Date:
 * @Description  Math类
 *
 *               java.lang.Math提供了一系列静态方法用于科学计算;其方法的参数和返回值类型一般为double型。
 *               如果需要更加强大的数学运算能力，计算高等数学中的相关内容，可以使用apache commons下面的Math类库。
 *               Math类的常用方法：
 *               1. abs 绝对值
 *
 *               2. acos,asin,atan,cos,sin,tan 三角函数
 *
 *               3. sqrt 平方根
 *
 *               4. pow(double a, double b) a的 b次幂
 *
 *               5. max(double a, double b) 取大值
 *
 *               6. min(double a, double b) 取小值
 *
 *               7. ceil(double a) 大于a的最小整数
 *
 *               8. floor(double a) 小于a的最大整数
 *
 *               9. random() 返回 0.0 到 1.0 的随机数
 *
 *              10. long round(double a) double型的数据a转换为long型(四舍五入)
 *
 *              11. toDegrees(double angrad) 弧度->角度
 *
 *              12. toRadians(double angdeg) 角度->弧度
 */
public class TestMath {
    public static void main(String[] args) {
        //取整
        System.out.println(Math.ceil(5.1));//6.0
        System.out.println(Math.floor(5.1));//5.0
        System.out.println(Math.round(5.5));//6(四舍五入)
        System.out.println(Math.round(5.4));//5
        //绝对值、开方、a的b次幂
        System.out.println(Math.abs(-10));//10
        System.out.println(Math.sqrt(25));//5.0
        System.out.println(Math.pow(4,5));//1024 4的5次方
        //Math类中常用常量
        System.out.println(Math.PI);//3.141592653589793
        System.out.println(Math.E);//2.718281828459045
        //随机数
        System.out.println(Math.random());// [0,1)
    }
}
