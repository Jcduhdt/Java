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
 *
 * 成员变量和静态变量的区别（静态前面省略类名，非静态省略this）
 * 1.两个变量的生命周期不同
 *   成员变量随着对象的创建而存在，对象回收而释放
 *   静态变量随着类的加载而存在，随着类的消失而消失
 * 2.调用方式不同
 *   成员变量只能被对象调用
 *   静态变量可以被对象调用，还可以被类名调用
 * 3.别名不同
 *   成员变量也成为实例变量
 *   静态变量成为类变量
 * 4.数据存储位置不同
 *   成员变量数据存储在堆内存的对象中，所以也叫对象的特有数据
 *   静态变量数据存储在方法区（的静态区），所以也叫对象的共享数据
 *
 * 静态使用的注意事项：
 * 1.静态方法只能访问静态成员 非静态既可访问静态又可访问非静态
 * 2.静态方法中不可以使用this或者super关键字
 * 3.主函数是静态的，调用本类中的方法就是创建一个对象调用
 */
public class StaticDemo
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
    String name;//成员变量，实例变量
    static String country = "CN";// 静态变量 类变量静态共享，可直接被类名调用
    public void show()
    {
        System.out.println(country+":"+name);
    }
}
