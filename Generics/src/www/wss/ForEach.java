package www.wss;

/**
 * @Author: WSS
 * @Date: 2019/3/17 9:00
 * @Description: 新特性(JDK1.5)
 *
 * foreach循环
 */
public class ForEach {
    public static void main(String[] args) {
        //原始数组的输出使用for循环完成
        int[] data = new  int[] {1,2,3,4,5};
        for(int i = 0;i < data.length;i++){
            System.out.print(data[i]+" ");
        }
        //结果：1 2 3 4 5

        System.out.println();

        //从JDK1.5之后对于for循环的使用有了新格式：
        /*
            for(数据类型 临时变量 : 数组(集合)) {
                循环次数为数组长度，而每一次循环都会顺序取出数组中的一个元素赋值给临时变量
            }
        */
        //即在for循环里面无须使用索引来取数据
        for (int i : data){
            System.out.print(i + " ");
        }
        //结果：1 2 3 4 5

        //通过此方式可以很好的避免数组越界的问题，但是这种数组的操作只适合简单输出模式
    }
}
