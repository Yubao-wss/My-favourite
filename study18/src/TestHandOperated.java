import com.sun.prism.Image;

/**
 * @Author: WSS
 * @Date:
 * @Description: 自定义异常
 *       1.在程序中，可能会遇到JDK提供的任何标准异常类都无法充分描述清楚我们想要表达的问题，这种情况下可以创建自己的异常类，即自定义异常类。
 *       2.自定义异常类只需从Exception类或者它的子类派生一个子类即可。
 *       3.自定义异常类如果继承Exception类，则为受检查异常，必须对其进行处理;如果不想处理，可以让自定义异常类继承运行时异常RuntimeException类。
 *       4.习惯上，自定义异常类应该包含2个构造器：一个是默认的构造器，另一个是带有详细信息的构造器。
 */
public class TestHandOperated {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(-1);
    }
}

class Person{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age<0){
            throw new IllegalAgeException("年龄不能为负数");
        }
        this.age = age;
    }
}

class IllegalAgeException extends RuntimeException{
    public IllegalAgeException(){
    }

    public IllegalAgeException(String msg){
        super(msg);
    }
}
//结果：Exception in thread "main" IllegalAgeException: 年龄不能为负数
//	at Person.setAge(TestHandOperated.java:28)
//	at TestHandOperated.main(TestHandOperated.java:15)