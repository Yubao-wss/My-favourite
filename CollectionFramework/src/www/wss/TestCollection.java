package www.wss;

import java.util.*;

/**
 * @Author: WSS
 * @Date: 2019/4/9 16:34
 * @Description: Java类集
 *
 * 1.类集的引出
 *      类集实际上就属于动态对象数组，在实际开发之中，数组的使用出现的几率并不高，因为数组本身有一个最大的缺陷:
 *      数组长度是固定的。由于此问题的存在，从JDK1.2开始，Java为了解决这种数组长度问题，提供了动态的对象数组实现框架--Java类集框架。
 *      Java集合类框架实际上就是java针对于数据结构的一种实现。而在数据结构之中，最为基础的就是链表。
 *
 * 2.Collection接口
 *      在Java的类集里面(java.util包)提供了两个最为核心的接口:Collection、Map接口。
 *      其中Collection接口的操作形式与之前编写链表的操作形式类似，每一次进行数据操作的时候只能够对单个对象进行处理。
 *
 *      Collection是单个集合保存的最大父接口。
 *      Collection接口的定义如下:public interface Collection<E> extends Iterable<E>
 *
 *      从JDK1.5开始发现Collection接口上追加有泛型应用，这样的直接好处就是可以避免ClassCastException，
 *      里面的所有数据的保存类型应该是相同的。在JDK1.5之前Iterable接口中的iterator()方法是直接在Collection接口中定义的。
 *      此接口的常用方法有如下几个:
 *
 *      public boolean add(E e) 向集合中添加数据
 *      public boolean addAll(Collection <? extends E> c) 向集合中添加一组数据
 *      public void clear() 清空集合数据
 *      public boolean contains(Object o) 查找数据是否存在，需要使用equals()方法
 *      public boolean remove(Object o)  删除数据，需要equals()方法
 *      public int size() 取得集合长度
 *      public Object[] toArray()  将集合变为对象数组返回
 *      public lterator<E> iterator()  取得 lterator 接口对象，用于集合输出
 *
 *      在开发之中如果按照使用频率来讲:add()、iterator()方法用到的最多。需要说明的一点是，我们很少会直接使用Collection接口，
 *      Collection接口只是一个存储数据的标准，并不能区分存储类型。例如：要存放的数据需要区分重复与不重复。
 *      在实际开发之中，往往会考虑使用Collection接口的子接口:List(允许数据重复)、Set(不允许数据重复)。
 *
 *      Collection接口中有两个重要方法:add()、iterator()。子接口都有这两个方法。
 *
 * 2.List接口
 *      在实际开发之中，List接口的使用频率可以达到Collection系列的80%。在进行集合处理的时候，优先考虑List接口。
 *      首先来观察List接口中提供的方法,在这个接口中有两个重要的扩充方法 :
 *      1.public E get(int index)  根据索引取得保存数据
 *      2.public E set(int index,E element)  修改数据
 *      List子接口与Collection接口相比最大的特点在于其有一个get()方法，可以根据索引取得内容。
 *      由于List本身还是接口，要想取得接口的实例化对象，就必须有子类，在List接口下有三个常用子类：ArrayList、Vector、LinkedList。
 *
 * 3.旧的子类Vector（使用较少）
 *      Vector是从JDK1.0提出的，而ArrayList是从JDK1.2提出的
 *      ArrayList与Vector区别：
 *          1. 历史时间: ArrayList是从JDK1.2提供的，而Vector是从JDK1.0就提供了。
 *          2. 处理形式：ArrayList是异步处理，性能更高；Vector是同步处理，性能较低。
 *          3. 数据安全：ArrayList是非线程安全；Vector是线程安全。
 *          4. 输出形式：ArrayList支持Iterator、ListIterator、foreach；Vector支持Iterator、ListIterator、foreach、Enumeration。
 *
 *      在以后使用的时候优先考虑ArrayList，因为其性能更高，实际开发时很多时候也是每个线程拥有自己独立的集合资源。
 *      如果需要考虑同步也可以使用concurrent包提供的工具将ArrayList变为线程安全的集合。
 *
 * 4.LinkedList子类
 *      ArrayList与LinkedList区别
 *          1. 观察ArrayList源码，可以发现ArrayList里面存放的是一个数组，如果实例化此类对象时传入了数组大小，
 *             则里面保存的数组就会开辟一个定长的数组，但是后面再进行数据保存的时候发现数组个数不够了会进行数组动态扩充。
 *             所以在实际开发之中，使用ArrayList最好的做法就是设置初始化大小。
 *          2. LinkedList：是一个纯粹的链表实现，与之前编写的链表程序的实现基本一样（性能高）。
 *
 *          总结：ArrayList封装的是数组；LinkedList封装的是链表。ArrayList时间复杂度为1，而LinkedList的复杂度为n。
 *
 */
public class TestCollection {
    /*范例：List基本处理*/
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        System.out.println(list.size()+" "+list.isEmpty());
        /*
            结果：
            0 true
        */
        // 泛型声明String，此时集合里只保存String类型
        list.add("Hello");
        // 添加一个重复数据
        list.add("Hello");
        list.add("World");
        System.out.println(list);
        /*
            结果：
            [Hello, Hello, World]
        */
        //通过上述代码我们可以发现，List允许保存重复数据。
        System.out.println(list.size()+" "+list.isEmpty());
        System.out.println(list.remove("Hello"));
        System.out.println(list.contains("ABC"));
        System.out.println(list.remove("World"));
        System.out.println(list);
        /*
            结果：
            3 false
            true
            false
            true
            [Hello]
        */

        /*List的get()操作*/
        list.add("Every");
        list.add("One");
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i)+" ");
        }
        /*
            结果：
            Hello Every One
        */

        System.out.println();
        System.out.println("------------------");
        /*范例：向集合保存简单Java类对象*/
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Java",10));
        personList.add(new Person("C++",15));
        personList.add(new Person("PHP",18));
        // 集合类中contains()、remove()方法需要equals()支持
        System.out.println(personList.remove(new Person("Java",10)));
        System.out.println(personList.contains(new Person("PHP",18)));
        /*
            结果：
            true
            true
        */
        for (Person p : personList){
            System.out.println(p);
        }
        /*
            结果:
            Person{name='C++', age=15}
            Person{name='PHP', age=18}
        */



        /*范例：使用Vector*/
        List<String> list1 = new Vector<>();
        list1.add("hello");
        list1.add("every");
        list1.add("body");
        System.out.println(list1);
        /*
            结果：
            [hello, every, body]
        */
        list1.remove("hello");
        System.out.println(list1);
        /*
            结果：
            [every, body]
        */


        /*范例：使用LinkedList*/
        List<String> list2 = new LinkedList<>();
        list2.add("Deep");
        list2.add("Dark");
        list2.add("Fantasy");
        System.out.println(list2);
        /*
            结果：
            [Deep, Dark, Fantasy]
        */
        list2.remove("Fantasy");
        System.out.println(list2);
        /*
            结果：
            [Deep, Dark]
        */
    }
}

/*一个简单Java类*/
class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}