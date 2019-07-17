package cn.itcast.p5.generic.advance.demo;

import cn.itcast.p2.bean.Person;
import cn.itcast.p2.bean.Student;
import cn.itcast.p2.bean.Worker;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @version V12.0.1 2019-7-17
 * @author Zhang Xiong
 */

public class GenericAdvanceDemo4 {
    public static void main(String[] args) {

        TreeSet<Person> al1 = new TreeSet<Person>(new CompByName());
        al1.add(new Person("per1",36));
        al1.add(new Person("per2",28));
        al1.add(new Person("per2",30));

        TreeSet<Student> al2 = new TreeSet<Student>(new CompByStuName());
        al2.add(new Student("stu1",11));
        al2.add(new Student("stu7",16));
        al2.add(new Student("stu2",20));

        TreeSet<Worker> al3 = new TreeSet<Worker>(new CompByWorkerName());
        al3.add(new Worker("abc",30));
        al3.add(new Worker("abc4",34));

        TreeSet<String> al4 = new TreeSet<String>();
        al4.add("abcdsff");
//        al1.addAll(al4);//错误，类型不匹配

//        al1.addAll(al2);
//        System.out.println(al1.size());

        Iterator<Student> it = al2.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}


/*
 * class TreeSet<E>
 * {
 *      Tree(Comparator<? super E> comp);
 * }
 * 什么时候用下限呢？通常对集合中的元素进行取出操作时，可以使用下限
 */
class CompByName implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        int temp = o1.getName().compareTo(o2.getName());
        return temp==0?o1.getAge()-o2.getAge():temp;
    }
}

class CompByStuName implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        int temp = o1.getName().compareTo(o2.getName());
        return temp==0?o1.getAge()-o2.getAge():temp;
    }
}

class CompByWorkerName implements Comparator<Worker>{
    @Override
    public int compare(Worker o1, Worker o2) {
        int temp = o1.getName().compareTo(o2.getName());
        return temp==0?o1.getAge()-o2.getAge():temp;
    }
}
