public class Day1{
    public static void main(String[] args){
        Person v = new Person();
        v.setName("Van");
        v.setAge(40);
        String a = v.getName();
        int b = v.getAge();
        System.out.println(a);
        System.out.println(b);
        v.getPersonInfo();
    }
}
class Person{
    private String name;
    private int age;
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
        System.out.println("name:"+name+",age:"+age);
    }
}
