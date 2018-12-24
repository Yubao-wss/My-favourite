public class Day1{
    public static void main(String[] args){
        Person.setCountry("China");
        Person p1 = new Person("Van",15);
        Person p2 = new Person("Peter",20);
        p1.getPersonInfo();
        p2.getPersonInfo();
    }
}
class Person{
    private static String country;
    private String name;
    private int age;
    public Person(String name,int age){
        setName(name);
        setAge(age);       
    }
    public static void setCountry(String c){
        country = c;
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setAge(int i){
        if (i>0&&i<=200){
            age = i;
        }
        else{
            age = 0;
        }
    }
    public int getAge(){
        return age;
    }
    public void getPersonInfo(){
        System.out.println("name:"+this.name+",age:"+this.age+"country:"+this.country);
    }
}
