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
 *              使用enum关键字定义的枚举类本质上就相当于一个Class定义的类，继承了java.lang.Enum父类。
 *
 *              1. 当你需要定义一组常量时，可以使用枚举类型。
 *
 *              2. 尽量不要使用枚举的高级特性，事实上高级特性都可以使用普通类来实现，没有必要引入枚举，增加程序的复杂性!
 *
 *              enum与Enum区别：enum是一个关键字，使用enum定义的枚举类本质上就相对于一个类继承了Enum这个抽象类而已。
 */
enum Season{
    SPRING,SUMMER,AUTUMN,WINTER
}

enum Week{
    星期一,星期二,星期三,星期四,星期五,星期六,星期日,
}

enum Color{
    RED("红色"),GREEN("绿色"),BLUE("蓝色");// 如果定义有很多内容，枚举对象必须写在第一行
    private String title;
    //构造方法私有化
    private Color(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
//枚举还可以实现接口，这样枚举中的每一个对象都变成了接口对象
interface IColor{
    public String getColor();
}

enum MyColor implements IColor{
    RED("红色"),GREEN("绿色"),BLUE("蓝色");// 如果定义有很多内容，枚举对象必须写在第一行
    private String title;
    //构造方法私有化
    private MyColor(String title){
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }

    @Override
    public String getColor() {
        return this.title;
    }
}
//枚举应用
/*
    枚举的最大特点是只有指定的几个对象可以使用。
    例如：定义一个表示性别的枚举类，只能有两个对象。
*/
enum Sex{
    MALE("♂"),FEMALE("♀");
    private String title;

    Sex(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
class Person{
    private String name;
    private int age;
    private Sex sex;

    public Person(String name, int age, Sex sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ",age=" + age +", sex=" + sex +"]" ;
    }
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

        System.out.println(Color.BLUE);// 结果：蓝色
        System.out.println(MyColor.GREEN);// 结果：绿色

        Person per = new Person("Van",27,Sex.MALE);
        System.out.println(per);// 结果： Person [name=Van,age=27, sex=♂]

        //另外需要注意的是，枚举本身还支持switch判断。
        switch (Sex.MALE){
            case MALE:
                System.out.println("man");
                break;
            case FEMALE:
                System.out.println("women");
                break;
        }
        //结果： man
    }
}


