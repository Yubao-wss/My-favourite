package www.wss;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: WSS
 * @Date: 2019/4/16 22:47
 * @Description: 栈与队列
 *
 * 1.Stack栈
 *  栈是一种先进后出的数据结构 。浏览器的后退、编辑器的撤销、安卓Activity的返回等都属于栈的功能。
 *
 * 在Java集合中提供有Stack类，这个类是Vector的子类。需要注意的是，使用这个类的时候使用的不是Vector类中的方法，
 * 并且在使用时不要进行向上转型。因为要操作的方法不是由List定义的，而是由Stack定义的。
 *      1.入栈：public E push(E item)
 *      2.出栈：public synchronized E pop()
 *      3.观察栈顶元素：public synchronized E peek()
 *
 * 2.Queue队列
 *  Stack是先进后出，与之对应的Queue是先进先出。
 *  在java.util包中使用Queue来实现队列处理操作。Queue接口有一个子类LinkedList。
 *  使用Queue接口主要是进行先进先出的实现，在这个接口里面有如下的方法:
 *      按照队列取出内容: public E poll();
 *
 *
 *
 *
 *
 *
 */
public class TestStack {
    public static void main(String[] args) {
        /*范例：观察出入栈操作*/
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        /*
            结果：
            C
            C
            B
            A
        */
        // !如果栈已经空了，那么再次出栈就会抛出空栈异常。


        /*范例：Queue的正确使用方法*/
        Queue<String> queue = new LinkedList<>();
        queue.add("X");
        queue.add("Y");
        queue.add("Z");
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        /*
            结果：
            X
            X
            Y
            Z
            null
        */
        // !取完数据继续poll返回null
    }
}
