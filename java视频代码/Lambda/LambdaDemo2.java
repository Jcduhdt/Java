/**
 * @author ZhangXiong
 * @version v12.0.1
 * @date 2019-07-28
 */

/*
 * Lambda表达式的标准格式：
 *  由三部分组成：
 *      a.一些参数
 *      b.一个箭头
 *      c.一段代码
 *  格式：
 *      (参数列表) ->{一些重写方法的代码};
 *  解释说明格式:
 *      ():接口中抽象方法的参数列表，没有参数，就空着，有参数就写出参数，多个参数使用逗号分隔符
 *      ->:表示传递的意思，把参数传给方法体{}
 *      {}:重写接口的抽象方法的方法体
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        //使用匿名内部类的方式实现多线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"新线程创建了");
            }
        }).start();


        //使用Lambda表达式，实现多线程
        //()就是run方法，()里面写参数，没有就空着，->就是这个方法所要传递的参数，{}内部就是该方法的内容
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"新线程创建了");
        }).start();


        //优化省略Lambda 只有一行，可省略{} ;
        new Thread(()-> System.out.println(Thread.currentThread().getName()+"新线程创建了")).start();
    }
}
