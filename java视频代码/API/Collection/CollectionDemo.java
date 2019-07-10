package cn.itcase.p3.collextion.demo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @version V12.0.1 2019-7-10
 * @author Zhang Xiong
 */

/*
集合类的由来：
    对象用于封装特有数据，对象多了需要存储，如果对象的个数不确定
    就使用集合容器进行存储

集合特点：
    1.用于存储对象的容器
    2.集合的长度是可变的
    3.集合中不可以存储基本数据类型

集合容器因为内部的数据结构不同有多种具体容器
不断的向上抽取，就形成了集合框架

框架的顶层Collection接口：
Collection的常见方法：
1.添加
    boolean add(Object obj);返回boolean是返回添加成功与否
    boolean addAll(Collection coll);
2.删除
    boolean remove(Object obj);
    boolean removeAll(Collection coll);
    void clear();
3.判断
    boolean contains(Object obj);
    boolean contains(Collection coll);
    boolean ifEmpty();判断集合中是否有元素
4.获取
    int size();返回此 collection 中的元素数
    Iterator iterator();取出元素的方式，迭代器
    该对象必须依赖具体容器，因为每一个容器的数据结构都不同
    所以该迭代器对象是在容器中进行内部实现的
    对于使用容器者而言，具体的实现不重要，只要通过容器获取到该实现的迭代器的对象即可
    也就是iterator方法
5.其他
    boolean retainAll(Collection coll);仅保留此 collection 中那些也包含在指定 collection 的元素,取交集
    Object[] toArray();将集合转成数组
 */
public class CollectionDemo
{
    public static void main(String[] args)
    {
        Collection coll = new ArrayList();
        show(coll);

        Collection c1 = new ArrayList();
        Collection c2 = new ArrayList();
        show(c1,c2);
    }

    public static void show(Collection c1,Collection c2)
    {
        //给c1添加元素
        c1.add("abc1");
        c1.add("abc2");
        c1.add("abc3");
        c1.add("abc4");

        //给c2添加元素
        c2.add("abc5");
        c2.add("abc6");
        c2.add("abc7");

        System.out.println("c1:" + c1);
        System.out.println("c2:" + c2);

        //演示addAll

        c1.addAll(c2);//将c2中的元素添加到c1中
        System.out.println("addAll:"+c1);

        //演示removeAll
        boolean b = c1.removeAll(c2);//将两个集合中相同的元素从调用removeAll的集合中删除
        System.out.println("removeAll:"+b);
        System.out.println("c1:"+c1);
        //演示containAll
        boolean b1 = c1.containsAll(c2);
        System.out.println("containsAll:"+b1);
        System.out.println("c1:"+c1);

        //演示retainAll
        boolean b2 = c1.retainAll(c2);//取交集，保留和指定的集合相同的元素，而删除不同的元素
        //和removeAll功能相反
        System.out.println("retainAll:"+c1);
    }
    public static void show(Collection coll)
    {
        //1.添加元素 add
        coll.add("abc1");
        coll.add("abc2");
        coll.add("abc3");

        System.out.println(coll);

        //2.删除元素 remove
        coll.remove("abc2");//会改变集合长度

        //清空集合
        coll.clear();

        System.out.println(coll.contains("abc3"));
        System.out.println(coll);
    }
}
