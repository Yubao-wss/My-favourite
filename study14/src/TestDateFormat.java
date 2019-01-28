
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Auther: WSS
 * @Date:
 * @Description DateFormat抽象类和SimpleDateFormat实现类的使用
 *              把时间对象转化成指定格式的字符串。反之，把指定格式的字符串转化成时间对象。
 *              DateFormat是一个抽象类，一般使用它的的子类SimpleDateFormat类来实现。
 *
 */
public class TestDateFormat {
    public static void main(String[] args) throws ParseException {

        //把时间对象按照 指定格式 转成相应的字符串
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//定义格式
        DateFormat df2 = new SimpleDateFormat("yyyy年-MM月-dd日 hh:mm:ss");//定义格式

        String str = df.format(new Date());//返回值为字符串
        String str2 = df2.format(new Date());
        System.out.println(str);//2019-01-28 03:46:55
        System.out.println(str2);//2019年-01月-28日 03:46:55


        //把字符串按照 指定格式 转成相应的时间对象
        DateFormat df3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date date = df3.parse("2019-01-28 03:00:00");//格式必须严格对照定义格式写
        System.out.println(date);//Mon Jan 28 03:00:00 CST 2019


        //其他格式字符
        DateFormat df4 = new SimpleDateFormat("D");//所处年份中的第几天
        String str3 = df4.format(new Date());
        System.out.println(str3);//28

        //更多格式--->http://www.sxt.cn/Java_jQuery_in_action/eight-date-simple.html

    }
}
