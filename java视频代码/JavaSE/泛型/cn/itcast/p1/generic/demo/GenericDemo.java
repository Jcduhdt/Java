package cn.itcast.p1.generic.demo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version V12.0.1 2019-7-16
 * @author Zhang Xiong
 */
/*
 * 泛型，提高了安全性，编译时期
 */

public class GenericDemo
{
    public static void main(String[] args)
    {
//        int[] arr = new int[4];
//        arr[0] = 3.0;

        ArrayList<String> al = new ArrayList<String>();//左边申明，右边实体，申明要存储的类型

        al.add("abc");//public boolean add(Object obj);
        al.add("hahah");
//        al.add(4);//al.add(new Integer(4));

        Iterator<String> it = al.iterator();
        while (it.hasNext())
        {
//            String str = (String)it.next();//强转，因为ArrayList接收的是Object类型
            String str = it.next();//因为使用了泛型，Iterator那里已经声明String类，所以不用强转了
            System.out.println(str);
        }

        //泛型的补偿机制，补偿缺失的强转
        Class clazz = "aa".getClass();
        clazz.getName();
    }
}
