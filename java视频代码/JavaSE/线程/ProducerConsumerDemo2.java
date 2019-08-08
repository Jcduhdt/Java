package ThreadBiu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @version V12.0.1 2019-7-2
 * @author Zhang Xiong
 */

/*
 * 生产者，消费者
 *
 * 多生产者，多消费者
 *
 * 但是为什么我的打印的count这个东西一开始显示不全还是从很大的数，比如125563开始的
 *
 * if判断标记，只有一次，会导致不该运行的线程运行了，出现数据错误的情况
 * while判断标记，解决了线程获取执行权后，是否要运行！
 *
 * 判断标记时一定要用while，因为安全，每次醒来一定要判断标记
 *
 * notify:只能唤醒一个线程，如果本方唤醒本方，没有意义，而且while判断标记+notify会导致死锁
 * notifyAll解决了本方线程一定会唤醒对方线程的问题
 */

/*
 * JDK1.5以后将同步和锁封装成了对象
 * 并将操作锁的隐式方式定义到了该对象中
 * 将隐式动作变成了显示动作
 *
 * 基本流程同synchronized 不过最大的不同在于，Lock可以有多组监视器
 * 就是生产者可以唤醒消费者，消费者可以唤醒生产者，不用notifyAll
 *
 * Lock接口：替代了同步代码块或者同步函数。将同步隐式锁操作变成显示锁操作
 * 同时更为灵活，可以一个锁上加多组监视器
 * lock():获取锁
 * unlock():释放锁，通常需要定义finally代码块
 *
 * Condition接口：出现替代了Object中的wait notify notifyAll方法
 *              将这些监视器方法单独进行了封装，变成Condition监视器对象
 *              可以任意锁进行组合
 * await()
 * signal()
 * signalAll()
 *
 */

class ProConResource2
{
    private String name;
    private int count = 1;
    private boolean flag = false;

    //创建一个锁对象
    Lock lock = new ReentrantLock();//jdk1.5之后用于替代synchronized的对象
    //通过已有的锁获取该锁上的监视器对象
    //Condition con = lock.newCondition();

    //通过已有的锁获取两组监视器，一组监视生产者，一组监视消费者
    Condition producer_con = lock.newCondition();
    Condition comsumer_con = lock.newCondition();
    public void set(String name)
    {
        lock.lock();//拿到锁
        try {
            while (flag)//原来是if判断  if和while有区别
            {
                try {
                    //this.wait();
                    producer_con.await();
                } catch (InterruptedException e) {
                }
            }
            this.name = name + count;//烤鸭1
            count++;//2
            System.out.println(Thread.currentThread().getName() + "..生产者5.0.." + this.name);//生产烤鸭1
            flag = true;
            comsumer_con.signal();//消费者，来一个，快来吃
            //notifyAll();//为了避免死锁，java又没有只唤醒对方的方法，所以只有来更狠的notifyAll
            //notify();//线程活了之后，就不用执行判断flag 执行notify的这个线程还要再跑一遍if flag  改成while就解决了这个问题
            //但是变成了死锁  四个线程都锁住了
            //看看wait notify的API
        }
        finally {
            lock.unlock();
        }
    }

    public synchronized void out()
    {
        lock.lock();//拿到锁
        try {
            while (!flag) {
                try {
                    //this.wait();
                    comsumer_con.await();
                } catch (InterruptedException e) {
                }
            }
            System.out.println(Thread.currentThread().getName() + "..消费者.." + this.name);
            flag = false;
            producer_con.signal();//生产者，来一个！去生产
            //notifyAll();
        }
        finally {
            lock.unlock();
        }
    }
}

class Producer2 implements Runnable
{
    private ProConResource2 r;
    Producer2(ProConResource2 r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.set("烤鸭");
        }
    }
}

class Consumer2 implements Runnable
{
    private ProConResource2 r;
    Consumer2(ProConResource2 r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.out();
        }
    }
}
public class ProducerConsumerDemo2
{
    public static void main(String[] args)
    {
        ProConResource2 r = new ProConResource2();
        Producer2 pro = new Producer2(r);
        Consumer2 con = new Consumer2(r);

        Thread t0 = new Thread(pro);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        Thread t3 = new Thread(con);

        t0.start();
        t1.start();
        t2.start();
        t3.start();

    }
}