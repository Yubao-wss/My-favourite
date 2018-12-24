public class Day1{
    public static void main(String[] args){
       Test t = new Test("WSS");
    }
}
class Test{
    public Test(){
        System.out.println("Hello Constructor");
    }
    public Test(String a){
        System.out.println(a+" Hello Constructor");
    }
}
