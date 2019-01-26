import java.util.Arrays;

/**
 * @Auther: WSS
 * @Date:
 * @Description 测试二分查找
 */
public class TestBinarySearch {
    public static void main(String[] args) {
        int[] arr = {30, 20, 50, 10, 80, 9, 7, 12, 100, 40, 8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int value = 10;
        int result = myBinarySearch(arr,10);
        System.out.println(result);

    }

    public static int myBinarySearch(int[] arr,int value) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (value == arr[mid]) {
                return mid; //找到，返回索引位置
            }
            if (value > arr[mid]) {
                low = mid + 1;
            }
            if (value < arr[mid]) {
                high = mid - 1;
            }
        }
        return -1;//找不到，返回-1
    }
}



