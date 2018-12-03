public class Work1
{
    public static void main(String[] args){
        int i = 0;
        int j = 0;
        for(i=1;i<=9;i++)
        {
            for(j=1;j<=i;j++)
            {
                System.out.print(i+" "+"*"+" "+j+" "+"="+" "+i*j+"    ");
            }
            System.out.println();
        }
    }
}
