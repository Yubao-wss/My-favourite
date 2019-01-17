/*public class Main {

    public static void main(String[] args){
        Point p = new Point(3.0,4.0);
        Point origin = new Point(0.0,0.0);
        System.out.println(p.getDistance(origin));
    }
}
class Point{
    double x,y;
    public Point(double _x,double _y){
        x = _x;
        y = _y;
    }
    public double getDistance(Point p){
        return Math.sqrt((x-p.x)*(x-p.x)+(y-p.y)*(y-p.y));
    }
}*/
/*1*/




/*
public class Main{
    public static void main(String[] args) {
        User u1 = new User();
        User U2 = new User(101,"wss");
        User u3 = new User(101,"wss","1");
    }
}
class User{
    int id;
    String name;
    String pwd;
    public User(){

    }
    public User(int id,String name){
        this.id = id;
        this.name = name;
    }
    public User(int id,String name,String pwd){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
}*/
/*2.构造方法的重载*/

/*创建一个对象分为如下四步：
1.分配对象空间，并将对象成员变量初始化为0或空
2.执行属性值的显式初始化
3.执行构造方法
4.返回对象的地址给相关的变量*/

/*this的本质就是“创建好的对象的地址”，由于在构造方法调用前，对象已经创建。因此，在构造方法中也可以使用this代表“当前对象”*/



/*
public class Main{
    public static void main(String[] args) {
        Test t = new Test(1,2,3);
        t.play();
    }
}
class Test{
    int a,b,c;
    Test(int a,int b){
        this.a = a; //表示当前对象
        this.b = b;
    }
    Test(int a,int b,int c){
        this(a,b); //调用本类构造方法，必须位于第一行
        this.c = c;
    }
    void sing(){
        System.out.println("456");
    }
    void play(){
        this.sing();//调用本类中的普通方法
        System.out.println("123");
    }
}*/
/*3.this的用法*/




/*public class Main {
    int id;
    String name;
    String pwd;

    static String company = "wow";


    public Main(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void login() {
        printCompany();
        System.out.println(company);//普通方法可以调用静态变量
        System.out.println("登录：" + name);
    }

    public static void printCompany() {
//        login();//调用非静态成员，编译就会报错
        System.out.println(company);
    }

    public static void main(String[] args) {
        Main u = new Main(1, "wss");
        Main.printCompany();
        Main.company = "lol";
        Main.printCompany();
    }
}*/
/*4.static关键字*/
/*this也不可以调用静态变量或方法*/



/*public class Main{
    int id;
    String name;
    String pwd;
    static String company;
    static {
        System.out.println("执行类的初始化工作");
        company = "my company";
        printCompany();
    }
    public static void printCompany(){
        System.out.println(company);
    }

    public static void main(String[] args) {
        Main me = null;
    }
}*/
/*5.静态块即使在没有建立对象时也会在程序执行时先运行一下*/



/*public class Main{
    int id;
    String name;
    String pwd;
    public Main(int id,String name){
        this.id=id;
        this.name=name;
    }
    public void testTransfer01(Main m){
        m.name="wss02";
    }
    public void testTransfer02(Main m){
        m=new Main(3,"wss03");
    }

    public static void main(String[] args) {
        Main m1 = new Main(1,"wss01");
        m1.testTransfer01(m1);
        System.out.println(m1.name);
        m1.testTransfer02(m1);
        System.out.println(m1.name);
    }
}*/
/*6.方法的传值机制，要理解内存机制*/




