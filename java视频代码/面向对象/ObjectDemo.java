/**
 * time:2019-05-15
 * author：Zhang Xiong
 */
public class ObjectDemo//结果是3
{
    public static void main(String[] args)
    {
        int x = 3;
        show(x);//x是4，也返回了，不过在栈里这句话结束就没用了
        System.out.println("x="+x);//这个x是堆里的x=3
    }

    public static void show(int x)
    {
        x = 4;
    }
}

/**
 * public class ObjectDemo//结果是4
 * {
 *     int x = 3;
 *     public static void main(String[] args)
 *     {
 *         Demo d = new Demo();
 *         d.x = 9;
 *         show(d);//因为这是对象，弹栈后返回给对象d的x值为4
 *         System.out.println(d.x);//主函数中的d
 *     }
 *
 *     public static void show(Demo d)
 *     {
 *         d.x = 4;
 *     }
 * }
 */
