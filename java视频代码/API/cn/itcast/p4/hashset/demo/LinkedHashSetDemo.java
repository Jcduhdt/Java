package cn.itcast.p4.hashset.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @version V12.0.1 2019-7-15
 * @author Zhang Xiong
 */

public class LinkedHashSetDemo
{
    public static void main(String[] args)
    {
        HashSet hs = new LinkedHashSet();//保证唯一且有序的情况，链表加哈希set


        hs.add("haha");
        hs.add("hehe");
        hs.add("xixi");
        hs.add("hihi");
//        hs.add("hehe");
//        hs.add("xixi");
        //无序保证不重复


        Iterator it = hs.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
