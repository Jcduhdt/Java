package duotai;

/**
 * @version V12.0.1 2019-6-2
 * @author Zhang Xiong
 */

/*
 * 对象的多态性
 * class 动物{}
 * class 猫 extends 动物{}
 * class 狗 extends 动物{}
 *
 * 猫 x = new 猫();
 * 动物 x = new 猫();//一个对象，两种形态
 *
 * 猫这类事物既具备着猫类形态，又具备着动物的形态
 * 这就是对象的多态性
 *
 * 简单说：就是一个对象对应着不同类型
 * 多态在代码中的体现：
 *      父类或接口的引用指向其子类的对象
 * 多态的好处：
 *      提高了代码的扩展性，前期定义的代码可以使用后期的内容
 *
 * 多态的弊端：
 *      前期定义的内容不能调用（使用）后期子类特有的内容
 * 多态的前提：
 *      1.必须有关系，继承，实现
 *      2.要有覆盖
 */

abstract class Animal
{
    abstract void eat();
}
class Dog extends Animal
{
    void eat()
    {
        System.out.println("啃骨头");
    }
    void lookHome()
    {
        System.out.println("看家");
    }
}
class Cat extends Animal
{
    void eat()
    {
        System.out.println("吃鱼");
    }
    void catchMouse()
    {
        System.out.println("抓老鼠");
    }
}
class Pig extends Animal
{
    void eat()
    {
        System.out.println("饲料");
    }
    void gongDi()
    {
        System.out.println("拱地");
    }
}
public class DuoTaiDemo
{
    public static void main(String[] args)
    {
        Cat c = new Cat();
        method(c);
        Dog d = new Dog();
        method(d);
        method(new Pig());

        Animal a = new Cat();//自动类型提升，猫对象提升成了动物类型，但是特有功能无法访问
        //作用就是限制对特有功能的访问  专业讲：向上转型
        a.eat();

        //如果还想用具体动物猫的特有功能，你可以将该对象进行向下转型
        Cat c1 = (Cat) a;//向下转型的目的是为了使用子类中的特有方法
        c1.eat();
        c1.catchMouse();

        //注意：对于转型，自始自终都是子类对象在做着类型的变换
//        Animal a1 = new Dog();
//        Cat c2 = (Cat)a1;//报错:ClassCastException

    }

    //多态的一种使用
    public static void method(Animal a)//Animal a = new Cat();
    {
        a.eat();
    }
}
