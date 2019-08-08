package cn.itcast.p1.otherapi;

import java.util.Properties;
import java.util.Set;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-20
 */
public class SystemDemo {

    private static final String line_separator = System.getProperty("line.separator");
    public static void main(String[] args) {
        /*
         * System:类中的方法和属性都是静态的
         *
         * 常见方法
         * long currentTimeMillis();获取当前时间的毫秒值
         * 距1970.01.01的毫秒时间差
         */

//        long l1 = System.currentTimeMillis();
//        System.out.println(l1);
//
//        long l2 = System.currentTimeMillis();
//        System.out.println(l2-l1);

        System.out.println("hello-"+line_separator +"world");
        //System.getProperty("line.separator")换行动作，line.separator键值
//        demo_1();

// 给系统设置一些属性信息，这些属性是全局的，其他程序都可以使用
//        System.setProperties("mykey","myvalue");
    }

    private static void demo_1() {
        //获取系统的属性消息，并存储到了Properties集合中
        /*
         * prooerties集合中存储都是String类型的键和值
         * 最好使用它自己的存储和读取方法来完成元素的操作
         */

        Properties prop = System.getProperties();

        Set<String> nameSet = prop.stringPropertyNames();

        for (String name : nameSet) {
            String value = prop.getProperty(name);

            System.out.println(name + "::" + value);//打印系统信息
        }
    }
}
