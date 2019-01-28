

import javax.jws.soap.SOAPBinding;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Auther: WSS
 * @Date:
 * @Description 日期类的使用
 */
public class TestCanlender {
    public static void main(String[] args) {
        //get()获取日期的相关元素
        Calendar c = new GregorianCalendar();//获取当前日期
        Calendar calendar = new GregorianCalendar(2019,1,28,16,20,00);//创建日期对象，并初始化内容
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);//星期几
        int day = calendar.get(Calendar.DATE); //等同于DAY_OF_MONTH

        System.out.println(calendar);//java.util.GregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=false,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=?,YEAR=2019,MONTH=1,WEEK_OF_YEAR=?,WEEK_OF_MONTH=?,DAY_OF_MONTH=28,DAY_OF_YEAR=?,DAY_OF_WEEK=?,DAY_OF_WEEK_IN_MONTH=?,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=20,SECOND=0,MILLISECOND=?,ZONE_OFFSET=?,DST_OFFSET=?]
        System.out.println(year);//2019
        System.out.println(month);//1
        System.out.println(weekday);//5(THURSDAY)
        System.out.println(day);//28

        //set()设置日期
        Calendar calendar2 = new GregorianCalendar();
        calendar2.set(Calendar.YEAR,3019);
        System.out.println(calendar2);//java.util.GregorianCalendar[time=?,areFieldsSet=false,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=3019,MONTH=0,WEEK_OF_YEAR=5,WEEK_OF_MONTH=5,DAY_OF_MONTH=28,DAY_OF_YEAR=28,DAY_OF_WEEK=2,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=42,SECOND=18,MILLISECOND=374,ZONE_OFFSET=28800000,DST_OFFSET=0]

        //日期的计算
        Calendar calendar3 = new GregorianCalendar();
        calendar3.add(Calendar.DATE,100);//往后一百天
        System.out.println(calendar3);//java.util.GregorianCalendar[time=1557304938374,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2019,MONTH=4,WEEK_OF_YEAR=19,WEEK_OF_MONTH=2,DAY_OF_MONTH=8,DAY_OF_YEAR=128,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=42,SECOND=18,MILLISECOND=374,ZONE_OFFSET=28800000,DST_OFFSET=0]

        //日期对象和时间对象的转化
        Date date = c.getTime();
        Calendar calendar4 = new GregorianCalendar();
        calendar4.setTime(new Date());

        //测试打印方法
        printCalendar(c);//2019年1月28日 5:2:58 周1                                                                                        
    }

    //自定义方法打印日期
    public static void printCalendar(Calendar c){
        //打印：xxxx年xx月xx日 xx：xx：xx 周x
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int date = c.get(Calendar.DAY_OF_MONTH);
        int dayofweek = c.get(Calendar.DAY_OF_WEEK)-1;
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        System.out.println(year+"年"+month+"月"+date+"日"+" "+hour+":"+minute+":"+second+" 周"+dayofweek);

    }
}
