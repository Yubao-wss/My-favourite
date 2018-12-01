public class Work1{
    public static void main(String[] args){
        int[] x = new int[]{1,3,5,7,9};
        int ret1 = arrayMaxElement(x);
        System.out.println(ret1);
        int ret2 = arrayMinElement(x);
        System.out.println(ret2);
        int ret3 = arrayElementSum(x);
        System.out.println(ret3);
        int[] y = new int[]{2,4,6,8,10};
        int[] ret4 = arrayJoin(x, y);
        arrprint(ret4);

    }
     //1.计算数组中最大值
     public static int arrayMaxElement(int[] data){
       int i;
       int tmp = 0;
       int j;
       for(i=0;i<data.length-1;i++)
       {
           for(j=0;j<data.length-i-i;j++)
        {
           if(data[i]>data[i+1])
           {
               data[i]=tmp;
               data[i]=data[i+1];
               data[i+1]=tmp;
           }
        }
       }
       return data[data.length-1];
   }
    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
        int i;
       int tmp = 0;
       int j;
       for(i=0;i<data.length-1;i++)
       {
           for(j=0;j<data.length-i-i;j++)
        {
           if(data[i]>data[i+1])
           {
               data[i]=tmp;
               data[i]=data[i+1];
               data[i+1]=tmp;
           }
        }
       }
       return data[0];
        
    }
    //计算数组值之和
    public static int arrayElementSum(int[] data){
        int i = 0;
        int ret = 0;
        for(;i<data.length;i++)
        {
           ret += data[i];
        }
        return ret;
    }
    //数组拼接
    // A {1,3,5,7,9} B {2,4,6,8,10} -> {1,3,5,7,9,2,4,6,8,10}
    public static int[] arrayJoin(int[] a, int[] b){
        int i=0;
        int j=0;
        int[] ret = new int[a.length+b.length];
        for(;i<a.length;i++)
        {
            ret[i]=a[i];
        }
        i=a.length;
        for(;j<b.length;j++)
        {
            ret[i+j]=b[j];
        }
        return ret;
    }
    public static void arrprint(int[] arr)
    {
        int i=0;
        for(;i<arr.length;i++){
          System.out.print(arr[i]+" ");
        }
    }
}
