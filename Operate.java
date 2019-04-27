/**
 * time:2019-04-27 13:08:37
 * author:Zhang Xiong
 * 算术运算符和一些操作
 */
public class Operate
{
    public static void main(String[] args)
    {
        //算术运算符 + - * / %(取余)
        int x = 6370;
        int x1 = 6370;
        x = x / 1000 * 1000;
        x1 = x1 / 1000;
        System.out.println(x1);//因为是int类型
        System.out.println(x); //得到的值是6000,因为是int型，只保留整数

        System.out.println(5 % 2);
        System.out.println(3 + "2");//任何数据和字符串相加都是相连接,变成了字符串32
        System.out.println("5+5="+(5+5));//()优先级计算5+5
        int a = 4,b = 5;
        System.out.println("a="+a+",b="+b);
        a++;//可以独立运算，不用赋值，赋值的时候 ++在后，先赋值再自增
        System.out.println("a="+a);
        ++b;//++在前，先自增，再赋值
        System.out.println("b="+b);

        int i = 3;
        i = i++;//temp = i;i = i + 1;i = temp;
        System.out.println("i="+i);//结果是3，中转过程

        /*
        &&:和&运算结果一样，但是运算过程有区别
        &：无论左边的运算结果是什么，右边都参与运算
        &&：当左边为False时，右边不参与运算

        ||：同&&与&的区别，||左边为ture时，右边不参与计算
         */
        int j = 3;
        System.out.println(j>2 && j<5);

        //位运算 二进制的运算
        System.out.println(6 & 3);
        System.out.println(3 << 2);//3的二进制左移两位
        /*
        左移几位就是该数据乘以2的几次方，<<：可以完成2的次幂运算
        右移几位即是该数据乘以2的负几次方，小数舍去，高位空缺，符号位补以前的数，正数补0，负数补1
        >>>无符号右移高位出现空位，无论原高位是啥，空位都补0
        */
    }
}
