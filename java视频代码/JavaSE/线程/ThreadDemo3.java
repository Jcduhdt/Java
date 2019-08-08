import javax.swing.plaf.synth.SynthSplitPaneUI;

/**
 * @version V12.0.1 2019-6-23
 * @author Zhang Xiong
 */


/*
 * 如何创建一个线程？
 * 创建线程方式一：继承Thread类
 *
 * 步骤：
 * 1.定义一个类继承Thread类
 * 2.覆盖Thread类中的run方法
 * 3.直接创建Thread类子类对象创建线程
 * 3.调用start方法开启线程并调用线程的任务run方法
 *
 * 可以通过Thred的getName获取线程名称，Thread-编号(从零开始)
 * 主线程的名字就是main
 */
class Demo3 extends Thread
{
    private String name;
    Demo3(String name)
    {
        //super(name);
        this.name = name;
    }
    public void run()
    {
        /*int[] arr = new int[3];
        System.out.println(arr[3]);*/
        for (int x=0;x<10;x++)
        {
            System.out.println(name + "....x = " + x +".....name = " + Thread.currentThread().getName());
        }
    }
}
public class ThreadDemo3
{
    public static void main(String[] args)
    {
        /*
         * 创建线程的目的是为了开启一条执行路径，去运行指定的代码和其他代码实现同时运行
         * 而运行的指定代码就是这个执行路径的任务
         * JVM创建的主线程的任务都定义在了主函数中
         * 而自定义的线程它的任务在哪呢？
         * Thread类用于描述线程，线程是需要任务的，所以Thread类也是对任务的描述
         * 这个任务就通过Thread类中的run方法来体现，也就是说，run方法就是封装自定义线程运行任务的函数
         * run方法中定义就是线程要运行的任务代码
         * 开启线程是为了运行指定代码，所以只有继承Thread类，并复写run方法
         * 将运行的代码定义在run方法中即可
         */
        Demo3 d1 = new Demo3("风度");
        Demo3 d2 = new Demo3("萧蔷");
        d1.start();//开启线程，调用run方法
        d2.start();

        System.out.println(4/0);//throw new ArithmeticException();  抛异常了，主函数就不进行了,不影响其他线程
        for (int x=0;x<20;x++)
        {
            System.out.println("over!....." + Thread.currentThread().getName());
        }

        //调用run和调用start的区别
    }
}