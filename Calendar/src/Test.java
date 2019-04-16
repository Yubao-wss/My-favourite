import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Auther: WSS
 * @Date:
 * @Description 可视化日历程序
 *              利用GregorianCalendar类，打印当前月份的日历
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        //将字符串通过SImpleDateFormat转化成Date对象，
        //再将Date对象转化成日期类
        String string = "2019-1-29";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(string);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);


        System.out.println("日\t一\t二\t三\t四\t五\t六");

        calendar.set(Calendar.DAY_OF_MONTH,1);
        for (int i=0;i<calendar.get(Calendar.DAY_OF_WEEK)-1;i++){
            System.out.print("\t");
        }

        int days = calendar.getActualMaximum(Calendar.DATE);//获取当月天数

        for (int i=1;i<=days;i++){
            System.out.print(calendar.get(Calendar.DAY_OF_MONTH)+"\t");
            if (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){//Calendar.SATURDAY=7
                System.out.println();  //换行
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);


        }

    }
}
//输出结果

/*
日	一	二	三	四	五	六
          1	   2	3    4	 5
6	 7	  8	   9	10	11	 12
13	 14	  15   16	17	18	 19
27	 28	  29   30	31
*/
