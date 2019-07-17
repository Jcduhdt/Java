package cn.itcast.p2.bean;

import java.util.Objects;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() &&
                Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    /* @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if (!(obj instanceof Person))//健壮性判断，判断传进的Object是否可转成Person
            throw new RuntimeException(" ");
        Person p = (Person)obj;
        return super.equals(obj);
    }*/


    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person p){
//        Person p = (Person)obj;
        int temp = this.age-p.age;
        return temp==0?this.name.compareTo(p.name):temp;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person: "+getName()+":"+getAge();
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
