/**
 * @version V12.0.1 2019-05-24
 * @author Zhang Xiong
 */
//成员函数
/*
 * 当子父类中出现成员函数一模一样的情况，会运行子类的函数
 * 这种现象，称为覆盖操作，这时函数在子父类中的特性
 * 函数两个特性：
 *      1.重载：同一类中，overload
 *      2.覆盖：子类中，覆盖也成为重写，覆写 override
 *
 * 覆盖注意事项：
 * 1.子类方法覆盖父类方法时，子类权限必须要大于等于父类权限 public private protected null static
 * 2.静态只能覆盖静态，或被静态覆盖
 *
 * 什么时候使用覆盖操作
 * 当对一个类进行子类的扩展时，子类需要保留父类的功能声明
 * 但是要定义子类中该功能的特有内容时，救使用覆盖操作完成
 */
class Fu1
{
    public static void show()
    {
        System.out.println("Fu1 show run");
    }
}

class Zi1 extends Fu1
{
    public static void show()
    {
        System.out.println("Zi1 show run");
    }
}

class Phone
{
    void call(){}
    void show()
    {
        System.out.println("number");
    }
}

class NewPhone extends Phone
{
    void show()
    {
        System.out.println("name");
        System.out.println("pic");
        super.show();
    }
}
public class ExtendsDemo3
{
    public static void main(String[] args)
    {
        Zi1 z = new Zi1();
        z.show();

        NewPhone p = new NewPhone();
        p.show();
    }
}
