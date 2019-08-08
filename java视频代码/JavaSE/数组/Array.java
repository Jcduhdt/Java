/**
 * time:2019-04-27
 * author:Zhang Xiong
 * 数组：元素类型[] 数组名 = new 元素类型[元素个数或数组长度]
 */
public class Array
{
    public static void main(String[] args)
    {
        int age = 3;
        //[]在java中表示数组
        int[] arr = new int[3];//声明了一个int类型的数组，数组名为arr 3个 默认值为0
        arr[0] = 89;

        System.out.println(arr[0]);//长度为3，角标只有0 1 2
        //System.out.println(arr[3]);//当访问到数组中不存在的角标时，就会发生异常
        /*
        arr = null;//这时arr就没地址了，被视作垃圾，在不定时时间内自动回收
        System.out.println(arr[0]);//NullPointerException
        //当引用型变量没有任何实体指向时，还在用其操作实体，就会引发该异常
        */

        //System.out.println(arr);//引发错误[I@5f184fc6  以@为分界线 右边是哈希值，为地址值，内存中存储位置16进制 不用关注
        //左边是实体类型 [ 表示数组类型  I 表示int类型  通过这种打印 可以看看数组的类型
    }
}

/*
内存的划分：
1：寄存器
2：本地方法区
3：方法区
4：栈内存：存储的都是局部变量，而且变量所属作用域一旦结束，该变量自动释放
5：堆内存：存储的是数组和对象（其实数组就是对象），凡是new（即开辟空间）建立在堆（存实体）中
           特点：1：每一个实体都有首地址值 上面就是给实体arr一个地址
                    若令arr = null;这时arr就没地址了，被视作垃圾，在不定时时间内自动回收
                 2：堆内存中的每一个变量都有默认初始化值，根据类型不同而不同，整数是0
                 3：垃圾回收机制

 */
