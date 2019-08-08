package cn.itcast.p1.otherapi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-20
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
//        methodDemo_1();
//        methodDemo_2();
        methodDemo_3();


    }

    /**
     * 将日期格式的字符串-->日期对象
     * 使用的是DateFormat方法中的parse方法
     *
     * @throws ParseException
     */
    public static void methodDemo_3() throws ParseException {
        String str_date = "2019年7月21日";

        DateFormat dateFormat = DateFormat.getDateInstance(); //这电脑的默认格式是"2019年7月21日" 不是"2019-7-21"，
        //要在日期格式器里面添加格式 便于解析
//        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);

        //对于指定格式
        /*str_date = "2019--7--21";
        dateFormat = new SimpleDateFormat("yyyy--mm--dd");*/

        Date date = dateFormat.parse(str_date);
        System.out.println(date);
    }

    /**
     * 对日期对象进行格式化
     * 将日期对象-->日期格式的字符串
     * 使用的是DateFormat类中的format方法
     */
    public static void methodDemo_2() {
        Date date = new Date();

        //获取日期格式器，该格式器具有默认语言环境的默认格式化风格。FULL LONG MEDIUM SHORT等可以指定风格
//        要格式化一个当前语言环境下的日期，可使用某个静态工厂方法
//        myString = DateFormat.getDateInstance().format(myDate);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);

//        System.out.println(dateFormat);//java.text.SimpleDateFormat@2e6646d6

        //如果风格是自定义的，如何解决呢?
        dateFormat = new SimpleDateFormat("yyyy--mm--dd");//自定义的格式
        String str_date = dateFormat.format(date);
        System.out.println(str_date);
    }


    /**
     * 日期对象和毫秒值之间的转换
     *
     * 毫秒值-->日期对象
     * 1.通过Date对象的构造方法new Date(timeMillis);
     * 2.还可以通过setTime设置
     * 因为可以通过Date对象的方法对该日期中的各个字段（年月日等）进行操作
     *
     * 日期对象-->毫秒值
     * 2.getTime()方法
     * 因为可以通过具体的数值进行运算
     *
     *
     */
    public static void methodDemo_1() {
        long time = System.currentTimeMillis();
        System.out.println(time);//1563614531467

        Date date = new Date();//将当前日期和时间封装成Date对象
        System.out.println(date);//Sat Jul 20 17:22:11 CST 2019

        Date date2 = new Date(1563614531467l);//将指定毫秒值封装成Date对象  注意：传入的毫秒值在尾部要加一个小写的L表示long
        System.out.println(date2);

    }

}
