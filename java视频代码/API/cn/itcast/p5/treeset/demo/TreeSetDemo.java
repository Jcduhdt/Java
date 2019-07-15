package cn.itcast.p5.treeset.demo;

import cn.itcast.p.bean.Person;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @version V12.0.1 2019-7-15
 * @author Zhang Xiong
 */

public class TreeSetDemo
{
    public static void main(String[] args)
    {
       //demo1();
       demo2();
    }

    public static void demo2()
    {
        TreeSet ts = new TreeSet(new ComparatorByName());

        /*
         * 因为treeset要排序，所以需要对存入的Person对象进行排序
         * Person就需要实现Comparable接口并覆写compareTo方法
         * 以Person对象年龄进行从小到大排序
         * treeset判断元素唯一性的方式：就是根据比较方法的返回结果是否是0，是0，就是相同元素，不存
         */
        ts.add(new Person("zhangsan",28));
        ts.add(new Person("wangwu",23));
        ts.add(new Person("lisi",21));
        ts.add(new Person("zhouqi",23));
        ts.add(new Person("zhaoliu",25));
        ts.add(new Person("zhaoliu",25));

        Iterator it = ts.iterator();

        while (it.hasNext())
        {
            Person p = (Person)it.next();
            System.out.println(p.getName() + ":" + p.getAge());
        }
    }

    public static void demo1()
    {
        TreeSet ts = new TreeSet();

        ts.add("abc");
        ts.add("zaa");
        ts.add("aa");
        ts.add("nba");
        ts.add("cba");

        Iterator it = ts.iterator();

        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
