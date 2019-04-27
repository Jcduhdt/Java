/**
 * time:2019-04-27
 * author:Zhang Xiong
 * break:跳出所在的当前循环
 * 如果出现了循环嵌套，break想要跳出指定循环，可通过标号来完成
 * 作用范围：要么是switch语句，要么是循环语句
 * break单独存在时，后面的语句执行不到
 *
 * continue:继续
 * 作用范围：循环结构
 * 结束本次循环继续下次循环，continue单独存在时，后面的语句执行不到
 * continue想要继续指定循环，可通过标号来完成，同break
 */
public class BreakContiune
{
    public static void main(String[] args)
    {
        for (int x=0;x<3;x++)
        {
            for (int y=0;y<4;y++)
            {
                System.out.println("x="+x);
                break;
            }
        }

        System.out.println("-------------");
        xiaoming:for (int x=0;x<3;x++)
        {
            xiaoguang:for (int y=0;y<4;y++)
            {
                System.out.println("x="+x);
                break xiaoming;
            }
        }

        System.out.println("-------------");
        for (int x=0;x<11;x++)
        {
            if (x%2 == 0)
                continue;
            System.out.println("x="+x);//打印奇数
        }
    }
}
