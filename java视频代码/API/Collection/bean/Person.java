package cn.itcast.p.bean;

/**
 * @version V12.0.1 2019-7-11
 * @author Zhang Xiong
 */


/*
 * alt+insert
 * 美滋滋
 */
public class Person
{
    private String name;
    private int age;

    public Person(String name,int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
