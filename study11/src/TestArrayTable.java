import java.util.Arrays;

/**
 * @Auther: WSS
 * @Date:
 * @Description 测试数组存储表格数据
 */
public class TestArrayTable {
    public static void main(String[] args) {
        Object[] emp1 = {1,"WSS",20,"student"};
        Object[] emp2 = {2,"HJX",21,"student"};
        Object[] emp3 = {3,"ZMY",19,"student"};

        Object[][] tableData = new Object[3][];
        tableData[0] = emp1;
        tableData[1] = emp2;
        tableData[2] = emp3;

        for (Object[] temp:tableData){
            System.out.println(Arrays.toString(temp));
        }
    }
}
