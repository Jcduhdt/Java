/**
 * @time 2019-05-20
 * @author Zhang Xiong
 * @version V12.0.1
 */
/*
 * 设计模式：对问题行之有效的解决方式。其实它是一种思想
 * 1.单例设计模式
 *   解决问题：可以保证一个类在内存中的对象唯一性
 *   比如对多个程序使用同一个配置信息对象时，就需要保证该对象的唯一性
 *
 * 如何保证对象唯一性呢
 * 1.不允许其他程序用new创建该类对象
 * 2.在该类中创建一个本类实例
 * 3.对外提供一个方法让其他程序可以获取该对象
 *
 * 步骤：
 * 1.私有化该类构造函数
 * 2.通过new在本类中创建本类对象
 * 3.定义一个公有方法，将创建的对象返回
 */
class Single
{
    static Single s = new Single();

    private Single(){}

    public static Single getInstance()
    {
        return s;
    }
}
public class SingleDemo
{
    public static void main(String[] args)
    {
        //Single ss = Single.getInstance();
        Single.s;
    }
}
