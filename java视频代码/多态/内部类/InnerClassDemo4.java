/**
 * @version V12.0.1 2019-06-10
 * @author Zhang Xiong
 */
/*
 * 匿名内部类，就是内部类的简写格式
 * 必须有前提：
 *      内部类必须继承或者实现一个外部类或者接口
 * 匿名内部类：其实就是子类对象
 * 格式：new 父类or接口名(){子类内容};
 */
abstract class Demo
{
    abstract void show();
}
class Outer4
{
    int num = 4;
    /*
    class Inner extends Demo
    {
        void show() {
            System.out.println("show ..." + num);
        }
    }*/
    public void method()
    {
        //new Inner().show();
        new Demo()//匿名内部类 这就是个有点胖的对象
        {
            void show()
            {
                System.out.println("show..."+num);
            }
        }.show();
    }
}
public class InnerClassDemo4
{
    public static void main(String[] args)
    {
        new Outer4().method();
    }
}
