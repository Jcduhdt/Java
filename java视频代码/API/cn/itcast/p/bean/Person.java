package cn.itcast.p.bean;

/**
 * @version V12.0.1 2019-7-11
 * @author Zhang Xiong
 */


/*
 * alt+insert
 * 美滋滋
 */
public class Person /*extends Object*/ implements Comparable
{
    private String name;
    private int age;

    public Person()
    {
        super();
    }
    public Person(String name,int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode() {
        System.out.println(this+".....hashCode");
        return name.hashCode()+age;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println(this + "...."+obj);
        Person p = (Person)obj;
        return this.name.equals(p.name) && this.age == p.age;
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

    public String toString(){
        return name + ":" + age;
    }

    @Override
    public int compareTo(Object o)
    {
        Person p = (Person)o;

        //先姓名再年龄
        int temp = this.name.compareTo(p.name);
        return temp == 0 ? this.age-p.age:temp;

        //先年龄再姓名
        /*int temp = this.age-p.age;
        return temp == 0 ? this.name.compareTo(p.name):temp;*/
        /*if (this.age>p.age)
            return 1;
        if (this.age<p.age)
            return -1;
        else{
            return this.name.compareTo(p.name);
        }*/
    }
}
