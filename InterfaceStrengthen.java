/**
 * @Author: WSS
 * @Date: 2019/3/19 15:27
 * @Description: 接口定义加强
 *
 * 从JDK1.8开始，支持的新特性非常多，并且打破了很多原有的设计方案，其中具有最大变化的就是接口。
 *
 * 在开发过程中，一个接口可能被成千上万个子类实现，但如果接口中缺失了一些方法（接口显示出缺陷）
 * 造成此种现象的核心问题在于：接口只是一个方法的声明，而没有具体的方法实现，所以随着时间的推移，
 * 如果真的出现了以上的问题，那么该接口就将无法继续使用。
 *
 * 从JDK1.8开始，为了解决这样的问题，专门提供了两类新的结构：
 *  可以使用default来定义普通方法，需要通过对象调用
 *  可以使用static来定义静态方法，通过接口名就可以调用
 *
 */
interface IMessage{
    /*范例：定义普通方法*/
    public default void fun(){ // 追加的普通方法，需要有方法体
        System.out.println("Hello IMessage");
    }
    /*范例：定义static方法*/
    public static IMessage getInstance(){// 可以直接由接口名称直接调用
        return new MessageImpl();
    }
    public void print();
}

class MessageImpl implements IMessage{
    @Override
    public void print() {
        System.out.println("Hello MessageImpl");
    }
}

public class InterfaceStrengthen {
    public static void main(String[] args) {
        IMessage message = IMessage.getInstance();// 可以直接由接口名称直接调用接口内的static方法
        message.print();
        message.fun();
        /*
            结果：
            Hello MessageImpl
            Hello IMessage
        */
    }
}
/*
  整体来讲，接口感觉更像抽象类了，但是比抽象类更强大的在于：接口的子类依然可以实现多继承的关系，而抽象类依然保持单继承。
  因为时间一长，许多的支持就会出现问题（量大的问题），这个时候为了解决这种扩充的问题，才追加了此类支持。但是此操作不属于标准设计，属于挽救设计。
*/
