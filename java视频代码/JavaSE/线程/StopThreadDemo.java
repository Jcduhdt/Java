package ThreadBiu;

/**
 * @version V12.0.1 2019-7-3
 * @author Zhang Xiong
 */

/*
 * 停止线程：
 * 1.stop方法
 * 2.run方法结束
 *
 * 怎么控制线程的任务结束呢？
 * 任务中都会有循环结构，只要控制住循环就可以结束任务
 *
 * 控制循环通常就用定义标记来完成
 * 但是如果线程处于冻结状态，无法读取标记，如何结束呢
 *
 * 可以使用interrupt()方法将线程从冻结状态强制恢复到运行状态中来，让线程具备cpu的执行资格
 * 当时强制动作会发生InterruptedException 记得要处理
 *
 *
 * 后面还添加了守护线程的一点知识  t2.setDaemon(true);
 */

class StopThread implements Runnable
{
    private boolean flag = true;
    public synchronized void run()
    {
        while(flag)
        {
            try
            {
                wait();
            }
            catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "......" + e);
                flag = false;
            }
            System.out.println(Thread.currentThread().getName() + "......+++");
        }
    }

    public void setFlag()
    {
        flag = false;
    }
}
public class StopThreadDemo
{
    public static void main(String[] args)
    {
        StopThread st = new StopThread();

        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);

        t1.start();//前台线程必须手动结束
        t2.setDaemon(true);//设置守护线程，后台线程，线程开始之前，所有的前台线程都结束了，无论后台线程处于什么状态，都会自动消失
        //类似与依附关系
        t2.start();

        int num = 1;
        for (;;)//无限循环
        {
            if (++num == 50)
            {
//                st.setFlag();
                t1.interrupt();

                //t2.interrupt();
                break;
            }
            System.out.println("main..." + num);
        }
        System.out.println("over");
    }
}
