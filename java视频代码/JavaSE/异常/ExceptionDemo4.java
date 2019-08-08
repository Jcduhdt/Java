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
 *
 * 异常处理原则：
 * 1，函数内部如果抛出需要检测的异常，那么函数上必须要声明
 *    否则必须在函数内用trycatch捕捉，否则编译失败
 * 2.如果调用到了声明异常的函数，要么trycatch要么throws，否则编译失败。
 * 3.什么时候catch，什么时候throws？
 *      功能内容可以解决，用catch
 *      解决不了，用throws告诉调用者，由调用者解决
 * 4.一个功能如果抛出了多个异常，那么调用时，必须有对应多个catch进行针对性的处理
 *      内部有几个需要检测的异常，就抛出几个异常，抛出几个，就catch几个
 */
class FuShuIndexException4 extends Exception
{
    FuShuIndexException4(){}
    FuShuIndexException4(String msg)
    {
        super(msg);
    }
}
class Demo4
{
    public int method(int[] arr,int index)throws NullPointerException,FuShuIndexException3//多异常
    {
        if (arr == null)
            throw new NullPointerException("没有任何数组实体");
        if (index<0)
            throw new FuShuIndexException3("角标变成负数了！");
        return arr[index];
    }
}
public class ExceptionDemo4
{
    public static void main(String[] args)throws FuShuIndexException
    {
        int[] arr = new int[3];
        Demo4 d = new Demo4();
        //d.method(arr,3);//java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        //抛了异常就不进行后面的内容了
        try
        {
            int num = d.method(arr,-30);
            System.out.println("num = " + num);
        }
        catch (NullPointerException e)
        {
            System.out.println(e.toString());
        }
        catch(FuShuIndexException3 e)
        {
            System.out.println("message: " + e.getMessage());
            System.out.println("string: " + e);//自动调用toString()
            e.printStackTrace();//JVM默认的异常处理机制就是调用异常对象的这个方法
            System.out.println("负数角标异常！！！");
        }

        /*catch (Exception e)//多catch，父类catch放在最后否则编译失败
        {

        }*/
        System.out.println("over");
    }
}