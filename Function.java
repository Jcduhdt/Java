/**
 * time:2019-04-27
 * author:Zhang Xiong
 * 定义的函数级别是与main函数一致的啊，不要放在main里面，血泪教训
 * 定义函数的格式：
 * 修饰符 返回函数类型 函数名(参数类型 形式参数1，参数类型 形式参数2，...)
 * {
 *     执行语句;
 *     return 返回值;
 * }
 * 特殊情况：
 * 功能没有具体的返回值
 * 这时return后面直接用;结束
 * 返回值类型怎么体现呢，因为没有具体值，所以不可以写具体的数据类型
 * 在java中只能用一个关键字来表示这种情况 关键字为void
 * 总结：没有具体返回值时，返回值类型用void表示
 * 注意 如果返回值类型为void，那么函数中的return语句可省略不写
 */
public class Function
{
    public static void main(String[] args)
    {
        myprint();
        int x = add(3,5);//为啥会自动弹出a: b:
        System.out.println(x);
        System.out.println(getLevel(95));
    }

    public static void myprint()
    {
        System.out.println("hello java");
    }
    public static int add(int a,int b)
    {
        return a+b;
    }

    public static char getLevel(int num)
    {
        char level;
        if (num>=90 & num<=100)//也可以每次判断后直接return
            level = 'A';
        else if (num>=80 & num<90)
            level = 'B';
        if (num>=70 & num<80)
            level = 'C';
        else if (num>=60 & num<70)
            level = 'D';
        else
            level = 'E';
        return level;
    }
}
