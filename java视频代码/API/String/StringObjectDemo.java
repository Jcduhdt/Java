package cn.itcast.p1.string.demo;

/**
 * @version V12.0.1 2019-7-5
 * @author Zhang Xiong
 */

public class StringObjectDemo
{
    public static void main(String[] args)
    {
/*        String s1 = "abc";
        String s2 = "abc";
        intern();对字符串池进行操作的*/

        String s1 = new String("abc");
        String s2 = s1.intern();//获取的是池中的数据
        System.out.println(s1==s2);//false
    }
}
