public class Day1{
    public static void main(String[] args){
        Person van = new Person("van",40);
        System.out.println(van.getPersonInfo());
    }
}
class Person{
    public String name;
    public int age;
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String getPersonInfo(){
        return "name: "+this.name+",age:"+this.age;
    }
}
