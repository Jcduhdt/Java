/**
 * @version V12.0.1 2019-6-22
 * @author Zhang Xiong
 */

/*
 * 进程：正在进行中的程序（直译）
 * 线程：就是进程中一个负责程序执行的控制单元（执行路径）
 * 一个进程中可以有多个执行路径，即多线程
 *
 * 一个进程中至少要有一个线程
 *
 * 开启多个线程是为了同时运行多部分代码
 * 每一个线程都有自己运行的内容，这个内容可以称为线程要执行的任务
 *
 * 多线程好处：解决了多部分同时运行的问题
 * 多线程弊端：线程太多会导致效率的降低，因为并不是同时进行，而是靠cpu在随机分配运行时间，在极短的时间内运行一个，就像TDMA
 *
 * 应用程序的执行都是cpu在做着快速的切换完成的，这个切换是随机的
 *
 * JVM启动时就启动了多个线程，至少有两个线程可以分析得出来
 * 1.执行main函数的线程
 *      该线程的任务代码都定义在主函数中
 * 2.负责垃圾回收的线程
 */

class Demo extends Object
{
    public void finalize()//finalize()是Object的protected方法，子类可以覆盖该方法以实现资源清理工作，GC在回收对象之前调用该方法。
    {
        System.out.println("demo ok");
    }
}
public class Threading
{
    public static void main(String[] args)
    {
        new Demo();
        new Demo();
        new Demo();
        System.gc();//自己运行垃圾回收站
        System.out.println("biu·biu·biu");
        /*
         * 因为有两个线程，所以打印结果有时候不一样，线程结束时间不一样
         */
    }
}
