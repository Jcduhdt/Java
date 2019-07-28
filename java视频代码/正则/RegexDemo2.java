import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-28
 */
public class RegexDemo2 {
    public static void main(String[] args) {

        /*
         * 正则表达式对字符串的常见操作
         * 1.匹配
         *      其实使用的就是String类中的matches()方法
         * 2.切割
         *      其实使用的就是String类中的split()方法
         * 3.替换
         *      其实使用的就是String类中的replaceAll()方法
         * 4.获取
         *
         */

//        functionDemo_1();
//        functionDemo_2();
//        functionDemo_3();
        functionDemo_4();
    }

    /*
     * 获取
     * 将正则规则进行对象的封装
     * Pattern p = Pattern.compile("a*b");
     * //通过正则对象的matcher方法字符串相关联，获取要对字符串操作的匹配器对象Matcher
     * Matcher m = p.matcher("aaaaab");
     * //通过Matcher匹配器对象的方法对字符串进行操作
     * boolean b = m.matches();
     */
    private static void functionDemo_4() {
        String str = "da jia hao,ming tian fang jia!";

        String regex = "\\b[a-z]{3}\\b";// \\b单词的边界

        //1.将正则封装成对象
        Pattern p  = Pattern.compile(regex);

        //2.通过正则对象获取匹配器对象
        Matcher m = p.matcher(str);

        //使用Matcher对象的方法对字符串进行操作
        //既然要获取三个字母组成的单词
        //查找。find();
        System.out.println(str);
        while (m.find()) {
            System.out.println(m.group());//获取匹配的子序列
            System.out.println(m.start()+":"+m.end());//匹配到的位置
        }
    }


    /*
     * 替换
     */
    private static void functionDemo_3() {
        String str = "zhangsanttttxiaoqiangmmmmmzhaoliu";

//        str = str.replaceAll("(.)\\1+","#");//将叠词替换为#
        str = str.replaceAll("(.)\\1+","$1");//$获取前一个参数的第一组
        System.out.println(str);

        String tel = "15100001111";//151****1111;
        tel = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
        //封装成组，$1获取第一组$2获取第二组，把中间的号码替换成****
        System.out.println(tel);
    }

    /*
     * 演示切割
     *
     * 组:((A)(B(C)))组号就是从左往右数( 第几个就是第几组
     */
    public static void functionDemo_2(){

        String str = "zhangsan        xiaoqiang    zhaoliu";
        String[] names = str.split(" +");//正则，+表示出现一次或多次
        for (String name : names) {
            System.out.println(name);
        }


        String str1 = "zhangsan.xiaoqiang.zhaoliu";
        //.在正则中是特殊符号，代表所有符号  要以.区分就要\\.
        String[] names1 = str1.split("\\.");
        for (String s : names1) {
            System.out.println(s);
        }


        //切割以叠词为区分
        String str2 = "zhangsanttttxiaoqiangmmmmmmzhaoliu";
        String[] names2 = str2.split("(.)\\1+");//使用第一组的内容  ()表示组的概念

        for (String s : names2) {
            System.out.println(s);
        }
    }

    /*
     * 演示匹配
     */

    public static void functionDemo_1(){

        //匹配手机号码是否正确
        String tel = "15144906387";

        String regex = "1[358]\\d{9}";// 正则中，\d就是[0-9]因为\是转义，所以需要\\来转成\

        boolean b = tel.matches(regex);
        System.out.println(tel+":"+b);
    }
}
