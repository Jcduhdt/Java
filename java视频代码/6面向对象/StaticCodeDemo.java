/**
 * time:2019-05-19
 * author：Zhang Xiong
 *
 * 静态代码块
 * 随着类的加载而执行，而且只执行一次
 * 作用：
 *      用于给类进行初始化
 */
public class StaticCodeDemo
{
    static
    {
        System.out.println("a");
    }
    public static void main(String[] args)
    {
        StaticCode.show();
        //new StaticCode().show();
        //new StaticCode().show();//static块就显示一次，因为就加载一次，随类而存在
        Person_5 p1 = new Person_5();
        p1.speak();
        Person_5 p2 = new Person_5("嘉佳");
        p2.speak();
    }
}

class StaticCode
{
    static int num;
    static
    {
        num = 10;
        num *= 3;
        System.out.println("hahaha");
    }

    StaticCode(){}
    static void show()
    {
        System.out.println(num);
    }
}

class Person_5
{
    private String name;

    {//构造代码块，与对象有关 可以给所有对象进行初始化 加了static就与类有关
        System.out.println("person run");
        cry();
    }
    Person_5()//构造函数给对应的对象进行针对性的初始化
    {
        name = "baby";
    }
    Person_5(String name)
    {
        this.name = name;
    }
    public void cry()
    {
        System.out.println("哇哇");
    }
    public void speak()
    {
        System.out.println("name:"+name);
    }
}