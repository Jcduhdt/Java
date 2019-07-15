package cn.itcast.p1.string.demo;

/**
 * @version V12.0.1 2019-7-5
 * @author Zhang Xiong
 */

public class StringConstructorDemo
{
    public static void main(String[] args)
    {
        stringConstructorDemo();
        stringConstructorDem2();

    }

    public static void stringConstructorDem2()
    {
        char[] arr = {'w','a','p','q','x'};
        String s = new String(arr,1,3);//取数组中的一部分，从角标1开始，3个
        System.out.println("s = " + s);//s = apq
    }

    public static void stringConstructorDemo()
    {
        String s = new String();//等效于String s = ""; 不等效于String s = null;
        byte[] arr = {65,66,67,68};

        String s1 = new String(arr);
        System.out.println("s1 = " + s1);//s1 = ABCD  将字节数组变成字符串，打印的是ascii码
    }
}
