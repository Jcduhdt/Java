package ThreadBiu;

/**
 * @version V12.0.1 2019-7-3
 * @author Zhang Xiong
 */

/*
 * 面试题。。。。。。。。。。。
 */

/*class Test implements Runnable
{
    public void run(Thread t)
    {}
}
//如果错误，错误发生在哪一行，
//错误在第一行，应该被abstract修饰
//Error:(9, 1) java: ThreadBiu.Test不是抽象的, 并且未覆盖java.lang.Runnable中的抽象方法run()*/

public class ThreadTest
{
    public static void main(String[] args)
    {

       /* new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                System.out.println("runnable run");
            }
        })
        {
            public void run()
            {
                System.out.println("subThread run");
            }
        }.start();
        //覆写了，以子类为主*/
        new Thread()
        {
            public void run()
            {
                for (int x=0;x<50;x++)
                {
                    System.out.println(Thread.currentThread().getName() + " x = " + x);
                }
            }
        }.start();

        for (int x=0;x<50;x++)
        {
            System.out.println(Thread.currentThread().getName() + " y = " + x);
        }

        Runnable r = new Runnable()
        {
            public void run()
            {
                for (int x=0;x<50;x++)
                {
                    System.out.println(Thread.currentThread().getName() + " z = " + x);
                }
            }
        };
        new Thread(r).start();
    }
}
