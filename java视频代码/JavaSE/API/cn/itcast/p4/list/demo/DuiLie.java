package cn.itcast.p4.list.demo;

import java.util.LinkedList;

public class DuiLie
{
    private LinkedList link;
    public  DuiLie()//构造函数与类名要相同啊。。
    {
        link = new LinkedList();
    }

    /**
     * 队列添加元素的功能
     * @param obj
     */
    public void myAdd(Object obj)
    {
        link.addLast(obj);
    }

    public Object myGet()
    {
        return link.removeFirst();
    }

    public boolean isNull()
    {
        return link.isEmpty();
    }
}
