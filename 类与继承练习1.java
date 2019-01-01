abstract class Role {
    private String name;
    private int age;
    private String sex;

    public abstract void play();

    public Role(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Role(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

class Employee extends Role {
    private double salary;
    private static String ID;
    public Employee(String name,int age,double salary) {
        super(name, age);
        this.salary = salary;
    }
    public Employee(String name,int age,String sex,double salary) {
        super(name,age,sex);
        this.salary = salary;
    }
    public void play() {
        System.out.println(this.getName()+"在"+this.getAge()+"峡谷之巅");
    }
    public final void sing() {
        System.out.println(this.getName()+"寂寞的唱歌");
    }
}
class Manager extends Employee {

    public static final String vehicle = "Benz";
    public Manager(String name,int age,double salary) {
        super(name, age,salary);
    }
}

public class Day9 {
    public static void main(String[] args) {
        Role role = new Employee("zhangsan", 18, "male",1000);
        role.play();
        Manager manager = new Manager("lisi", 20, 10000000.1);
        manager.play();
        manager.sing();
        System.out.println(Manager.vehicle);
    }
    
}
