package ThreadBiu;

/**
 * @version V12.0.1 2019-7-2
 * @author Zhang Xiong
 */

/*
 * 等待，唤醒机制
 * 存一个，输出一个
 * 涉及的方法
 * 1.wait()：让线程处于冻结状态，被wait的线程会被存储到线程池中。
 * 2.notify()：唤醒线程池中的一个线程（任意）
 * 3.notifyAll()：唤醒线程池中的所有线程
 *
 * 这些方法都必须定义在同步中
 * 因为这些方法是用于操作线程状态的方法
 * 必须要明确到底操作的是哪个锁上的线程
 *
 * 为什么操作线程的方法wait notify notifyAll定义在Object类中
 * 因为这些方法是监视器的方法，监视器其实就是锁
 * 锁可以是任意的对象，任意的对象调用的方式一定定义在Object类中
 */

//资源
class Resource3
{
    /*
     * 资源里封装属性，对外提供方法 里面同步
     */
    private String name;
    private String sex;
    private Boolean flag = false;

    public synchronized void set(String name,String sex)
    {
        if (flag)
            try {
                this.wait();
            }
            catch(InterruptedException e){}
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }

    public synchronized void out()
    {
        if (!flag)
            try {
                this.wait();
            }
            catch(InterruptedException e){}
        System.out.println(name + "..+.." + sex);
        flag = false;
        this.notify();
    }
}

//输入
class Input3 implements Runnable
{
    Resource3 r;
    //Object obj = new Object();
    Input3(Resource3 r)
    {
        this.r = r;
    }
    public void run()
    {
        int x = 0;
        while (true)
        {
            if (x == 0) {
                r.set("mike","man");
            } else {
                r.set("理理","女女女女女");
            }
            x = (x + 1) % 2;
        }
    }
}

//输出
class Output3 implements Runnable
{
    Resource3 r;
    //Object obj = new Object();
    Output3(Resource3 r)
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
public class ResourceDemo3
{
    public static void main(String[] args)
    {
        //创建资源  资源唯一，因为两者就是对一资源进行处理
        Resource3 r = new Resource3();
        //创建任务
        Input3 in = new Input3(r);
        Output3 out = new Output3(r);
        //创建线程，执行路径
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);
        //开启线程
        t1.start();
        t2.start();
    }
}
