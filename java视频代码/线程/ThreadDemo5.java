/**
 * @version V12.0.1 2019-6-24
 * @author Zhang Xiong
 */

/*
 * 需求：卖票
 * 1.多个线程在操作共享的数据
 * 2.操作共享数据的代码有多条
 *
 * 当一个线程在执行操作共享数据的多条代码过程中，其他线程参与了运算
 * 就会导致线程安全问题的产生
 *
 * 解决思路：
 * 就是将多条操作共享数据的线程代码封装起来，当有线程在执行这些代码的时候
 * 必须要当前线程把这些代码都执行完毕后，其他线程才可以参与运算
 *
 * 在java中，用同步代码块就可以解决这个问题
 * 同步代码块的格式：synchronized(对象){需要被同步的代码块}
 */

class Ticket implements Runnable//extends Thread
{
    private int num = 500;
    Object obj = new Object();
    public void run()
    {
        sale();
    }
    public void sale()
    {
        while(true)
        {
            synchronized (obj)
            {
                if (num > 0)
                {
                    try
                    {
                        Thread.sleep(10);
                    } catch (InterruptedException e)
                    {
                    }
                    System.out.println(Thread.currentThread().getName() + "...sale..." + num--);//因为线程执行的而随机性产生问题-1，-2
                }
            }
        }
    }
}
public class ThreadDemo5
{
    public static void main(String[] args)
    {
        /*  Ticket t1 = new Ticket();  //可对num加static 但是似乎有些其他问题，，没有听。。。。
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();

        t1.start();
        t2.start();
        t3.start();
        t4.start();*/

        Ticket t = new Ticket();//创建一个线程任务对象 保证就只卖100张票
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
