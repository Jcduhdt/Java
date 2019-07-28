/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-28
 */

/*
 * 正则表达式
 *
 * 正则表达式用于操作字符串数据
 *
 * String.matches(regex)
 * 通过一些特定的符号来体现的
 * 所以我们为了掌握正则表达式，必须要学习一些符号
 *
 * 虽然简化了，但阅读性比较差
 */
public class RegexDemo {
    public static void main(String[] args) {
        String qq = "358436484";
//        checkQQ(qq);
        /*String regex = "[1-9][0-9]{4,14}";//正则表达式 第一位是1-9，后面的是0-9有4-14位，[]控制内容，{}控制次数

        boolean b = qq.matches(regex);
        System.out.println(qq+":"+b);*/

        String str = "aoob";
        String reg = "ao?b";//自己定义规则，o出现一次或一次也没有，自己看规则吧
        boolean b1 = str.matches(reg);
        System.out.println(str+":"+b1);
    }


    /*
     * 需求：定义一个功能对QQ号进行校验
     * 要求：长度5~15，只能是数字，0不能开头
     */
    private static void checkQQ(String qq) {
        int len = qq.length();
        if (len>=5 && len<=15){
            if(!qq.startsWith("0")){
                try {
                    long l = Long.parseLong(qq);
                    System.out.println(l+":正确");
                }catch (NumberFormatException e){
                    System.out.println(qq+":含有非法字符");
                }
            }else {
                System.out.println(qq+":不能0开头");
            }
        }
    }

}
