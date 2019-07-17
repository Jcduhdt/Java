package cn.itcast.p5.generic.advance.demo;

import cn.itcast.p2.bean.Person;
import cn.itcast.p2.bean.Student;
import cn.itcast.p2.bean.Worker;

import java.util.*;

/**
 * @version V12.0.1 2019-7-17
 * @author Zhang Xiong
 */

public class GenericAdvanceDemo5 {
    public static void main(String[] args) {

        ArrayList<Person> al1 = new ArrayList<Person>();
        al1.add(new Person("per1",21));
        al1.add(new Person("per2",22));

        ArrayList<Person> al2 = new ArrayList<Person>();
        al2.add(new Person("per2222",21));
        al2.add(new Person("per22222222",22));

        ArrayList<String> al4 = new ArrayList<String>();
        al4.add("abcdsff");
        al4.add("abc");

        al1.containsAll(al4);
        "abc".equals(new Person("asda",25));
    }
    public static void printCollection(Collection<?> al) {
        Iterator<?> it = al.iterator();

        while (it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
}

class MyCollection2<E>{
    public boolean containsAll(Collection<?> coll){
        return true;
    }
}