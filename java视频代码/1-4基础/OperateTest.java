/**
 * time:2019-04-27
 * author:Zhang Xiong
 */
public class OperateTest
{
    public static void main(String[] args)
    {
        //最有效率的算出2*8等于几
        System.out.println(2<<3);

        //对两个整数变量的值进行互换（不需第三方），最好还是用temp的方式，第三方变量形式，阅读性强
        //这种方法不要用，如果两个整数数值过大，会超出int范围，会强制转换，数据会变化
        int a = 3,b = 5;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a="+a+",b="+b);

        //不需第三方的第二种方法,阅读性差，面试的时候用
        int m = 5,n = 7;
        m = m ^ n;
        n = m ^ n;
        m = m ^ n;
        System.out.println("m="+m+",n="+n);

        //三元运算符 if else的简写格式，ifelse有具体结果时可以使用
        int x = 4,y;
        y = (x>6)?100:200;//true运行：前面，false运行：后
        System.out.println(y);

        /*
        获取两个整数中较大的整数
        int max = a>b?a:b;
         */

        {
            //局部代码块定义局部变量的生命周期
        }
    }
}
