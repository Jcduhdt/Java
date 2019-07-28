package pool;

/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-28
 */
public class RunnableTmpl implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"创建了一个新的线程执行");
    }
}
