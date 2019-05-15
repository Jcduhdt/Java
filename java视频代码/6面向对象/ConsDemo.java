/**
 * time:2019-05-15
 * author：Zhang Xiong
 * 构造函数：构建创造对象时调用的函数，有return（return是函数结束的标志），但不返回类型。
 *           与类名相同
 * 作用：可以给对象进行初始化  进栈 弹栈
 * 创建对象都必须要通过构造函数初始化
 * 一个类中如果没有定义过构造函数，那么该类中会有默认的空参数构造函数
 * 如果在类中定义了制定的构造函数，那么类中默认的构造函数就没有了
 * 一般函数与构造函数的区别
 * 构造函数：对象创建时就会调用与之对应的构造函数，对对象初始化
 *           对象创建时，会调用只调用一次
 * 一般函数：对象创建后，需要函数功能时才调用
 *           被调用且可被调用多次
 * 可通过函数的首字母大小写来区分，一般函数的首个单词的首字母小写
 * 什么时候定义构造函数：
 * 在描述事物时，该事物已存在就具备的一些内容，这些内容都定义在构造函数中
 *
 */
public class ConsDemo
{
    public static void main(String[] args)
    {
        Person_1 p = new Person_1();//构造函数：构建创建对象时调用的函数
        p.speak();
        Person_1 p1 = new Person_1("静安");
        p1.speak();
        Person_1 p2 = new Person_1("雨尘",3);
        p2.speak();
    }
}

class Person_1//因为在一个project里面不能有重复的类，之前在PersonDemo.java里面创建了一个
{
    private String name;
    private int age;

    //定义一个Person_1类的构造函数,不同的初始化
    Person_1()// 构造函数，名字必须与类名相同，而且参数为空，用于类的初始化
    {
        name = "baby";
        age = 1;
        System.out.println("person run");
    }

    //如果有的孩子一出生就有名字，带参
    Person_1(String n)
    {
        name = n;
    }

    //如果有的孩子一出生就有名字，年龄
    Person_1(String n,int a)
    {
        name = n;
        age = a;
    }

    //如果对初始名字不满意，改名字
    public void setName(String n)
    {
        name = n;
    }

    public void speak()
    {
        System.out.println(name+":"+age);
    }
}

