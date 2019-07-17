package cn.itcast.p5.generic.advance.demo;

import cn.itcast.p2.bean.Person;
import cn.itcast.p2.bean.Student;
import cn.itcast.p2.bean.Worker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @version V12.0.1 2019-7-17
 * @author Zhang Xiong
 */

public class GenericAdvanceDemo3 {
    public static void main(String[] args) {

        ArrayList<Person> al1 = new ArrayList<Person>();
        al1.add(new Person("per1",21));
        al1.add(new Person("per2",22));

        ArrayList<Student> al2 = new ArrayList<Student>();
        al2.add(new Student("stu1",21));
        al2.add(new Student("stu2",22));

        ArrayList<Worker> al3 = new ArrayList<Worker>();
        al3.add(new Worker("abc",30));
        al3.add(new Worker("abc4",34));

        ArrayList<String> al4 = new ArrayList<String>();
        al4.add("abcdsff");
//        al1.addAll(al4);//错误，类型不匹配

        al1.addAll(al2);
        System.out.println(al1.size());



//        printCollection(al1);
//        printCollection(al2);
//        printCollection(al3);
    }
}


/*
 * 一般在存储元素的时候都是用上限，因为这样取出都是按照上限类型来运算的，不会出现安全隐患
 */
class MyCollection<E>{
    public void add(E e){

    }
    public void addAll(MyCollection<E> e){

    }
}
