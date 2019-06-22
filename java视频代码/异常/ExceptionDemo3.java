/**
 * @version V12.0.1 2019-06-19
 * @author Zhang Xiong
 */

/*
 * 异常处理的捕捉形式
 * 这是可以对异常进行针对性处理的方式
 *
 * 具体格式是：
 *
 * try
 * {
 *      //需要被检测异常的代码
 * }
 * catch(异常类 变量)//该变量用于接收发生的异常对象
 * {
 *      //处理异常的代码
 * }
 * fnally
 * {
 *      //一定会被执行的代码
 * }
 */
class FuShuIndexException3 extends Exception
{
    FuShuIndexException3(){}
    FuShuIndexException3(String msg)
    {
        super(msg);
    }
}
class Demo3
{
    public int method(int[] arr,int index)throws FuShuIndexException3
    {
        if (index<0)
            throw new FuShuIndexException3("角标变成负数了！");
        return arr[index];
    }
}
public class ExceptionDemo3
{
    public static void main(String[] args)throws FuShuIndexException
    {
        int[] arr = new int[3];
        Demo3 d = new Demo3();
        //d.method(arr,3);//java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        //抛了异常就不进行后面的内容了
        try
        {
            int num = d.method(arr,-30);
            System.out.println("num = " + num);
        }
        catch(FuShuIndexException3 e)
        {
            System.out.println("message: " + e.getMessage());
            System.out.println("string: " + e);//自动调用toString()
            e.printStackTrace();//JVM默认的异常处理机制就是调用异常对象的这个方法
            System.out.println("负数角标异常！！！");
        }
        System.out.println("over");
    }
}
