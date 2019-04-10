package www.wss;

import java.util.*;

/**
 * @Author: WSS
 * @Date: 2019/4/9 22:33
 * @Description: Set集合接口
 *
 * Set接口与List接口最大的不同在于Set接口中的内容是不允许重复的。同时需要注意的是，
 * Set接口并没有对Collection接口进行扩充，而List对Collection进行了扩充。因此，在Set接口中没有get()方法。
 *
 * 1.Set接口常用子类
 *      在Set子接口中有两个常用子类：HashSet(无序存储)、TreeSet(有序存储)
 *
 * 2.TreeSet排序分析
 *      既然TreeSet子类可以进行排序，所以我们可以利用TreeSet实现数据的排列处理操作。
 *      此时要想进行排序实际上是针对于对象数组进行的排序处理，而如果要进行对象数组的排序，
 *      对象所在的类一定要实现Comparable接口并且覆写compareTo()方法，只有通过此方法才能知道大小关系。
 *      需要提醒的是如果使用Comparable接口进行大小关系匹配，所有属性必须全部进行比较操作。
 *
 * 3.Comparable接口与Comparator接口
 *    Comparable(内部排序接口)
 *      Comparable 是排序接口，若一个类实现了Comparable接口，就意味着“该类支持排序”。 即然实现Comparable接口的类支持排序，
 *      假设现在存在“实现Comparable接口的类的对象的List列表(或数组)”，则该List列表(或数组)可以通过 Collections.sort（或Arrays.sort）进行排序。
 *      此外，“实现Comparable接口的类的对象”可以用作“有序映射(如TreeMap)”中的键或“有序集合(TreeSet)”中的元素，而不需要指定比较器。
 *
 *      Comparable 定义，Comparable 接口仅仅只包括一个函数，它的定义如下：
 *      public interface Comparable<T> {
 *           public int compareTo(T o);
 *      }
 *
 *      关于返回值:
 *      可以看出compareTo方法返回一个int值，该值有三种返回值:
 *          1. 返回负数:表示当前对象小于比较对象
 *          2. 返回0:表示当前对象等于目标对象
 *          3. 返回正数:表示当前对象大于目标对象
 *
 *   Comparator(外部排序接口)
 *      Comparator 是比较器接口,我们若需要控制某个类的次序，而该类本身不支持排序(即没有实现Comparable接口)；
 *      那么，我们可以建立一个“该类的比较器”来进行排序。这个“比较器”只需要实现Comparator接口即可。
 *      也就是说，我们可以通过“实现Comparator类来新建一个比较器”，然后通过该比较器对类进行排序。
 *
 *      Comparator 定义,Comparator 接口仅仅只包括两个函数，它的定义如下：
 *      public interface Comparator<T> {
 *          int compare(T o1, T o2);
 *          boolean equals(Object obj);
 *      }
 *      int compare(T o1, T o2) 是“比较o1和o2的大小”。返回“负数”，意味着“o1比o2小”；返回“零”，意味着“o1等于o2”；返回“正数”，意味着“o1大于o2”。
 *
 *   Comparator 和 Comparable 比较
 *      Comparable是排序接口；若一个类实现了Comparable接口，就意味着“该类支持排序”。
 *      而Comparator是比较器,我们若需要控制某个类的次序，可以建立一个“该类的比较器”来进行排序。
 *
 *      我们不难发现：Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。
 *
 * 4.重复元素判断（hashCode与equals方法）
 *      在使用TreeSet子类进行数据保存的时候，重复元素的判断依靠的ComParable接口完成的。但是这并不是全部Set接口判断重复元素的方式，
 *      因为如果使用的是HashSet子类，由于其跟Comparable没有任何关系，所以它判断重复元素的方式依靠的是Object类中的两个方法：
 *          1. hash码： public native int hashCode();
 *          2. 对象比较：public boolean equals(Object obj);
 *
 *      equals()的作用是用来判断两个对象是否相等，在Object里面的定义是：
 *          public boolean equals(Object obj) {
 *              return (this == obj);
 *          }
 *
 *          这说明在我们实现自己的equals方法之前，equals等价于==,而==运算符是判断两个对象是不是同一个对象，
 *          即他们的地址是否相等。而覆写equals更多的是追求两个对象在逻辑上的相等，你可以说是值相等，也可说是内容相等。
 *
 *      覆写equals的准则
 *          自反性：对于任何非空引用值 x，x.equals(x) 都应返回 true。
 *          对称性：对于任何非空引用值 x 和 y，当且仅当 y.equals(x) 返回 true 时，x.equals(y) 才应返回 true。
 *          传递性：对于任何非空引用值 x、y 和 z，如果 x.equals(y) 返回 true， 并且 y.equals(z) 返回 true，那么 x.equals(z)应返回 true。
 *          一致性：对于任何非空引用值 x 和 y，多次调用 x.equals(y) 始终返回 true 或始终返回 false， 前提是对象上 equals比较中所用的信息没有被修改。
 *          非空性：对于任何非空引用值 x，x.equals(null) 都应返回 false。
 *
 *          hashCode用于返回对象的hash值，主要用于查找的快捷性，因为hashCode也是在Object对象中就有的，
 *          所以所有Java对象都有hashCode，在Hashtable和HashMap这一类的散列结构中，都是通过hashCode来查找在散列表中的位置的。
 *
 *          在Java中进行对象比较的操作有两步：第一步要通过一个对象的唯一编码找到一个对象的信息，当编码匹配之后再调用equals()方法进行内容的比较。
 *
 *          如果两个对象equals相等，那么它们的hashCode必然相等；但是hashCode相等，equals不一定相等。（hash碰撞）
 *          对象判断必须两个方法equals()、hashCode()返回值都相同才判断为相同。
 *
 *        建议：
 *          1. 保存自定义对象的时候使用List接口；
 *          2. 保存系统类信息的时候使用Set接口(避免重复)。
 *
 */
public class TestSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Hello");
        set.add("World");
        //重复元素
        set.add("Hello");
        set.add("Java");
        System.out.println(set);
        /*
            结果：
            [Java, Hello, World]
        */


        /*范例：使用TreeSet*/
        Set<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.add(1);
        set1.add(2);
        set1.add(5);
        set1.add(4);
        System.out.println(set1);
        /*
            结果：
            [1, 2, 4, 5]
            帮你排序了~
        */


        /*TreeSet排序分析*/
        Set<NewPerson> set2 = new TreeSet<>();
        set2.add(new NewPerson("Jack",20));
        set2.add(new NewPerson("Jack",20));
        set2.add(new NewPerson("Alice",16));
        set2.add(new NewPerson("Tom",12));
        System.out.println(set2);
        /*
            结果：
            [NewPerson{name='Tom', age=12}, NewPerson{name='Alice', age=16}, NewPerson{name='Jack', age=20}]
            是按年龄排序后的结果
        */
        /*
            在实际使用之中，使用TreeSet过于麻烦。项目开发之中，简单java类是根据数据表设计得来的，
            如果一个类的属性很多，那么比较起来就很麻烦了。所以我们一般使用的是HashSet。
        */


        /*范例：使用Comparator接口*/
        Set<NewPerson> set3 = new TreeSet<>(new AscAgeComparator());
        set3.add(new NewPerson("Sam",17));
        set3.add(new NewPerson("Peter",20));
        set3.add(new NewPerson("Mary",14));
        System.out.println(set3);
        /*
            结果：
            [NewPerson{name='Mary', age=14}, NewPerson{name='Sam', age=17}, NewPerson{name='Peter', age=20}]
        */
        Set<NewPerson> set4 = new TreeSet<>(new DescAgeComparator());
        set4.add(new NewPerson("Sam",17));
        set4.add(new NewPerson("Peter",20));
        set4.add(new NewPerson("Mary",14));
        System.out.println(set4);
        /*
            结果：
            [NewPerson{name='Peter', age=20}, NewPerson{name='Sam', age=17}, NewPerson{name='Mary', age=14}]
        */

    }
}

/*实现Comparable接口的一般类*/
class NewPerson implements Comparable<NewPerson>{
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "NewPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(NewPerson o) {
        if (this.age > o.age){
            return 1 ;
        }else if (this.age < o.age){
            return -1;
        }else {
            return this.name.compareTo(o.name);// 调用String类里的compareTo方法
        }
    }

    public NewPerson(String name, Integer age) {
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

    /*覆写hashCode()与equals()方法消除重复*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewPerson newPerson = (NewPerson) o;
        return Objects.equals(name, newPerson.name) &&
                Objects.equals(age, newPerson.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
/*实现Comparator接口的比较器类*/
class AscAgeComparator implements Comparator<NewPerson>{

    @Override
    public int compare(NewPerson o1, NewPerson o2) {
        return o1.getAge() - o2.getAge();
    }
}

/*上面实现的效果是将对象按年龄从小到大排列，下面则是从大到小排列*/

class DescAgeComparator implements Comparator<NewPerson>{

    @Override
    public int compare(NewPerson o1, NewPerson o2) {
        return o2.getAge() - o1.getAge();
    }
}