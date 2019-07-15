package cn.itcast.p5.treeset.demo;

import cn.itcast.p5.comparator.ComparatorByLength;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @version V12.0.1 2019-7-15
 * @author Zhang Xiong
 */

/*
 * 对字符串进行长度排序
 */

public class TreeSetTest
{
    public static void main(String[] args)
    {
        TreeSet ts = new TreeSet(new ComparatorByLength());

        ts.add("aaaaa");
        ts.add("zz");
        ts.add("nbaq");
        ts.add("cba");
        ts.add("abc");

        Iterator it = ts.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
