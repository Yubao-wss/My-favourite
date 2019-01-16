public class Main {

    int id;
    String name;
    int age;
    Computer comp;
    void study(){
        System.out.println("我正在学习，使用的电脑是："+comp.brand);
    }
    public static void main(String[] args){
        Main me = new Main();
        me.id=1;
        me.age=20;
        Computer comp1 = new Computer();
            comp1.brand = "911";
        me.comp=comp1;
        me.study();
    }
}
class Computer{
    String brand;
}
