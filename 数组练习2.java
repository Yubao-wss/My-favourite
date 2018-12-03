public class Work1{
    public static void main(String[] args){
        int[] x = new int[]{1,3,5,7,9};
        arrprint(x);
        int[] ret =arraySub(x,1,3);
        System.out.println();
        arrprint(ret);
        printReversal(x);
        System.out.println();
        arrprint(x);
    }
    //数组打印
    public static void arrprint(int[] arr)
    {
        int i=0;
        for(;i<arr.length;i++){
          System.out.print(arr[i]+" ");
        }
    }
    //数组截取
    //[start, end)
    // A {1,3,5,7,9} ->(A,1,3) > {3,5}
    public static int[] arraySub(int[] data, int start , int end){
        int[] ret = new int[end-start];
        int i = 0;
        for(;start<end;start++)
        {
            ret[i] = data[start];
            i++;
        }
        return ret;
    }
    //数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
        int i = 0;
        int tmp = 0;
        int j = data.length-1;
        for(;i<data.length/2;i++)
        {
           tmp = data[i];
           data[i] = data[j];
           data[j] = tmp;
           j--;
        }
    }
}
