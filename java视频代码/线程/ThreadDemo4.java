/**
 * @version V12.0.1 2019-6-24
 * @author Zhang Xiong
 */

/*
 * 可以多看看API
 * 创建线程的第一种方式：继承Thread类
 *
 * 创建线程的第二种方式：实现Runnable接口
 *  1.定义类实现Runnable接口
 *  2.覆盖接口中的run方法，将线程的任务代码封装到run方法中
 *  3.通过Thread类创建线程对象，并将Runnable接口的子类对象作为Thread类的构造函数的参数进行传递
 *    为什么？因为线程的任务都封装在Runnable接口子类对象的run方法中
 *    所以要在线程对象创建时就明确要运行的任务
 *  4.调用线程对象的start方法开启线程
 *
 *
 * Runnable的出现仅仅是将线程的任务进行了对对象的封装
 * 实现Runnable接口的好处
 *  1.可将线程的任务从线程的子类中分离出来，进行了单独的封装
 *    按照面向对象的思想将任务的封装成对象
 *  2.避免了java单继承的局限性
 * 所以，创建线程的第二种方式较为常用
 */

class Demo4 implements Runnable //extends Fu  若该类有父类，则不能继承Thread，因为不能多继承，且不可能一大家族都是线程类
// 准备扩展Demo4类的功能，让其中的内容可以作为线程的任务执行  通过接口的形式完成
{
    public void run()
    {
        show();
    }
    public void show()
    {
        for (int x=0;x<20;x++)
        {
            System.out.println(Thread.currentThread().getName() + "...." + x);
        }
    }
}
public class ThreadDemo4
{
    public static void main(String[] args)
    {
       /* Demo4 d1 = new Demo4();
        Demo4 d2 = new Demo4();
        d1.start();
        d2.start();*/
       Demo4 d1 = new Demo4();
       Demo4 d2 = new Demo4();
       Thread t1 = new Thread(d1);
       Thread t2 = new Thread(d2);
       t1.start();
       t2.start();
    }
}

/*
大概就是这个流程
class Thread
{
    private Runnable r;
    Thread()
    {
    }
    Thread(Runnable r)
    {
        this.r = r;
    }
    public void run()
    {
        if (r != null)
            r.run();
    }
    public void start()
    {
        run();
    }
}

class ThreadImpl implements Runnable
{
    public void run()
    {
        System.out.println("biu`biu`biu");
    }
}

ThreadImpl i = new ThreadImpl();

Thread t = new Thread(i);
t.start();
*/
