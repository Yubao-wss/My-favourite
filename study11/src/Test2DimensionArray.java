import java.util.Arrays;

/**
 * @Auther: WSS
 * @Date:
 * @Description 测试二维数组
 */
public class Test2DimensionArray {
    public static void main(String[] args) {
        //动态初始化二维数组
        int[][] a = new int[3][];

        a[0] = new int[]{20,30};
        a[1] = new int[]{10,15,80};
        a[2] = new int[]{50,60};

        System.out.println(Arrays.toString(a[2]));

        //静态初始化二维数组
        int[][] b={
                {20,30},
                {10,15,80},
                {50,60}
        };
        System.out.println(b[1][2]);
    }
}
