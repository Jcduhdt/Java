/**
 * @vision V12.0.1 2019-6-2
 * @author Zhang Xiong
 */
/*
abstract class AbsDemo
{
    abstract void show1();
    abstract void show2();
}
*/
/*
 * 当一种抽象类中的方法都是抽象的时候，这时可以将该抽象类用
 * 另一种形式定义和表示，就是接口 interface
 * 接口是对外暴露的规则
 * 接口是程序的功能扩展
 * 接口的出现降低耦合性
 * 接口可以用来多实现
 */

/*
 * 定义接口使用的关键字不是class，是interface
 * 对于接口当中常见的成员，而且这些成员都有固定的修饰符
 * 1.全局常量：public static final
 * 2.抽象方法：public abstract
 * 由此得出结论，接口中的成员都是公共权限
 */
interface InterDemo
{
    public static final int NUM = 4;
    public abstract void show1();
    public abstract void show2();

    /*
    可以写成这样，把前面那些修饰符省略，因为接口是固定修饰符
    但是这样阅读性极差，虽然编译能通过，但是很难理解
    int NUM = 4;
    void show1();
    void show2();
     */
}
//类与类之间是继承关系，类与接口之间是实现关系
/*
 * 接口不可以实例化
 * 只能由实现了接口的子类并覆盖了接口中所有的抽象方法后
 * 该子类才可以实例化，否则这个子类就是一个抽象类
 */
class DemoImpl implements /*实现*/InterDemo
{
    public void show1(){}
    public void show2(){}
}


/*
 * 在java中不直接支持多继承，因为会出现调用的不确定性
 * 所以java将多继承机制进行了改良，在java中变成了多实现
 * 一个类可以实现多个接口
 */
interface A
{
    public abstract void show();
}
interface Z
{
    public abstract void show();
}
class Test implements A,Z
{
    public void show()
    {

    }
}

/*
 * 一个类在继承另一个类的同时，还可以实现多个接口
 */
class Q
{
    public void method(){}
}
class Test2 extends Q implements A,Z
{
    public void show(){};
}
/*
 * 接口的出现避免了单继承的局限性
 */

interface CC
{
    public abstract void show();
}
interface MM
{
    public abstract void method();
}
interface QQ extends CC,MM//接口与接口之间是继承关系，而且接口可以多继承
{
    void function();
}
class WW implements QQ
{
    //覆盖三个方法
    public void show(){}
    public void method(){}
    public void function(){}
}
public class InterfaceDemo
{
    public static void main(String[] args)
    {
        DemoImpl d = new DemoImpl();
        System.out.println(d.NUM);
        System.out.println(DemoImpl.NUM);
        System.out.println(InterDemo.NUM);

        Test t = new Test();
        t.show();//没有方法体，所以没有不确定性
    }
}
