class Father{
    private String name = "zhang jun";
    private int age;
    class Child{
        public void introFather(){
            System.out.println(Father.this.name);
        }
    }
}

public class Day1{
    public static void main(String[] args){
       Father.Child a = new Father().new Child();
       a.introFather();
    }
}
