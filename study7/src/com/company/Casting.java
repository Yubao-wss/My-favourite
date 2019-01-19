package com.company;

/*public class Casting {
    public static void main(String[] args) {
        Object obj = new String("wss"); // 向上可以自动转型
        // obj.charAt(0) 无法调用。编译器认为obj是Object类型而不是String类型
         编写程序时，如果想调用运行时类型的方法，只能进行强制类型转换。
         * 不然通不过编译器的检查。
        String str = (String) obj; // 向下转型
        System.out.println(str.charAt(0)); // 位于0索引位置的字符
        System.out.println(obj == str); // true.他们俩运行时是同一个对象
    }
}*/

/*
父类引用指向子类对象，我们称这个过程为向上转型，属于自动类型转换。
向上转型后的父类引用变量只能调用它编译类型的方法，不能调用它运行时类型的方法。这时，我们就需要进行类型的强制转换，我们称之为向下转型!
*/

/*public class Casting {
    public static void main(String[] args) {
        Object obj = new String("wss");
        //真实的子类类型是String，但是此处向下转型为StringBuffer
        StringBuffer str = (StringBuffer) obj;
        System.out.println(str.charAt(0));
    }
}*/

/*
在向下转型过程中，必须将引用变量转成真实的子类类型(运行时类型)否则会出现类型转换异常ClassCastException。
*/

public class Casting {
    public static void main(String[] args) {
        Object obj = new String("wss");
        if(obj instanceof String){
            String str = (String)obj;
            System.out.println(str.charAt(0));
        }else if(obj instanceof StringBuffer){
            StringBuffer str = (StringBuffer) obj;
            System.out.println(str.charAt(0));
        }
    }
}

/*
使用instanceof避免异常的出现
*/
