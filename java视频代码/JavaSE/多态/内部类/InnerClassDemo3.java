/**
 * @version V12.0.1 2019-06-03
 * @author Zhang Xiong
 */

/*
 * 内部类可以存放在局部位置上
 * 内部类在局部位置上只能访问局部中被final修饰的局部变量
 */
class Outer3
{
    int num = 3;
    Object method()
    {
        final int x = 9; //为什么我没有声明为final也运行成功了
        class Inner
        {
            void show()
            {
                System.out.println("show ..." + x);
            }
        }
        Object in = new Inner();
        return in;
        //in.show();
    }
}
public class InnerClassDemo3
{
    public static void main(String[] args)
    {
        new Outer3().method();

        Outer3 out = new Outer3();
        Object obj = out.method();
    }
}
