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
 */

class Demo
{

}
public class Threading
{
    public static void main(String[] args)
    {
        new Demo();
        new Demo();
        new Demo();
        System.out.println("biu·biu·biu");
    }
}
