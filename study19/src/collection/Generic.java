package collection;

import java.util.*;

/**
 * @Author: WSS
 * @Date:
 * @Description: 泛型的概念
 * //泛型是JDK1.5以后增加的，它可以帮助我们建立类型安全的集合。在使用了泛型的集合中，遍历时不必进行强制类型转换。
 * //JDK提供了支持泛型的编译器，将运行时的类型检查提前到了编译时执行，提高了代码可读性和安全性。
 * //泛型的本质就是“数据类型的参数化”。 我们可以把“泛型”理解为数据类型的一个占位符(形式参数)，即告诉编译器，在调用泛型时必须传入实际类型。
 *
 */

public class Generic {
    public static void main(String[] args) {
        //自定义泛型的使用
        MyCollection<String> myCollection = new MyCollection<>();//这里的”String”就是实际传入的数据类型,后面new对象时“<>”中可以写String也可以不写内容
        myCollection.set("P",0);
        String string = myCollection.get(0);//加了泛型，直接返回String类型，不用强制转换;
        System.out.println(string);//P

        //容器中使用泛型
        //容器相关类都定义了泛型，我们在开发和工作中，在使用容器类时都要使用泛型。
        //这样，在容器的存储数据、读取数据时都避免了大量的类型判断，非常便捷。

        //以下代码中List、Set、Map、Iterator都是与容器相关的接口
        List<String> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Map<String,Integer> map = new HashMap<>();
        Iterator<Integer> iterator = set.iterator();
        // 通过阅读源码，发现Collection、List、Set、Map、Iterator接口都定义了泛型
    }
}

//自定义泛型
//我们可以在类的声明处增加泛型列表，如：<T,E,V>。
//此处，字符可以是任何标识符，一般采用这3个字母。

class MyCollection<E>{// E表示泛型
    Object[] objects = new Object[5];//创建一个Object型数组

    public E get(int index){//get方法
        return (E) objects[index];
    }
    public void set(E e,int index){//set方法
        objects[index] = e;
    }
}
// 泛型 E 像一个占位符一样表示“未知的某个数据类型”，我们在真正调用的时候传入这个“数据类型”。


