/**
 * time:2019-05-16
 * author：Zhang Xiong
 * 当成员变量和局部变量重名，可以用关键字this区分
 * this：代表对象，代表哪个对象呢？当前对象
 *       this就是所在函数所属对象的引用
 *       简单说：哪个对象调用了this所在函数，this就代表哪个对象
 * this也可以用于在构造函数中调用其它构造函数。
 * 注意：只能定义在构造函数的第一行，因为初始化动作要先执行
 */
public class ThisDemo
{
    public static void main(String[] args)
    {
        Person_2 p = new Person_2("可微");//构造函数：构建创建对象时调用的函数
        p.speak();
        Person_2 p1 = new Person_2("星浅",23);
        p1.speak();
        Person_2 p2 = new Person_2("夜",18);
        System.out.println(p1.compare(p2));
    }
}

class Person_2//因为在一个project里面不能有重复的类，之前在PersonDemo.java里面创建了一个
{
    private String name;
    private int age;

    //定义一个Person_1类的构造函数,不同的初始化
    Person_2()// 构造函数，名字必须与类名相同，而且参数为空，用于类的初始化
    {
        name = "baby";
        age = 1;
        System.out.println("person run");
    }

    //如果有的孩子一出生就有名字，带参
    Person_2(String name)
    {
        this.name = name;//局部的赋给了对象的
    }

    //如果有的孩子一出生就有名字，年龄
    Person_2(String name,int age)
    {
        this(name);//调用上一个孩子一出生就有名字的构造函数
        //因为构造函数是对对象进行初始化，所以有对象才能调用构造函数
        this.age = age;
    }

    //如果对初始名字不满意，改名字
    public void setName(String n)
    {
        name = n;
    }

    public void speak()
    {
        System.out.println(name+":"+age);//其实这个类里面都省略了this.因为没重名 比如this.age  this.name
    }

    /*
    判断是否同龄人
     */
    public boolean compare(Person_2 p)
    {
        /*
        if (this.age==p.age)
            return true;
        else
            return false;
         */
        return this.age==p.age;
    }
}


