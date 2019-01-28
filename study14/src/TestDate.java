import java.util.Date;

/**
 * @Auther: WSS
 * @Date:
 * @Description Date时间类
 *              在标准Java类库中包含一个Date类。它的对象表示一个特定的瞬间，精确到毫秒。
 *
 *       1. Date() 分配一个Date对象，并初始化此对象为系统当前的日期和时间，可以精确到毫秒)。
 *
 *       2. Date(long date) 分配 Date 对象并初始化此对象，以表示自从标准基准时间(称为“历元(epoch)”，即 1970 年 1 月 1 日 00:00:00 GMT)以来的指定毫秒数。
 *
 *       3. boolean after(Date when) 测试此日期是否在指定日期之后。
 *
 *       4. boolean before(Date when) 测试此日期是否在指定日期之前。
 *
 *       5. boolean equals(Object obj) 比较两个日期的相等性。
 *
 *       6. long getTime() 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
 *
 *       7. String toString() 把此 Date 对象转换为以下形式的 String：
 *
 *         dow mon dd hh:mm:ss zzz yyyy 其中： dow 是一周中的某一天 (Sun、 Mon、Tue、Wed、 Thu、 Fri、 Sat)。
 */
public class TestDate {
    public static void main(String[] args) {
        //我们用long类型的变量来表示时间，从基准时间往前几亿年，往后几亿年都能表示。
        // 如果想获得现在时刻的“时刻数值”，可以使用：
        long now = System.currentTimeMillis();
        System.out.println(now);//1548609763357(ms)

        Date date1 = new Date();
        System.out.println(date1.toString());//Mon Jan 28 01:32:52 CST 2019
        long i = date1.getTime();//ms数
        Date date2 = new Date(i - 1000);
        Date date3 = new Date(i + 1000);
        System.out.println(date1.after(date2));//true
        System.out.println(date1.before(date2));//false
        System.out.println(date1.after(date3));//false
        System.out.println(date1.before(date3));//true
        System.out.println(date1.equals(date2));//false
        System.out.println(date1.equals(date3));//false
        System.out.println(new Date(555).toString());//Thu Jan 01 08:00:00 CST 1970

        //以后遇到日期处理，使用Canlender日期类
        Date d3 = new Date(2020-1900,3,10);//2020年4月10日
        System.out.println(d3);

    }
}
