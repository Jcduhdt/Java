/**
 * time:2019-04-27
 * author:Zhang Xiong
 * 九九乘法表
 */
public class For99
{
    public static void main(String[] args)
    {
        for (int x=1;x<=9;x++)
        {
            for (int y=1;y<=x;y++)
            {
                System.out.print(y+"*"+x+"="+x*y+" ");
            }
            System.out.println();
        }
    }
}
