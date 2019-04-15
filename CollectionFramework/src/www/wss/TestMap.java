package www.wss;

import java.util.*;

/**
 * @Author: WSS
 * @Date: 2019/4/11 23:12
 * @Description: Map集合
 *
 * 1.Collection集合的特点是每次进行单个对象的保存，如果现在要进行一对对象(偶对象)的保存就只能使用Map集合来完成，
 * 即Map集合中会一次性保存两个对象，且这两个对象的关系:key=value结构。这种结构最大的特点是可以通过key找到对应的value内容。
 *
 * 在Map接口中有如下常用方法
 *      1.public V put(K key, V value);           向Map中追加数据
 *      2.public V get(Object key);               根据key取得对应的value，如果没有返回null
 *      3.public Set<K> keySet();                 取得所有key信息、key不能重复
 *      4.public Collection<V> values();          取得所有value信息，可以重复
 *      5.public Set<Map,Entry<K,V>> entrySet();  将Map集合变为Set集合
 *
 * Map本身是一个接口，要使用Map需要通过子类进行对象实例化。
 * Map接口的常用子类有如下四个： HashMap、Hashtable、TreeMap、ConcurrentHashMap。
 *
 * 2.HashMap子类
 *   HashMap是使用Map集合中最为常用的子类。
 *
 * 3.Hashtable子类
 *   JDK1.0提供有三大主要类：Vector、Enumeration、Hashtable。
 *   Hashtable是最早实现这种二元偶对象数据结构，后期的设计也让其与实现了Map接口。
 *
 *   HashMap与Hashtable的区别
 *      1.HashMap在JDK1.2推出，Hashtable在JDK1.0推出
 *      2.HashMap异步处理，性能高，非线程安全，Hashtable同步处理，性能较低，线程安全
 *      3.HashMap允许存放null（只能有一个），Hashtable的key和value都不能为空，否则出现NullPointerException
 *
 *  !以后使用的时候多考虑HashMap
 *
 * 4.Map集合使用Iterator输出
 *  Map接口与Collection接口不同，Collection接口有iterator()方法可以很方便的取得Iterator对象来输出，而Map接口本身并没有此方法。
 *  在Map接口里面有一个重要的方法，将Map集合转为Set集合:
 *     public Set<Map.Entry<K, V>> entrySet();
 *
 * 5.关于Map中key的说明
 *  使用Map集合的时候使用的都是系统类作为key(Integer,String等)。实际上用户也可采用自定义类作为key。
 *  这个时候一定要记得覆写Object类的hashCode()与equals()方法。
 *
 * 6.TreeMap子类
 *  TreeMap是一个可以排序的Map子类，它是按照Key的内容排序的。
 *
 * Map集合小结：
 *      1. Collection保存数据的目的一般用于输出(Iterator)，Map保存数据的目的是为了根据key查找，找不到返回null。
 *      2. Map使用Iterator输出(Map.Entry的作用)
 *      3. HashMap数据结构一定要理解(链表与红黑树)、HashMap与Hashtable区别
 *
 */
public class TestMap {
    public static void main(String[] args) {
        /*范例：HashMap基本操作*/
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        // 设置一个重复的key
        map.put(1,"Hello");
        map.put(3,"my");
        map.put(2,"friends");
        System.out.println(map);
        /*
            结果：
            {1=Hello, 2=friends, 3=my}
        */

        // 根据key取得value
        System.out.println(map.get(2));
        System.out.println(map.get(100));
        /*
            结果：
            friends
            null -----> 查找不到的话就返回null
        */



        /*范例：取得Map中所有key信息*/
        // 用一个Set对象接收所有的key信息
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        /*
            结果：
            1
            2
            3
        */



        /*范例：使用Hashtable*/
        Map<Integer,String> map1 = new Hashtable<>();
        map1.put(1,"you");
        // 设置重复key
        map1.put(1,"You");
        map1.put(3,"are");
        map1.put(2,"beautiful");
        System.out.println(map1);
        /*
            结果：
            {3=beautiful, 2=are, 1=You}
        */



        /*范例：通过lterator输出Map集合*/
        // 1.将Map集合转为Set集合
        Set<Map.Entry<Integer,String>> set1 = map.entrySet();
        // 2.获取Iterator对象
        Iterator<Map.Entry<Integer,String>> iterator1 = set1.iterator();
        // 3.输出
        while (iterator1.hasNext()){
            // 4.取出每一个Map.Entry对象
            Map.Entry<Integer,String> entry = iterator1.next();
            // 5.取得key和value
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
        /*
            结果：
            1 = Hello
            2 = friends
            3 = my
        */

        /*测试用自定义类作为key*/
        Map<PersonTestInMap,String> map2 = new HashMap<>();
        map2.put(new PersonTestInMap(18,"Jack"),"Jk");
        System.out.println(map2.get(new PersonTestInMap(18,"Jack")));
        /*
            结果：
            Jk
        */
        /*
            实际开发来讲，我们一般都是采用系统类(String，Integer等)作为Key值，
            这些系统类都帮助用户覆写好了hashCode()与equals()方法。
        */



        /*范例：TreeMap的使用*/
        Map<Integer,String> map3 = new TreeMap<>();
        map3.put(8,"A");
        map3.put(3,"B");
        map3.put(5,"C");
        System.out.println(map3);
        /*
            结果：
            {3=B, 5=C, 8=A}

            这个时候的排序处理依然按照的是Comparable接口完成的。
        */
    }
}
/*范例：观察自定义类作为Key，系统类作为Value的情况(未覆写)*/
class PersonTestInMap{
    private Integer age;
    private String name;

    public PersonTestInMap(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonTestInMap{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonTestInMap that = (PersonTestInMap) o;
        return Objects.equals(age, that.age) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(age, name);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}