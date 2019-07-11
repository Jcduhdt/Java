package cn.itcase.p4.list.demo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @version V12.0.1 2019-7-11
 * @author Zhang Xiong
 */

public class LinkedLIstDemo
{
    public static void main(String[] args)
    {
        LinkedList link = new LinkedList();

        link.addFirst("abc1");//从头添加
        link.addFirst("abc2");
        link.addFirst("abc3");
        link.addFirst("abc4");

        System.out.println(link);
/*        System.out.println(link.getFirst());//获取第一个元素但不删除
        System.out.println(link.getFirst());*/

/*        System.out.println(link.removeFirst());//获取第一个元素但会删除
        System.out.println(link.removeFirst());*/

        while(!link.isEmpty())
        {
            System.out.println(link.removeLast());
        }
        System.out.println(link);

/*        Iterator it = link.listIterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }*/
    }
}
