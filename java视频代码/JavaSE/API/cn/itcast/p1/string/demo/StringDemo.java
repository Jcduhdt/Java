package cn.itcast.p1.string.demo;

/**
 * @version V12.0.1 2019-7-5
 * @author Zhang Xiong
 */

/*
 * String类的特点：
 * 字符串对象一旦被初始化就不会被改变
 */
public class StringDemo
{
    public static void main(String[] args)
    {
//        stringDemo1();
        stringDemo2();
    }

    public static void stringDemo2()
    {
        String s = "abc";//创建一个字符串对象在常量池中  可被共享
        String s1 = new String("abc");//创建两个对象一个new一个字符串对象在堆内存中

        System.out.println(s == s1);//false  比较地址值
        System.out.println(s.equals(s1));//string类中的equals覆写了object中的equals
        //建立了string类自己的判断字符串是否相同的依据 其实就是比较的是字符串内容
        System.out.println("s = " + s);
        System.out.println("s1 = " + s1);
    }

    /**
     * 演示字符串定义的第一种方式，并明确字符串常量池的特点
     * 池中没有就建立，池中有，直接用
     */
    public static void stringDemo1() {
        String s = "abc";//"abc"存储在字符串常量池中
        String s1 = "abc";

        System.out.println(s == s1);//true
        // s = "nba";
        System.out.println("s = " + s);
    }
}
