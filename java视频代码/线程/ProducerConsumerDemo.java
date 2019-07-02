package ThreadBiu;


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
 * notify:只能唤醒一个线程，如果本方唤醒本方，没有意义，而且while判断标记+notify会导致死锁
 * notifyAll解决了本方线程一定会唤醒对方线程的问题
 */


class ProConResource
{
    private String name;
    private int count = 1;
    private boolean flag = false;


    public void set(String name)
    {
        while (flag)//原来是if判断  if和while有区别
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        this.name = name + count;//烤鸭1
        count++;//2
        System.out.println(Thread.currentThread().getName() + "..生产者.." + this.name);//生产烤鸭1
        flag = true;
        notifyAll();//为了避免死锁，java又没有只唤醒对方的方法，所以只有来更狠的notifyAll
        //notify();//线程活了之后，就不用执行判断flag 执行notify的这个线程还要再跑一遍if flag  改成while就解决了这个问题
        //但是变成了死锁  四个线程都锁住了
        //看看wait notify的API
    }

    public synchronized void out()
    {
        while (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + "..消费者.." + this.name);
        flag = false;
        notifyAll();
    }
}

class Producer implements Runnable
{
    private ProConResource r;
    Producer(ProConResource r)
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

class Consumer implements Runnable
{
    private ProConResource r;
    Consumer(ProConResource r)
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
public class ProducerConsumerDemo
{
    public static void main(String[] args)
    {
        ProConResource r = new ProConResource();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);

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
