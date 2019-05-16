/**
 * time:2019-05-16
 * author：Zhang Xiong
 * 关键字：static
 * 特点：
 * 1.static是一个修饰符，用于修饰成员
 * 2.static修饰的成员被所有对象共享
 * 3.static优先于对象存在,因为static的成员随着类的加载就已经存在
 * 4.static修饰的成员多了一种调用方式，就可以直接被类名所调用。类名.静态成员
 * 5.static修饰的数据是共享数据，对象中的存储的是特有数据
 */public class StaticDemo
{
    public static void main(String[] args)
    {
        Person_3 p = new Person_3();
        p.name = "Biu";
        p.show();
        System.out.println(p.country);
        System.out.println(Person_3.country);
    }
}

class Person_3
{
    String name;
    static String country = "CN";//静态共享，可直接被类名调用
    public void show()
    {
        System.out.println(country+":"+name);
    }
}
