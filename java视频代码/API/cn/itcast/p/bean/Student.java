package cn.itcast.p.bean;

/**
 * @version V12.0.1 2019-7-11
 * @author Zhang Xiong
 */


/*
 * alt+insert
 * 美滋滋
 */
public class Student extends Person
{
    public Student()
    {
        super();
    }
    public Student(String name, int age) {
        super(name, age);
    }


    public String toString(){
        return "Student:"+getName() + ":" + getAge();
    }
}
