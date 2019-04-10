package www.wss;

import java.util.*;


/**
 * @Author: WSS
 * @Date: 2019/4/10 9:22
 * @Description: 集合输出
 *
 * 在之前进行集合输出的时候都利用了toString()，或者利用了List接口中的get()方法。这些都不是集合的标准输出。
 * 如果从标准上来讲，集合输出一共有四种手段：Iterator、ListIterator、Enumeration、foreach。
 *
 * 1.迭代输出：lterator
 *      在JDK1.5之前，在Collection接口中就定义有iterator()方法，通过此方法可以取得Iterator接口的实例化对象；
 *      而在JDK1.5之后，将此方法提升为Iterable接口中的方法。无论你如何提升，只要Collection有这个方法，那么List、Set也一定有此方法。
 *
 *      对于Iterator接口最初的设计里面实际有三个抽象方法：
 *          1. 判断是否有下一个元素: public boolean hasNext();
 *          2. 取得当前元素: public E next();
 *          3. 删除元素: public default void remove(); 此方法从JDK1.8开始变为default完整方法
 *
 *      注意：以后在进行集合输出的时候不要修改集合中元素！！！
 *
 *
 * 2.双向迭代接口：Listlterator
 *      Iterator输出有一个特点：只能够由前向后进行内容的迭代处理，而如果要想进行双向迭代，那么就必须依靠Iterator的子接口：ListIterator来实现。
 *      此接口定义的方法：
 *          1. 判断是否有上一个元素：public boolean hasPrevious();
 *          2. 取得上一个元素:public E previous();
 *
 *      Iterator接口对象是由Collection接口支持的，但是ListIterator是由List接口支持的，List接口提供有如下方法：
 *          取得ListIterator接口对象：public ListIterator listIterator();
 *
 * 3.Enumeration枚举输出
 *      在JDK1.0的时候就引入了Enumeration输出接口，而在JDK1.5的时候对其也做了更正，主要是追加了泛型的应用。
 *      Enumeration的接口定义：
 *          1. 判断是否有下一个元素:public boolean hasMoreElements();
 *          2. 取得元素:public E nextElement();
 *
 *      ！但是要想取得这个接口的实例化对象，是不能依靠Collection、List、Set等接口的。只能够依靠Vector子类，
 *      因为Enumeration最早的设计就是为Vector服务的，在Vector类中提供有一个取得Enumeration接口对象的方法:
 *          取得Enumeration接口对象:public Enumeration<E> elements()
 *
 *      ！一些操作类库上依然只支持Enumeration，而不支持Iterator。
 *
 * 4.foreach输出
 *      从JDK1.5开始foreach可以输出数组，实际上除了数组之外也可以输出集合。
 *
 * 总结：
 * 1. 看见集合输出就使用Iterator
 * 2. Iterator和Enumeration中的方法要掌握
 *
 */
public class CollectionExport {
    public static void main(String[] args) {
        /*标准的lterator使用*/
        List<String> list = new ArrayList<>();
        list.add("Deep");
        list.add("Dark");
        list.add("Fantasy");
        Iterator<String> iterator = list.iterator();// 实例化Iterator对象
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
        /*
            结果：
            Deep
            Dark
            Fantasy
        */

        /*对于Iterator接口中提供的remove()方法主要解决的就是集合内容的删除操作。*/
        /*范例：删除元素*/
        list.add("Fantasy");// 向上面的List中再添加一个元素
        Iterator<String> iterator1 = list.iterator();// 重置迭代器
        while (iterator1.hasNext()){
            String str = iterator1.next();
            if(str.equals("Fantasy")){
            //    使用集合提供的remove()方法，则会产生ConcurrentModificationException
            //    list.remove("Fantasy");
            //    使用Iterator的remove方法则不会产生异常
                iterator1.remove();
                continue;
            }
        }
        System.out.println(list);
        /*
            结果：
            [Deep, Dark]
        */

        /*范例：观察Listlterator接口使用*/
        list.add("Fantasy");// 再加回元素
        ListIterator<String> listIterator = list.listIterator();
        System.out.println("从前向后输出：");
        while (listIterator.hasNext()){
            System.out.print(listIterator.next());
            if (listIterator.hasNext()){
                System.out.print("、");
            }
        }
        System.out.println("\n从后向前输出：");
        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous());
            if (listIterator.hasPrevious()){
                System.out.print("、");
            }
        }
        /*
            结果：
            从前向后输出：
            Deep、Dark、Fantasy
            从后向前输出：
            Fantasy、Dark、Deep
        */
        // !如果要想实现由后向前的输出，那么应该首先进行从前向后的输出，否则无法实现双向。

        System.out.println();
        /*范例：使用Enumeration输出*/
        Vector<String> vector = new Vector<>();
        vector.add("Hello");
        vector.add("my");
        vector.add("friend");
        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.print(enumeration.nextElement()+" ");
        }
        /*
            结果：
            Hello my friend
        */

        System.out.println();
        /*范例：使用foreach输出*/
        for (String str : list){
            System.out.print(str+" ");
        }
        /*
            结果：
            Deep Dark Fantasy
        */
    }
}
