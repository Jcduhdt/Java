package cn.itcast.p4.list.demo;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * @version V12.0.1 2019-7-11
 * @author Zhang Xiong
 */

/*
 * 枚举  Enumeration
 * 此接口的功能与 Iterator 接口的功能是重复的。
 * 此外，Iterator 接口添加了一个可选的移除操作，并使用较短的方法名。
 * 新的实现应该优先考虑使用 Iterator 接口而不是 Enumeration 接口。
 */
public class VectorDemo
{
    public static void main(String[] args)
    {
        Vector v = new Vector();

        v.addElement("abc1");
        v.addElement("abc2");
        v.addElement("abc3");
        v.addElement("abc4");

        Enumeration en = v.elements();
        while(en.hasMoreElements())
        {
            System.out.println("nextelement: " + en.nextElement());
        }

        Iterator it = v.iterator();

        while(it.hasNext())
        {
            System.out.println("next: " + it.next());
        }
    }
}
