package cn.itcast.p2.bean;

/**
 * @version V12.0.1 2019-7-16
 * @author Zhang Xiong
 */

public class Student extends Person
{
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Student: "+getName()+":"+getAge();
    }
}
