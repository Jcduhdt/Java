package cn.itcast.p1.otherapi;

import java.util.Calendar;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-21
 */
public class CalenderDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        int year = 2018;
        showDays(year);//打印该年2月的最后一天
    }

    public static void showDays(int year) {
        Calendar c = Calendar.getInstance();
        c.set(year,2,1);//指定一个日期 某一年的3月1号

        c.add(Calendar.DAY_OF_MONTH,-1);//时间偏移，在指定的年月日上偏移制定的数目


        showDate(c);
    }

    public static void showDate(Calendar c) {
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;// 因为计算机内月份是0-11表示1-12月，所以月份应该+1
        int day = c.get(Calendar.DAY_OF_MONTH);
        String week = getWeek(c.get(Calendar.DAY_OF_WEEK));

        System.out.println(year+"年"+month+"月"+day+"日"+week);
    }

    public static String getWeek(int i) {
        String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        return weeks[i];
    }
}
