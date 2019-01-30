/**
 * @Author: WSS
 * @Date:
 * @Description 测试枚举
 *              JDK1.5引入了枚举类型。枚举类型的定义包括枚举声明和枚举体。格式如下：
 *              enum  枚举名 {
 *                    枚举体（常量列表）
 *              }
 *
 *              所有的枚举类型隐性地继承自 java.lang.Enum。枚举实质上还是类!而每个被枚举的成员实质就是一个枚举类型的实例，
 *              他们默认都是public static final修饰的。可以直接通过枚举类型名使用它们。
 *
 *              1. 当你需要定义一组常量时，可以使用枚举类型。
 *
 *              2. 尽量不要使用枚举的高级特性，事实上高级特性都可以使用普通类来实现，没有必要引入枚举，增加程序的复杂性!
 */
enum Season{
    SPRING,SUMMER,AUTUMN,WINTER
}

enum Week{
    星期一,星期二,星期三,星期四,星期五,星期六,星期日,
}
public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);//SPRING
        //创建枚举对象
        Season a = Season.AUTUMN;
        //switch语句中使用枚举
        switch (a){
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
        //枚举遍历
        for (Week k:Week.values()){
            System.out.println(k);
        }
    }
}

