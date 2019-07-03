package ThreadBiu;

/**
 * @version V12.0.1 2019-7-3
 * @author Zhang Xiong
 */

/*
 * join   这东西没听懂  t1.join();
 * 优先级，t2.setPriority(Thread.MAX_PRIORITY);
 * 组
 */
class Demo implements Runnable
{
    public void run()
    {
        for (int x=0;x<50;x++)
        {
            System.out.println(Thread.currentThread().toString() + "......" + x);//Thread[Thread-1,5,main]......0   打印出来的5就是优先级，越大占用cpu的几率越大
            //优先级分为1-10
            Thread.yield();//转一圈就释放执行权了，减少一转一大片的概率
        }
    }
}
public class JoinDemo
{
    public static void main(String[] args) throws Exception
    {
        Demo d = new Demo();
        Thread t1 = new Thread(d);
        Thread t2 = new Thread(d);

        t1.start();
        //t1.join();//t1线程要申请加入进来，运行。临时加入一个线程运算时可以使用join方法
        t2.start();
        //t2.setPriority(Thread.MAX_PRIORITY);//设置优先级，默认情况下，优先级都是5
        for (int x=0;x<50;x++)
        {
            System.out.println(Thread.currentThread()+"..."+x);
        }
    }
}
