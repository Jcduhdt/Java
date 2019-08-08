/**
 * @version V12.0.1 2019-06-03
 * @author Zhang Xiong
 */

/*
 * 多态时成员的特点
 * 1.成员变量
 *      编译时：参考引用型变量所属的类中是否有调用的成员变量，有，编译通过，没有，编译失败
 *      运行时：参考引用型变量所属的类中是否有调用的成员变量，并运行该所属类中的成员变量
 *      简单说：编译和运行都参考等号的左边
 *      作为了解
 * 2.成员函数(非静态)
 *      自己理解：非静态绑定的是对象
 *      编译时：参考引用型变量所属的类中是否有调用的函数，有，编译通过，没有，编译失败
 *      运行时：参考的是对象所属的类中是否有调用的函数
 *      简单说：编译看左边，运行看右边
 * 3.静态函数
 *      自己理解：静态绑定的是类
 *      编译时：参考引用型变量所属的类中是否有调用的成员变量，有，编译通过，没有，编译失败
 *      运行时：参考引用型变量所属的类中是否有调用的成员变量，并运行该所属类中的成员变量
 *      简单说：编译和运行都参考等号的左边
 *      其实对于静态方法，是不需要对象的，直接用类名调用即可
 */

class Fu
{
    int num = 3;
    void show()
    {
        System.out.println("fu show");
    }
    static void method()
    {
        System.out.println("fu static method");
    }
}

class Zi extends Fu
{
    int num = 4;
    void show()
    {
        System.out.println("zi show");
    }
    static void method()
    {
        System.out.println("zi static method");
    }
}
public class DuoTaiDemo2
{
    public static void main(String[] args)
    {
        Fu f = new Zi();
        System.out.println(f.num);
        f.show();
        f.method();

        Zi z = new Zi();
        System.out.println(z.num);
    }
}
