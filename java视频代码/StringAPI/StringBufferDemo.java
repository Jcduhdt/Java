package cn.itcast.p2.stringBuffer.demo;

/**
 * @version V12.0.1 2019-7-8
 * @author Zhang Xiong
 */

/*
 * StringBuffer:就是字符串缓冲区
 * 用于存储数据的容器
 * 特点：
 * 1.长度是可变的
 * 2.可以存储不同类型的数据
 * 3.最终要转成字符串进行使用
 * 4.可以对字符串进行修改
 *
 * 既然是一个容器对象，应该具备什么功能呢？
 * 1.添加
 *      StringBuffer append(data);
 *      StringBuffer index(index,data);
 * 2.删除
 *      StringBuffer delete(start,end);包含头，不包含尾
 *      StringBuffer deleteChartAt(int index);删除指定元素
 * 3.查找
 *      char charAt(index);
 *      int indexOf(string);
 *      int lastIndexOf(string);
 * 4.修改
 *      StringBuffer replace(start,end,string);
 *      void setCharAt(index,char);
 *
 * 增删改查 C(create)U(update)R(read)D(delete)
 */
public class StringBufferDemo
{
    public static void main(String[] args)
    {
//        bufferMethodDemo();
//        bufferMethodDemo_1();
        bufferMethodDemo_2();
    }

    public static void bufferMethodDemo_2() {
        StringBuffer sb = new StringBuffer("abce");

//        sb.delete(1,3);//ae
        /*清空缓冲区
        sb.delete(0,sb.length());//用这个最好
        sb = new StringBuffer();*/
//        sb.setCharAt(2,'q');
//
//        sb.setLength(10);
//        System.out.println("sb:" + sb);
//        System.out.println("len:" + sb.length());

        System.out.println(sb.reverse());//反转
    }

    public static void bufferMethodDemo_1() {
        StringBuffer sb = new StringBuffer("abce");

        sb.insert(2,"qq");
        System.out.println(sb.toString());
    }

    public static void bufferMethodDemo()
    {
        //创建缓冲区对象
        StringBuffer sb = new StringBuffer();
        sb.append(4).append(false);
        sb.append(true);
        sb.insert(3,"haha");

        System.out.println(sb);
    }
}
