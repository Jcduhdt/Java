package cn.itcast.p1.otherapi.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-21
 */

/*
 * 我这个返回时间有问题，方法应该是都没有错的
 * 练习：
 * "2012-3-17"到"2012-4-6"
 * 中间有多少天
 *
 * 思路
 * 两个日期相减就行
 * 怎么减
 * 必须要有两个可以进行减法运算的数
 * 能减可以是毫秒值。如何获取毫秒值？通过Date对象
 * 如何获取date对象呢？可以将字符串转成date对象
 *
 * 1.将日期格式的字符串转成Date对象
 * 2.将Date对象转成毫秒值
 * 3.相减，再变成天数
 */
public class DateTest {
    public static void main(String[] args) throws ParseException {
        String str_date1 = "2019-3-17";
        String str_date2 = "2019-5-19";
        test(str_date1,str_date2);
    }

    public static void test(String str_date1,String str_date2) throws ParseException {
        //1.将日期字符串转成日期对象
        //定义日期格式对象
        DateFormat dateFormat = DateFormat.getDateInstance();
        dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        Date date1 = dateFormat.parse(str_date1);
        Date date2 = dateFormat.parse(str_date2);

        long time1 = date1.getTime();
        long time2 = date2.getTime();

        long time = Math.abs(time1-time2);
        System.out.println(time);

        int day = getDay(time);
        System.out.println(day);
    }

    public static int getDay(long time) {
        int day = (int)(time/1000/60/60/24);
        return day;
    }
}
