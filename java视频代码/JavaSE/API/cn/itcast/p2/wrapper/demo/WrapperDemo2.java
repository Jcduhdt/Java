package cn.itcast.p2.wrapper.demo;

/**
 * @version V12.0.1 2019-7-9
 * @author Zhang Xiong
 */

public class WrapperDemo2
{
    public static void main(String[] args)
    {
        int num = 4;
        num = num + 5;
        Integer i = 4;//i = new Integer(4);自动装箱 简化书写，因为Integer就是描述的int
        i = i + 6;//i =  new Integer(i.intValue() + 6);//i.intValue()自动拆箱

        Integer a = new Integer(127);
        Integer b = new Integer(127);

        System.out.println(a==b);//false 两个new 两地址两对象
        System.out.println(a.equals(b));//true

        Integer x = 127;//jdk1.5以后，自动装箱，如果装箱的是一个字节，那么该数据会被共享不会重新开辟空间
        Integer y = 127;//所以127  128分水岭
        System.out.println(x==y);//127true  128false
        System.out.println(x.equals(y));//true
    }

    public static void show(Object a)
    {
        //Object a = new Integer(55);
        System.out.println("a = " + a);
    }
}
