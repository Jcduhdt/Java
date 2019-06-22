/**
 * @version V12.0.1 2019-06-20
 * @author Zhang Xiong
 */

class Demo5
{
    public int show(int index)
    {
        if (index<0)
            throw new ArrayIndexOutOfBoundsException("越界啦！！");
        int[] arr = new int[3];
        return arr[index];
    }
}
public class ExceptionDemo5
{
    public static void main(String[] args)
    {
        Demo5 d = new Demo5();
        try
        {
            int num = d.show(-3);
            System.out.println("num= " + num);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println(e.toString());
            //return;也会执行finally
            //System.exit(0);//退出JVM finally不会执行
        }
        finally//通常用于关闭（释放）资源
        {
            System.out.println("finally");
        }
        System.out.println("over!");
    }
}
/*
 * 连接数据库
 * 查询 Exception
 * 关闭连接
 */

/*
 * try catch finally 代码块组合特点：
 * 1.try catch finally
 * 2.try catch(多个) 当没有必要资源需要释放时，可以不用定义finally
 * 3.try finally  异常无法直接catch处理 但是资源需要关闭
 * void show()throws Exception
 * {
 *      try
 *      {
 *          //开启资源
 *          throw new Exception();
 *      }
 *      finally
 *      {
 *          //关闭资源
 *      }
 *      //catch(Exception e){}
 */
