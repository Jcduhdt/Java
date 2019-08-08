/**
 * @version V12.0.1 2019-6-27
 * @author Zhang Xiong
 */

/*
 * 多线程下的单例
 * 这个程序没跑，只是讲解了一下
 */

//饿汉式
class Single
{
    private static final Single s = new Single();
    private Single(){}
    public static Single getInstance()
    {
        return s;
    }
}

//懒汉式  用到才给
class Single1
{
    private static Single1 s = null;
    private Single1(){}
    public static Single1 getInstance()
    {
        if (s == null)//加了这个就不会让线程每次判断锁了，解决效率问题 因为不加这个也还是要判断一次s==null 只不过提前了而已
        {
            synchronized (Single1.class)//解决安全问题
            {
                if (s == null)
                    //-->0 -->1 如果没有同步可能线程0 1几乎同时进来了
                    s = new Single1();
            }
        }
        return s;
    }
}

public class SingleDemo
{
    public static void main(String[] args)
    {
        System.out.println("...");
    }
}
