/**
 * @version V12.0.1 2019-06-10
 * @author Zhang Xiong
 */

interface  Inter
{
    void show1();
    void show2();
}
/*
 * 懵！！！
 * 通常的使用场景之一：
 *      当函数参数是接口类型时，而且接口中的方法不超过三个
 *      可以用匿名内部类作为实际参数进行传递
 */
class Outer5
{
    class Inner implements Inter
    {
        public void show1() {}
        public void show2() {}
    }
    public void method()
    {
        Inter in = new Inter()
        {
            @Override
            public void show1() {}

            @Override
            public void show2() {}
        };
        in.show1();
        in.show2();
    }
}
public class InnerClassDemo5
{
    public static void main(String[] args)
    {
        show(new Inter()
        {
            public void show1(){}
            public void show2(){}
        });
    }

    public static void show(Inter in)
    {
        in.show1();
        in.show2();
    }
}
