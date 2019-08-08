package cn.itcast.p3.comparator;

import cn.itcast.p2.bean.Person;

import java.util.Comparator;

/**
 * @version V12.0.1 2019-7-16
 * @author Zhang Xiong
 */

public class ComparatorByName extends Object implements Comparator<Person>
{
    @Override
    public int compare(Person o1, Person o2) {
        int temp = o1.getName().compareTo(o2.getName());

        return temp==0?o1.getAge()-o2.getAge():temp;
    }
}
