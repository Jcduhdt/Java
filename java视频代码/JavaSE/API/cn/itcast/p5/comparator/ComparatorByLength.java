package cn.itcast.p5.comparator;

import java.util.Comparator;
/**
 * @version V12.0.1 2019-7-15
 * @author Zhang Xiong
 */
public class ComparatorByLength implements Comparator
{
    public int compare(Object o1,Object o2)
    {
        String s1 = (String)o1;
        String s2 = (String)o2;

        int temp = s1.length()-s2.length();

        return temp==0?s1.compareTo(s2):temp;
    }
}
