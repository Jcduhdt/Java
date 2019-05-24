/**
 * 继承
 * @version V12.0.1 2019-05-22
 * @author Zhang Xiong
 */
/*
 * 继承的好处：
 *      1.提高代码复用性
 *      2.让类与类之间产生了关系，给第三个特征多态提供了前提
 *
 * Java中支持单继承，不直接支持多继承，但对C++中的多继承机制进行改良
 * 单继承：一个子类只能有一个直接父类
 * 多继承：一个子类可以有多个直接父类（java中不允许，进行改良）
 *         不直接支持，因为多个父类中有相同成员，会产生调用的不确定性
 *         在java中通过"多实现"的方式来体现
 * java支持多层（多重）继承：C继承B，B集成A
 * 就会出现继承体系，当要使用一个继承体系时
 * 1.查看该体系中的顶层类，来哦姐该体系的基本功能
 * 2.创建体系中的最子类对象，完成功能的使用
 *
 * 什么时候定义继承呢？
 * 当类与类之间存在所属关系的时候，就定义继承，xxx 是 yyy中的一种，xxx extends yyy
 * 所属关系：is-a关系
 *
 */

/*
class A
{
    void show()
    {
        System.out.println("a");
    }
}
class B
{
    void show()
    {
        System.out.println("a");
    }
}
class C extends A,B{}
*/
class Person
{
    String name;
    int age;
}
class Student extends /*继承*/ Person
{
//    String name;
//    int age;
    void study()
    {
        System.out.println("student study");
    }
}

class worker extends /*继承*/ Person
{
//    String name;
//    int age;
    void work()
    {
        System.out.println("worker work");
    }
}

public class ExtendsDemo
{
    public static void main(String[] args)
    {
        Student s = new Student();
        s.name = "zhang";
        s.age = 23;
        s.study();
        System.out.println("Hello World!");
    }
}
