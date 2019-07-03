package ThreadBiu;

/**
 * @version V12.0.1 2019-7-3
 * @author Zhang Xiong
 */

/*
 * wait 和 sleep的区别
 * 1.wait可以指定时间也可以不指定，sleep必须指定时间
 * 2.在同步中时，对cpu的执行权和锁的处理不同
 *      wait：释放执行权，释放锁，因为必须被别人唤醒
 *      sleep：释放执行权，不释放锁，自己会醒
 */

public class Distinguish
{
    public static void main(String[] args)
    {
        System.out.println("sleep 和 wait的区别...");
    }
}
