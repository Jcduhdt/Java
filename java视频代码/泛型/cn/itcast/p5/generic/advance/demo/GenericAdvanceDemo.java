package cn.itcast.p5.generic.advance.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @version V12.0.1 2019-7-17
 * @author Zhang Xiong
 */

public class GenericAdvanceDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();

        al.add("abc");
        al.add("nba");

        ArrayList<Integer> al2 = new ArrayList<Integer>();
        al2.add(5);
        al2.add(34);

        printCollection(al);
        printCollection(al2);
    }

    /**
     * 迭代并打印集合中的元素
     * @param al
     */
    public static void printCollection(Collection<?> al) {
        //泛型的通配符?，未知类型
        Iterator<?> it = al.iterator();

        while (it.hasNext()){
            /*? str = it.next();
            System.out.println(str);*/

            System.out.println(it.next());
        }
    }

/*
        这也可以，不过相比?有点麻烦，而且在有返回值的时候似乎有点问题
        public static <T> void printCollection(Collection<T> al) {
        //泛型的通配符?，未知类型
        Iterator<T> it = al.iterator();

        while (it.hasNext()){
            T str = it.next();
            System.out.println(str);
        }
    }*/
}
