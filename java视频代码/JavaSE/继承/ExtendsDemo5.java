/**
 * @version V12.0.1 2019-05-24
 * @author Zhang Xiong
 */
/*
 * 一个对象实例化过程：
 * Person p = new Person();
 * 1.JVM会去读取指定路径下的Person.class文件，并加载进内存
 *   并会先加载Person的父类（如果有直接父类的情况下）
 * 2.在堆内存中的开辟空间，分配地址
 * 3.并在对象空间中，对对象中的属性进行默认初始化
 * 4.调用对应的构造函数进行初始化
 * 5.在构造函数中，第一行会先到调用父类中构造函数进行初始化
 * 6.父类初始化完毕后，在对子类的属性进行显示初始化
 * 7.再进行子类构造函数的特定初始化
 * 8.初始化完毕后，将地址值赋值给引用变量
 */

class Fu5
{
    Fu5()
    {
        super();
        show();//子父类中有相同方法时，先运行调用对象的show，所以会打印zi5 show...0
        return;
    }

    void show()
    {
        System.out.println("fu5 show");
    }
}

class Zi5 extends Fu5
{
    int num = 8;
    Zi5()
    {
        super();//通过super初始化父类内容时，子类的成员变量并未显示初始化，等super()父类初始化完毕后
        //才进行子类的成员变量显示初始化
        return;
    }
    void show()
    {
        System.out.println("zi5 show..."+num);
    }
}
public class ExtendsDemo5
{
    public static void main(String[] args)
    {
        Zi5 z = new Zi5();
        z.show();
    }
}

