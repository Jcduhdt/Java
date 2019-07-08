package cn.itcast.p2.stringBuffer.demo;

/**
 * @version V12.0.1 2019-7-8
 * @author Zhang Xiong
 */

/*
 * jdk1.5以后出现了功能和StringBuffer一模一样的对象，就是StringBuilder
 *
 * 不同的是：
 * StringBuffer线程同步  多线程用  为了安全
 * StringBuilder线程不同步 单线程用 为了提高效率
 *
 * jdk升级：
 * 1.简化书写
 * 2.提高效率
 * 3.增加安全性
 */

/*class StringBuffer
{
    Object lock;
    public  StringBuffer append(int x)
    {
        synchronized (lock)
        {

        }
    }

    public StringBuffer delete(int start,int end)
    {
        synchronized (lock)
        {

        }
    }
}*/
public class StringBuilderDemo
{
    public static void main(String[] args)
    {

    }
}
