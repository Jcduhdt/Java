/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-28
 */

/*
 * 使用Lambda必须具有接口，且要求接口中有且仅有一个抽象方法
 * 使用Lambda必须具有上下文推断：也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例
 */

/*
 * 面向对象思想：做一件事情，找一个能解决这个事情的对象，调用对象的方法完成事情
 * 函数式编程思想：只要能获取到结果，谁去做的，怎么做的都不重要，重视的是结果，不重视过程
 *
 * 使用实现Runnable接口的方式实现多线程程序
 *
 */
public class LambdaDemo {
    public static void main(String[] args) {
        //创建Runnable接口的实现对象
        RunnableImpl run = new RunnableImpl();
        //创建Thread类对象，构造方法中传递Runnable接口的实现类
        Thread t = new Thread(run);
        //调用start方法开启新线程，执行run方法
        t.start();

        //简化代码，使用匿名内部类，实现多线程程序
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"新线程创建了");
            }
        };
        new Thread(r).start();

        //简化代码  为了做这件事，必须要创建匿名内部类，覆盖run方法  存在冗余
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"新线程创建了");
            }
        }).start();
    }
}
