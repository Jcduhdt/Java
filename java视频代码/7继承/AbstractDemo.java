/**
 * @vision V12.0.1 2019-6-1
 * @author Zhang Xiong
 */

/*
 * 抽象类：
 * 抽象：笼统，模糊，看不懂，不具体
 * 特点：
 * 1.方法只有声明，没有实现时，该方法就是抽象方法，需要被abstract修饰
 *   抽象方法必须定义在抽象类中，该类必须也被abstract修饰
 * 2.抽象类不可以被实例化。因为调用抽象方法没意义
 * 3.抽象类必须有其子类覆盖了所有抽象方法后，该子类才能实例化，否则这个子类还是抽象类
 *
 * 问题：
 * 1.抽象类中有构造函数吗？
 *      有，用于给子类对象进行初始化
 * 2.抽象类可以不定义抽象方法吗？
 *      可以的，但是少见，目的就是不让该类创建对象，AWT的适配器对象就是这种类
 *      通常这个类中的方法有方法体，但却没有内容
 *      abstract class Demo
 *      {
 *          void show1();没有方法体
 *          void show2(){};有方法体，没内容
 * 3.抽象关键字不可以和哪些关键字共存？
 *      private 不行，因为抽象方法要被覆盖，私有了就不能被覆盖
 *      static 不行，因为抽象方法被调用毫无意义
 *      final 不行，因为子类要覆盖，final不允许建子类，不允许被篡改
 * 4.抽象类和一般类的区别
 *      相同点：抽象类和一般类都是用来描述事物的，都在内部定义了成员
 *      不同：一般类有足够的信息描述事物，抽象类描述事物的信息有可能不足
 *            一般类中不能定义抽象方法，只能定义非抽象方法；抽象类中可定义抽象方法，同时也可定义非抽象方法
 *            一般类可被实例化，抽象类不可以被实例化
 * 5.抽象类一定是个父类吗？
 *      必须的，因为需要子类覆盖其方法后才可对子类实例化
 */

abstract class Demo
{
    abstract /*抽象*/void show();
}
class DemoA extends Demo
{
    void show()
    {
        System.out.println("demoa show");
    }
}

class DemoB extends Demo
{
    void show()
    {
        System.out.println("demob show");
    }
}


abstract class Quan
{
    abstract void houjiao();
}
class Dog extends Quan
{
    void houjiao()
    {
        System.out.println("汪汪");
    }
}

class Wolf extends Quan
{
    void houjiao()
    {
        System.out.println("嗷嗷");
    }
}
public class AbstractDemo
{
    public static void main(String[] args)
    {

    }
}
