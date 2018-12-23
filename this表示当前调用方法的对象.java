public class Day1{
    public static void main(String[] args){
        Test a = new Test();
        System.out.println("[MAIN]"+a);
        a.print();
    }
}
class Test{
    public void print(){
        System.out.println("[PRINT]"+this);
    }
