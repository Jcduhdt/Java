package cn.itcast.p3.collection.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @version V12.0.1 2019-7-10
 * @author Zhang Xiong
 */

public class IteratorDemo
{
    public static void main(String[] args)
    {
        Collection coll = new ArrayList();

        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");
        coll.add("abc4");
        System.out.println(coll);
        //使用了Collection中de iterator()方法，调用集合中的迭代器方法，是为了获取集合中的迭代器对象
/*        Iterator it = coll.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());//这种方法，用到最后了，it（迭代器）还在，占用内存空间
            //为了减少空间使用下一种for方法
            //循环结束后，迭代器还能用
        }*/

        for (Iterator it = coll.iterator(); it.hasNext(); )//for循环结束，迭代器也不在了
        {
            System.out.println(it.next());
        }
/*        System.out.println(it.hasNext());//是否有下一个元素
        System.out.println(it.next());//取下一个元素  指针
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());//java.util.NoSuchElementException*/
    }
}
