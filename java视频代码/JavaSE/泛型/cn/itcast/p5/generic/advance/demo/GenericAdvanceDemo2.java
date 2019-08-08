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

public class GenericAdvanceDemo2 {
    public static void main(String[] args) {
        ArrayList<Worker> al = new ArrayList<Worker>();

        al.add(new Worker("abc",30));
        al.add(new Worker("abc4",34));

        ArrayList<Student> al2 = new ArrayList<Student>();
        al2.add(new Student("stu1",21));
        al2.add(new Student("stu2",22));

        ArrayList<Person> al3 = new ArrayList<Person>();
        al3.add(new Person("per1",21));
        al3.add(new Person("per2",22));

        printCollection(al);
        printCollection(al2);
        printCollection(al3);
    }

    /**
     * 打印自己定义的类的集合元素
     * 迭代并打印集合中的元素
     * 可以对类型进行限定
     * ? extends E:接收E类型或者E类型的子类型对象。上限！
     *
     * ? super E：接收E类型或者E类型的父类型对象。下限！
     * @param al
     */
    public static void printCollection(Collection<? extends Person> al) {  //流弊！！！ 只接受Person或者Person的子类
        //Collection<Animal> al = new ArrayList<Dog>() 左右泛型不匹配 有问题
        //泛型的通配符?，未知类型
        Iterator<? extends Person> it = al.iterator();
        //Iterator也进行限定 只用?也行，不过似乎又有什么原因

        while (it.hasNext()){
            /*? str = it.next();
            System.out.println(str);*/
            Person p = it.next();
            System.out.println(p.getName()+":"+p.getAge());
        }
    }

    /*public static void printCollection(Collection<? super Student> al){
        Iterator<? super Student> it = al.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }*/
}
