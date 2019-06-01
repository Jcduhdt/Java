/**
 * @vision V12.0.1 2019-6-1
 * @author Zhang Xiong
 */

/*
 * 继承弊端：打破了封装性
 * final 关键字：
 * 1.final是一个修饰符，可以修饰类，方法，变量
 * 2.final修饰的类不可以被继承
 * 3.final修饰的方法不可以被覆盖
 * 4.final修饰的变量是一个常量，只能赋值一次
 *   为什么要用final修饰变量，其实在程序中如果一个数据是固定的
 *   那么直接使用这个数据就行，但这样阅读性差，所以为该数据起个名称
 *   而且这个变量名称的值不能变换，所以加上final固定
 *
 * 写法规范：常量所有字母都大写，多个单词，中间用下划线连接
 */

class Fu6
{
    void method()
    {
        //调用了底层系统的资源
    }
}

class Zi6 extends Fu6
{
    final double MY_PI = 3.14;//规定常量名大写，好区分，单词与单词之间用_区分
    static final int NUMBER = 7;//常量一般都加static
    void method()
    {
        final int x = 9; //final 显式初始化
        //x = 10;Error:(28, 9) java: 无法为最终变量x分配值
        System.out.println(x);
    }
}
public class FinalDemo
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
    }
}
