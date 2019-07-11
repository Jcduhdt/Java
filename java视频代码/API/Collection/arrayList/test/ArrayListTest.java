package cn.itcast.p3.arrayList.test;

import cn.itcast.p.bean.Person;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @version V12.0.1 2019-7-11
 * @author Zhang Xiong
 */

public class ArrayListTest
{
    public static void main(String[] args)
    {
        ArrayList al = new ArrayList();
        al.add(new Person("lisi1",21));
        al.add(new Person("lisi2",22));
        al.add(new Person("lisi3",23));
        al.add(new Person("lisi4",24));

        Iterator it = al.iterator();
        while(it.hasNext())
        {
            //.的优先级高，必须加括号在用getName之前强转
            /*System.out.println(((Person)it.next()).getName()+"::"+((Person) it.next()).getAge());
            //用了两个next,结果就成了lisi1::22 lisi3::24*/
            Person p = (Person)it.next();
            System.out.println(p.getName()+"--"+p.getAge());
        }
        //al.add(5);//1.5以前必须al.add(new Integer(5)); 现在可以不用，因为自动装箱
        //基本数据类型赋值给了引用数据类型才装箱
    }
}
