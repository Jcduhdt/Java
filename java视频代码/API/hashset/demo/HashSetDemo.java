package cn.itcast.p4.hashset.demo;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo
{
    public static void main(String[] args)
    {
        HashSet hs = new HashSet();

        hs.add("haha");
        hs.add("hehe");
        hs.add("xixi");
        hs.add("hihi");
        hs.add("hehe");
        hs.add("xixi");
        //无序保证不重复


        Iterator it = hs.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}
