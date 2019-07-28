import java.util.TreeSet;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-28
 */
public class RegexTest {
    public static void main(String[] args) {

        /*
         * 1.治疗口吃：我我我我...我我....我要要..要要要.要.要.....要要要...要要要学学......学学....学学编编编编编编.......编编程程......程程程..程程
         * 2.对ip地址排序
         * 3.对邮件地址校验
         */
//        test_1();
//        test_2();
        test_3();
    }

    /*
     * 1.治口吃
     */
    public static void test_1(){
        String str = "我我我我...我我....我要要..要要要.要.要.....要要要...要要要学学......学学....学学编编编编编编.......编编程程......程程程..程程";

        //1.将字符串中的.去掉 用替换
        str = str.replaceAll("\\.+","");
        System.out.println(str);

        //2.叠词替换
        str = str.replaceAll("(.)\\1+","$1");
        System.out.println(str);
    }

    /*
     * 2.ip地址排序
     *
     * 192.168.10.34  127.0.0.1  3.3.3.3 105.70.11.55
     *
     */

    public static void test_2(){
        String ip_str = "192.168.10.34  127.0.0.1  3.3.3.3 105.70.11.55";

        //1.为了让ip可以按照字符串顺序比较，只要让ip的每一段的位数相同
        //所以，补零，按照每一位所需做多0进行补充，每一段都加两个0

        ip_str = ip_str.replaceAll("(\\d+)","00$1");
        System.out.println(ip_str);

        //然后每一段保留数字3位
        ip_str = ip_str.replaceAll("0*(\\d{3})","$1");
        System.out.println(ip_str);

        //1.将ip地址切出
        String[] ips = ip_str.split(" +");

        TreeSet<String> ts = new TreeSet<String>();

        for (String ip : ips) {
//            System.out.println(ip);
            ts.add(ip);
        }

        for (String t : ts) {
            System.out.println(t.replaceAll("0*(\\d+)","$1"));//再把ip还原成原来的样子
        }
    }



    //对邮件地址校验
    public static void test_3(){
        String mail = "abc@sina.com.cn";

        String regex = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{1,3}){1,3}";

//        regex = "\\w+@\\w+(\\.\\w)+";//1@1.1  \\w就是单词字符：[a-zA-Z_0-9]

        boolean b = mail.matches(regex);

        System.out.println(mail+":"+b);
    }
}
