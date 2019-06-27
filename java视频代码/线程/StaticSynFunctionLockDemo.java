/**
 * @version V12.0.1 2019-6-27
 * @author Zhang Xiong
 */
/*
 * 该代码验证了同步函数使用的锁是this
 * 同步函数和同步代码块的区别：
 * 同步函数的锁是固定的this，同步代码块的锁是任意的对象
 * 建议使用同步代码块锁
 *
 * 保证多个线程的同一个锁是唯一的
 * 静态的同步函数使用的锁是 该函数所属字节码文件对象 可以用 getclass()方法获取，也可用当前类名.class获取
 */
class StaTicket implements Runnable//extends Thread
{
    private static int num = 100;
    //Object obj = new Object();
    boolean flag = true;
    public void run()
    {
        sale();
    }
    public void sale()
    {
        System.out.println("this:"+this.getClass());
        if (flag)
        {
            while (true)
            {
                synchronized (StaTicket.class)//(this.getClass())
                {
                    if (num>0)
                    {
                        try
                        {
                            Thread.sleep(10);
                        } catch (InterruptedException e)
                        {
                        }
                        System.out.println(Thread.currentThread().getName() + "...obj..." + num--);//因为线程执行的而随机性产生问题-1，-2
                    }
                }
            }
        }
        else
            while (true)
            {
                show();
            }
    }

    public static synchronized void show()//只同步需要同步的代码块
    {
        if (num > 0)
        {
            try
            {
                Thread.sleep(10);
            } catch (InterruptedException e)
            {
            }
            System.out.println(Thread.currentThread().getName() + "...function..." + num--);//因为线程执行的而随机性产生问题-1，-2
        }
    }
}

public class StaticSynFunctionLockDemo
{
    public static void main(String[] args)
    {
        StaTicket t = new StaTicket();//创建一个线程任务对象 保证就只卖100张票
        System.out.println("t:"+t.getClass());

        /*Class clazz = t.getClass();
        Class clazz1 = StaTicket.class;*/
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);

        t1.start();
        try//让主线程睡一下
        {
            Thread.sleep(10);
        }
        catch (InterruptedException e){}
        t.flag = false;
        t2.start();

    }
}
