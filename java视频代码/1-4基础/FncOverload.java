/**
 * time:2019-04-27
 * author:Zhang Xiong
 * 函数的重载
 * 1：同一个类
 * 2：同名
 * 3：参数个数不同or参数类型不同
 * 4：jvm根据参数不同自动识别
 * 5：函数的重载和返回值类型无关
 * 6：java是严谨性语言，如果函数出现调用的不确定性，会编译失败
 */
public class FncOverload
{
    public static void main(String[] args)
    {
        System.out.println(add(3,8));
    }
    public static int add(int a,int b)
    {
        return a+b;
    }

    public static double add(double a,double b)
    {
        return a+b;
    }

    public static int add(int a,int b,int c)
    {
        return a+b+c;
    }
}
