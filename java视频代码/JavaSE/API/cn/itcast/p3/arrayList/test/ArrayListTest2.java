package cn.itcast.p3.arrayList.test;

import cn.itcast.p.bean.Person;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version V12.0.1 2019-7-15
 * @author Zhang Xiong
 */

public class ArrayListTest2
{
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();
        al.add("abc1");
        al.add("abc2");
        al.add("abc2");
        al.add("abc1");
        al.add("abc");
        System.out.println(al);

        al = getSingleElement(al);
        System.out.println(al);

        ArrayList al_p = new ArrayList();
        al_p.add(new Person("lisi1",21));
        al_p.add(new Person("lisi2",22));
        al_p.add(new Person("lisi3",23));
        al_p.add(new Person("lisi4",24));
        al_p.add(new Person("lisi2",22));
        al_p.add(new Person("lisi3",23));
        System.out.println(al_p);
        al_p = getSingleElement(al_p);
        System.out.println(al_p);

    }

    public static ArrayList getSingleElement(ArrayList al)
    {
        // 1.定义一个临时容器
        ArrayList temp = new ArrayList();

        // 2.迭代al集合
        Iterator it = al.iterator();
        while(it.hasNext())
        {
            Object obj = it.next();
            // 3.判断被迭代到的元素是否在临时容器存在
            if (!temp.contains(obj))//contains仅仅判断equals方法
            {
                temp.add(obj);
            }
        }
        return temp;
    }
}
