/**
 * @version V12.0.1 2019-06-11
 * @author Zhang Xiong
 */
class Outer6
{
    void method()
    {
        Object obj = new Object()
        {
            public void show()
            {
                System.out.println("show run");
            }
        };
        //obj.show();编译失败，因为编译看左边，Object对象没有show这个方法
        //匿名内部类这个子类对象被向上转型为Object类型
    }
}
public class InnerClassDemo6
{
    public static void main(String[] args)
    {
        new Outer6().method();
    }
}
