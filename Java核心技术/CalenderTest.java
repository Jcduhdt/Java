import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * time:2019-5-20
 * author: Zhang Xiong
 * 打印该月的日历表
 */
public class CalenderTest
{
    public static void main(String[] args)
    {
        LocalDate date = LocalDate.now();//定义一个日历类，初始化为当前年月日
        int month = date.getMonthValue();//month初始化为当前日期的月份
        int today = date.getDayOfMonth();//today为当前日期的日

        date = date.minusDays(today - 1);//Set to start of month date指向该月的第一天 就是减去today-1天
        //LocalDate minusDays(int n) 生成当前日期之后或之前n天的日期
        DayOfWeek weekday = date.getDayOfWeek();//date这天是星期几
        int value = weekday.getValue();//1 = monday...7 = sunday

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1;i<value;i++)
            System.out.print("    ");//该月初始天前均打印空格代替
        while (date.getMonthValue() == month)//确保是在该月份
        {
            System.out.printf("%3d", date.getDayOfMonth());//打印几号
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");//每天隔一个空格
            date = date.plusDays(1);//date加一天
            if (date.getDayOfWeek().getValue() == 1)//因为加一天了，所以判断date是不是星期一，是就换行
                System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1)//有啥用 感觉也没啥必要
            System.out.println();
    }
}


