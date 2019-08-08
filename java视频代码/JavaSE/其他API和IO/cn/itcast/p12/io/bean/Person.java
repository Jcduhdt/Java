package cn.itcast.p12.io.bean;

import java.io.Serializable;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-24
 */

/*
 * Serializable
 * 用于给被序列化的类加入ID号
 * 用于判断类和对象是否是同一个版本
 */

public class Person implements Serializable /*标记接口，啥都不用覆盖*/{

    /*
     * transient：非静态数据不想被序列化可以使用这个关键字修饰
     */

    private static final long serialVersionUID = -4817851328342359832L;
    private transient String name;//transient短暂的暂时的 关键字 不会被序列化
    private static int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
