import javax.jws.soap.SOAPBinding;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * @Auther: WSS
 * @Date:
 * @Description 可视化日历程序-加入键盘输入操作
 *
 */
public class Test2 {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入日期，格式如：1970-1-1");
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        //将字符串通过SImpleDateFormat转化成Date对象，
        //再将Date对象转化成日期类
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(string);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        int day = calendar.get(Calendar.DAY_OF_MONTH);//获取天
        int days = calendar.getActualMaximum(Calendar.DATE);//获取当月天数

        System.out.println("日\t一\t二\t三\t四\t五\t六");

        calendar.set(Calendar.DAY_OF_MONTH,1);
        for (int i=0;i<calendar.get(Calendar.DAY_OF_WEEK)-1;i++){
            System.out.print("\t");
        }

        for (int i=1;i<=days;i++){
            if (day == calendar.get(Calendar.DAY_OF_MONTH)){
                System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"*\t");//时所输入日期，添加标记
            }else {
                System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"\t");
            }
            if (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){//Calendar.SATURDAY=7
                System.out.println();  //换行
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);


        }

    }
}
//输出结果：
        /*
        请输入日期，格式如：1970-1-1
        2019-1-29
        日	一	二	三	四	五	六
                1	2	3	4	5
        6	7	8	9	10	11	12
        13	14	15	16	17	18	19
        20	21	22	23	24	25	26
        27	28	29*	30	31
        */