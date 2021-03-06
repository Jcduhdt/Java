/**
 * @version V12.0.1 2019-05-24
 * @author Zhang Xiong
 */

/*
 * 子父类中的构造函数的特点：
 * 在子类构造对象时，发现，访问子类构造函数时，父类也运行了
 * 为什么呢？
 * 原因是：在子类的构造函数中第一行有一个默认的隐式语句 super();
 *
 * 子类的实例化过程，子类中所有的构造函数默认都会访问父类中的空参数构造函数
 *
 * 为什么子类实例化的时候要访问父类中的构造函数呢？
 * 那是因为子类继承了父类，获取到了父类中内容（属性），所以在使用父类内容之前
 * 要先看父类是如何对自己的内容进行初始化的
 * 所以子类在构造对象时，必须访问父类中的构造函数
 * 为什么完成这个必须动作，就在子类的构造函数中加入了super()语句
 * 如果父类中没有定义空参构造函数，那么子类的构造函数必须用super明确调用父类中哪个构造函数
 * 同时子类构造函数中如果使用this调用本类构造函数时
 * 那么super就没有了，因为super和this都只能定义在第一行，所以只能有一个
 * 但是可以保证的是，子类中肯定会有其他构造函数访问父类构造函数
 *
 * 注意：super语句必须要定义在子类构造函数的第一行，因为父类的初始化动作要先完成
 *
 */
class Fu2
{
    int num;
    Fu2()
    {
        num = 10;
        System.out.println("A fu2 run");
    }
    Fu2(int x)
    {
        System.out.println("B fu2 run..." + x);
    }
}

class Zi2
{
    int num;
    Zi2()
    {
        // super();调用的就是父类中的空参数的构造函数
        System.out.println("C zi2 run " + num);
    }
    Zi2(int x)
    {
        // super();调用的就是父类中的空参数的构造函数
        //父类没有空参构造函数时，报错  不然就编写super(85);明确调用带参构造函数
        System.out.println("D zi2 run..." + x);
    }
}

public class ExtendsDemo4
{
    public static void main(String[] args)
    {
        new Zi2(5);
    }
}

class Demo //extends Object //object 是上帝，因为面向对象语言，所有类的祖宗
    //写没写extends Object 它都有这个
{
    /*
    Demo()
    {
        super();
        return;
     }
     */
}