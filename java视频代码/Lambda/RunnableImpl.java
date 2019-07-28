/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-28
 */

/*
 * 创建Runnable接口的实现类，重写run方法实现多线程程序
 */
public class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"新线程创建了");
    }
}
